package study.动态规划;

import java.util.Arrays;

public class 分割整数构成字母字符串 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            int one = s.charAt(i - 1) - '0';
            if (one != 0) {
                dp[i] += dp[i - 1];
            }
            if (s.charAt(i - 2) == '0') {
                continue;
            }
            int two = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
            if (two <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    public int numDecodings1(String s) {
        if (s == null || s.length() == 0||s.charAt(0) == '0') {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp,1);
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    dp[i] = dp[i - 1];
                } else return 0;
            } else {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) > '0' && s.charAt(i) < '7') {
                    dp[i + 1] = dp[i - 1] + dp[i];
                } else dp[i + 1] = dp[i];
            }
        }
        return dp[n];
    }





    public int numDecodings2(String s) {
        if(s.length()==0||s==null){
            return 0;
        }
        int len=s.length();
        int []dp=new int[len+1];
        dp[0]=1;
        dp[1]=1;
        for (int i =1; i < len; i++) {
            if(s.charAt(i)!='0'){
                dp[i+1]=dp[i];
            }
            int num=10*(s.charAt(i-1)-'0')+s.charAt(i)-'0';
            if(num>=10&&num<=26){
                dp[i+1]+=dp[i-1];
            }
        }
        return dp[len];
    }
    public int numDecodings3(String s) {
        if(s.length()==0||s==null||s.charAt(0)=='0'){
            return 0;
        }
        int len=s.length();
        int []dp=new int[len];
        dp[0]=1;
        for (int i = 1; i < len; i++) {
            if(s.charAt(i)!='0'){
                dp[i]=dp[i-1];
            }
            int num=10*(s.charAt(i-1)-'0')+s.charAt(i)-'0';
            if(num>=10&&num<=26){
                if(i==1){
                    dp[i]++;
                }else {
                    dp[i]+=dp[i-2];
                }
            }
        }
        return dp[len-1];
    }
}
