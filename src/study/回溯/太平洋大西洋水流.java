package study.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/4/14 9:58
 */

public class 太平洋大西洋水流 {
    public static void main(String[] args) {
        String [][]s={{"helloworld","hello world"},{"this is","a java program"}};

        System.out.println((new StringTokenizer(s[1][1])).countTokens());
    }
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>>lists=new ArrayList<>();
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return lists;
        }
        int row=matrix.length,col=matrix[0].length;
        boolean visitedA[][]=new boolean[matrix.length][matrix[0].length];
        boolean visitedB[][]=new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i <row ; i++) {
            dfs(matrix,i,0,visitedA);
            dfs(matrix,i,col-1,visitedB);
        }
        for (int i = 1; i <col-1 ; i++) {
            dfs(matrix,0,i,visitedA);
            dfs(matrix,row-1,i,visitedB);
        }
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <row ; j++) {
                if(visitedA[i][j]&&visitedB[i][j]){
                    lists.add(Arrays.asList(i,j));
                }
            }
        }
        return lists;
    }
    public void dfs(int [][]matrix,int r,int c,boolean [][]visited){
        if(visited[r][c]){
            return;
        }
        visited[r][c]=true;
        for (int[] d : directions) {
            int row=r+d[0],col=c+d[1];
            if(row<0||row>=matrix.length||col<0||col>=matrix.length||visited[row][col]||matrix[row][col]<matrix[r][c]){
                continue;
            }
            dfs(matrix, r + d[0], c + d[1], visited);
        }
    }
    public List<List<Integer>> pacificAtlantic1(int[][] matrix) {
        List<List<Integer>>lists=new ArrayList<>();
        boolean visited[][]=new boolean[matrix.length][matrix[0].length];
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return lists;
        }
        int min=Math.min(matrix.length,matrix[0].length);
        for (int i = 0; i <min ; i++) {
            dfs1(matrix,matrix.length-i-1,0+i,visited,matrix[matrix.length-1][0],lists);
        }
        return lists;
    }
    private int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public void dfs1(int [][]matrix,int r,int c,boolean [][]visited,int pre,List<List<Integer>>lists){
        if(r<0||r>=matrix.length||c<0||c>=matrix.length||visited[r][c]||matrix[r][c]<pre){
            return;
        }
        visited[r][c]=true;
        ArrayList list=new ArrayList();
        list.add(r);
        list.add(c);
        lists.add(list);
        for (int[] d : directions) {
            dfs1(matrix, r + d[0], c + d[1], visited,matrix[r][c],lists);
        }
    }
}
