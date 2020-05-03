package study.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/4/28 21:33
 */

public class 矩阵中的字符串 {
    public static void main(String[] args) {
        char[][] board=new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(exist(board,"ABCB"));
    }
    static int [][] directions=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public static boolean exist(char [][]board,String str){
        if(str.length()>board.length*board[0].length){
            return false;
        }
        List<Character>list=new ArrayList<>();
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[0].length ; j++) {
                if(board[i][j]==str.charAt(0)){
                    if(bactracking(board,i,j,list,str)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean bactracking(char [][] board,int r,int c,List<Character>list,String str){
        if(list.size()==str.length()){
            return true;
        }
        if(r<0||r>=board.length||c<0||c>=board[0].length||list.size()>str.length()||board[r][c]!=str.charAt(list.size())){
            return false;
        }
        list.add(board[r][c]);
        for (int []d:directions) {
            if(bactracking(board,r+d[0],c+d[1],list,str)){
                return true;
            }
        }
        list.remove(list.size()-1);
        return false;
    }



    public static boolean exist1(char [][]board,String str){
        if(str.length()>board.length*board[0].length){
            return false;
        }
        boolean [][]visited=new boolean[board.length][board[0].length];
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[0].length ; j++) {
                if(board[i][j]==str.charAt(0)){
                    if(bactracking(board,i,j,0,str,visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean bactracking(char [][] board,int r,int c,int currLen,String str,boolean [][]visited){
        if(currLen==str.length()){
            return true;
        }
        if(r<0||r>=board.length||c<0||c>=board[0].length||board[r][c]!=str.charAt(currLen)||visited[r][c]){
            return false;
        }
        visited[r][c]=true;
        for (int []d:directions) {
            if (bactracking(board,r+d[0],c+d[1],currLen+1,str,visited)){
                return true;
            }
        }
        visited[r][c]=false;
        return false;
    }
}
