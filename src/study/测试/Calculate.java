package study.测试;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/22 10:17
 */

public class Calculate {
    public static void main(String[] args) {
        int num=0;
        for (int i = 0; i <100 ; i++) {
            int temp=num+i+2;
            num+=temp;
        }
    }
}
