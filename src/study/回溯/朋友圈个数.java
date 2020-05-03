package study.回溯;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/4/13 21:36
 */

public class 朋友圈个数 {
    public static void main(String[] args) {
        int [][]m=new int [][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        new 朋友圈个数().findCircleNum1(m);
    }
    public int findCircleNum(int[][] M) {
        int num=0,len=M.length;
        boolean visited[]=new boolean[len];
        for (int i = 0; i <len ; i++) {
            if(!visited[i]){
                num++;
                dfs(M,i,visited);
            }
        }
        return num;
    }
    public void dfs(int[][]M,int i,boolean [] visited){
        visited[i]=true;
        for (int j = 0; j <M.length ; j++) {
            if(M[i][j]==1&&!visited[j]){
                dfs(M,j,visited);
            }
        }
    }
    public int findCircleNum1(int[][] M) {
        int num=0,len=M.length;
        for (int i = 0; i <len ; i++) {
            if(M[i][i]==1) {
                num++;
                dfs(M, i, i);
            }
        }
        return num;
    }
    public void dfs(int[][]M,int r,int c){
        if(r<0||r>=M.length||c<0||c>=M.length||M[r][c]==0){
            return;
        }
        M[r][c]=0;
        for (int i = 0; i <M.length ; i++) {
            if(M[r][i]==1){
                M[r][i]=0;
                M[i][i]=0;
                dfs(M,i,r);
            }
        }
    }
}
