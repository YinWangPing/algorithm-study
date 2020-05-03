package study.动态规划;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/4/4 21:21
 */

public class 矩阵最小最大路径和 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        System.out.println(maxPathSum(nums));
    }
    //----------------------------------------------------------
    /**
     * 题目描述：求从矩阵的左上角到右下角的最小路径和，每次只能向右和向下移动。
     */
    public static int minPathSum(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        if (rows == 0 || cols == 0) {
            return 0;
        }
        int[] dp = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j == 0) {
                    dp[j] = dp[j] + grid[i][j];//从上方来
                } else if (i == 0) {
                    dp[j] = dp[j - 1] + grid[i][j];//从左侧来
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
                }
            }
        }
        return dp[cols - 1];
    }


    //----------------------------------------------------------
    /**
     * 题目描述：求从矩阵的左上角到右下角的最小路径和，每次只能向右和向下移动。
     */
    public static int maxPathSum(int[][] grid) {
        int rows=grid.length,cols=grid[0].length;
        int[]res=new int[cols];
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <cols ; j++) {
                if(j==0){
                    res[j]=res[j]+grid[i][j];
                }else if(i==0){
                    res[j]=res[j-1]+grid[i][j];
                }else {
                    res[j]=Math.max(res[j],res[j-1])+grid[i][j];
                }
            }
        }
        return res[cols-1];
    }
}
