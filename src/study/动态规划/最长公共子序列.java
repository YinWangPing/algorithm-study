package study.动态规划;
/*
给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
若这两个字符串没有公共子序列，则返回 0。
 */
public class 最长公共子序列 {
    public static void main(String[] args) {

    }
    /**
     * @description:时间复杂度O(M*N)，空间复杂度O(M*N)。
     *
     * 在使用动态规划之前先规定一下符号，给定一个序列X=<x1,x2,...,xmx1,x2,...,xm>，定义XiXi为X的前缀，即XiXi=<x1,x2,...,xix1,x2,...,xi>。
     * 在求X=<x1,x2,...,xmx1,x2,...,xm>和Y=<y1,y2,...,yny1,y2,...,yn>的一个LCS时，我们需要求解一个或者两个子问题。如果xm=ynxm=yn，那么我们应该求解xm−1=yn−1xm−1=yn−1的一个LCS。如果xm≠ynxm≠yn，我们必须求解两个子问题：求Xm−1Xm−1和YY的一个LCS与XX和Yn−1Yn−1的一个LCS。两个LCS中较长的一个，即为X和Y的一个LCS，经过推理可知，这些子情况覆盖了所有可能出现的情况。
     * @author: ywp
     * @time: 2020/6/16 18:01
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int len1=text1.length(),len2=text2.length();
        int [][]dp=new int[len1+1][len2+1];
        for (int i = 1; i <=len1 ; i++) {
            for (int j = 1; j <=len2 ; j++) {
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[len1][len2];
    }
}
