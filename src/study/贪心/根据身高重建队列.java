package study.贪心;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/5/2 23:22
 */

public class 根据身高重建队列 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }else {
                    return o2[0]-o1[0];
                }
            }
        });
        List<int[]>list=new ArrayList<>();
        for (int []p:people) {
            list.add(p[1],p);
        }
        return list.toArray(new int[people.length][2]);
    }
}
