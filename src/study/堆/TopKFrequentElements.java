package study.堆;

import java.util.*;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/16 20:56
 */

public class TopKFrequentElements {
    public static void main(String[] args) {
        int [] nums=new int[]{1,1,1,2,2,2,3,3,3};
        List<Integer> res=topKFrequent1(nums,2);
        for (int i:res) {
            System.out.println(i);
        }
    }
    /**
     *小顶堆
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int val = map.getOrDefault(num, 0);
            map.put(num, val + 1);
        }
//        Comparator<Integer> cmp = (i1, i2) -> map.get(i1) - map.get(i2);
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>(cmp);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1)-map.get(o2);
            }
        });
        for (Integer key: map.keySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(key);
            } else if (map.get(key) > map.get(minHeap.peek())){//获取堆顶值但不弹出，若新加入值较大则入队列，堆顶弹出
                minHeap.poll();
                minHeap.offer(key);
            }
        }

        List<Integer> result = new ArrayList<>(k);
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        Collections.reverse(result);
        return result;
    }
    /**
     *桶排序
     */
    public static List<Integer> topKFrequent1(int[] nums, int k) {
        //将数组的元素及其出现次数放入HashMap当中
        HashMap<Integer, Integer> map = new HashMap();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        //建立一个List数组（桶），下标是出现次数，元素是ArrayList，ArrayList内容是num
        List<Integer>[] buckets = new ArrayList[nums.length+1];
        for(int num : map.keySet()){
            int fre = map.get(num);
            if(buckets[fre] == null){
                buckets[fre] = new ArrayList();
            }
            buckets[fre].add(num);
        }

        //从桶中拿出频率最大的前K个元素
        List<Integer> ans = new ArrayList();
        for(int i = nums.length; i>=0 && k>0; i--){
            if(buckets[i]!=null){
                for(int j=0;j<buckets[i].size() && k>0;j++,k--){
                    ans.add(buckets[i].get(j));
                }
            }
        }
        return ans;
    }
}
