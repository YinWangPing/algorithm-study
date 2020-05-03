/**
 * @description:斐波那契数列，青蛙跳台阶，长方体填充,变态跳台阶
 * @author: WangPingYin
 * @time: 2020/2/14 14:42
 */

public class 斐波那契数列相关 {
    public static void main(String[] args) {
//        System.out.println(fibonacci0(4));
//        System.out.println(fibonacci1(4));
//        System.out.println(fibonacci2(4));
        System.out.println(jumpFloor0(7));
        System.out.println(jumpFloor1(7));
        System.out.println(jumpFloor2(7));
    }
    /*----------------------------------------------------------*/
    /*斐波那契数列*/

    /**
     * 递归
     */
    public static int fibonacci0(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci0(n - 1) + fibonacci0(n - 2);
    }

    /**
     * study.动态规划,将结果保存至一个大小为n的数组
     */
    public static int fibonacci1(int n) {
        if (n <= 1) {
            return n;
        }
        int result[] = new int[n + 1];
        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n];
    }

    /**
     * study.动态规划,保存前两个值即可
     */
    public static int fibonacci2(int n) {
        if (n <= 1) {
            return n;
        }
        int num0 = 0, num1 = 1;
        for (int i = 2; i <= n; i++) {
            int temp = num0 + num1;
            num0 = num1;
            num1 = temp;
        }
        return num1;
    }
    /*----------------------------------------------------------*/
    /*青蛙跳台阶一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
    求该青蛙跳上一个n级的台阶总共有多少种跳法。*/

    /**
     * 递归
     */
    public static int jumpFloor0(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return jumpFloor0(n - 1) + jumpFloor0(n - 2);
    }

    /**
     * study.动态规划,新建大小为n+1的辅助数组
     */
    public static int jumpFloor1(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int result[] = new int[n + 1];
        result[1] = 1;
        result[2] = 2;
        for (int i = 3; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n];
    }

    /**
     * study.动态规划，
     */
    public static int jumpFloor2(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int pre1 = 1, pre2 = 2;
        for (int i = 3; i <= n; i++) {
            int temp = pre1 + pre2;
            pre1 = pre2;
            pre2 = temp;
        }
        return pre2;
    }
    /*----------------------------------------------------------*/
    /*将一个2*1的长方体填充到2*n的长方体中，有多少种方法。*/

    /**
     * 递归
     */
    public static int fillRectangle0(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return jumpFloor0(n - 1) + jumpFloor0(n - 2);
    }

    /**
     * study.动态规划,新建大小为n+1的辅助数组
     */
    public static int fillRectangle1(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int result[] = new int[n + 1];
        result[1] = 1;
        result[2] = 2;
        for (int i = 3; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n];
    }

    /**
     * study.动态规划，
     */
    public static int fillRectangle2(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int pre1 = 1, pre2 = 2;
        for (int i = 3; i <= n; i++) {
            int temp = pre1 + pre2;
            pre1 = pre2;
            pre2 = temp;
        }
        return pre2;
    }
    /*----------------------------------------------------------*/
    /*一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。*/

    /**分析
     *跳上 n-1 级台阶，可以从 n-2 级跳 1 级上去，也可以从 n-3 级跳 2 级上去...，那么
     * f(n-1) = f(n-2) + f(n-3) + ... + f(0)
     * 同样，跳上 n 级台阶，可以从 n-1 级跳 1 级上去，也可以从 n-2 级跳 2 级上去... ，那么
     * f(n) = f(n-1) + f(n-2) + ... + f(0)
     * 综上可得f(n) - f(n-1) = f(n-1)
     */
    public static int btJumpFloor(int n) {
        return (int)Math.pow(2,n-1);
    }

}
