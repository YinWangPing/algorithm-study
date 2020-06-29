package study.动态规划;

public class 最长连续公共子序列 {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("acbacddddd","acaccbacbbddddd "));
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        int len1=text1.length(),len2=text2.length();
        int [][]dp=new int[len1+1][len2+1];
        int maxlen=0;
        for (int i = 1; i <=len1 ; i++) {
            for (int j = 1; j <=len2 ; j++) {
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    if(maxlen<dp[i][j]){
                        maxlen=dp[i][j];
                    }
                }else {
                    dp[i][j]=0;
                }
            }
        }
        return maxlen;
    }
}
