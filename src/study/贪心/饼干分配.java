package study.贪心;

import java.util.Arrays;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/5/2 22:43
 */

public class 饼干分配 {
    public int distributeCookies(int []people,int []cookies){
        if(people==null||cookies==null){
            return 0;
        }
        Arrays.sort(people);
        Arrays.sort(cookies);
        int ps=0,cs=0;
        while (ps<people.length&&cs<cookies.length){
            if(people[ps]<cookies[cs]){
                ps++;
            }
            cs++;
        }
        return ps;
    }
}
