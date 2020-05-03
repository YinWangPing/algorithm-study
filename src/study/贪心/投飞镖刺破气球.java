package study.贪心;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/5/2 23:07
 */

public class 投飞镖刺破气球 {
    public int findMinArrowShots(int[][] points) {
        if(points.length==0){
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int count=1,end=points[0][1];
        for (int i = 0; i <points.length ; i++) {
            if(end<points[i][0]){
                count++;
                end=points[i][1];
            }
        }
        return count;
    }
}
