package study.回溯;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/4/13 21:16
 */

public class 矩阵中的连通分量数目 {
    public static void main(String[] args) {
//        int [][]
    }
    public static int numIslands(char[][] grid) {
        int nums=0;
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j <grid[0].length ; j++) {
                if(grid[i][j]=='1'){
                    calculate(grid,i,j);
                    nums++;
                }
            }
        }
        return nums;
    }
    private static int [][]directions=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public static int calculate(char [][]grid,int r,int c){
        if(r<0||r>=grid.length||c<0||c>=grid[0].length||grid[r][c]=='0'){
            return 0;
        }
        grid[r][c]='0';
        int res=1;
        for (int []d:directions) {
            res+=calculate(grid,r+d[0],c+d[1]);
        }
        return res;
    }
}
