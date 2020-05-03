package study.贪心;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/5/2 22:57
 */

public class 无重叠区间 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==0){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int count=1;
        int end=intervals[0][1];
        for (int i = 1; i <intervals.length ; i++) {
            if(end<intervals[i][0]){
                count++;
                end=intervals[i][1];
            }
        }
        return count;
    }
}
