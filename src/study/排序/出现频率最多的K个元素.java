package study.排序;

import java.util.*;

public class 出现频率最多的K个元素 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer>map=new HashMap<>();
        for (int i:nums) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        List<Map.Entry<Integer,Integer>> list=new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        int []res=new int[k];
        for (int i = 0; i <k ; i++) {
            res[i]=list.get(i).getKey();
        }
        return res;
    }
}
