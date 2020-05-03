package study.回溯;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/4/12 16:18
 */

public class 疫情办公 {
    public static void main(String[] args) {
        String [] str=new String[]{
                "*.**.","*.***","*.**."
        };
        System.out.println(maxArea(str));
    }

    public int GetMaxStaffs (char[][] pos) {
        int count=0;
        for(int i=0;i<pos.length;i++) {
            for(int j=0;j<pos[i].length;j++) {
                if(pos[i][j]=='.') {
                    count++;
                    if(i+1<pos.length) pos[i+1][j]='*';;
                    j++;

                }

            }

        }
        return count;
    }
    private static int[][]directions=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public static int maxAreaOfIsland(int [][]nums){
        int maxArea=0,row=nums.length,col=nums[0].length;
        Queue<int []> queue=new LinkedList<>();
        queue.add(new int[]{0,0});
        boolean visited[][]=new boolean[row][col];
        visited[0][0]=true;
        while (!queue.isEmpty()){
            int size=queue.size();
            for (int i = 0; i <size ; i++) {
                int []poll=queue.poll();
                if(nums[poll[0]][poll[1]]==1){
                    maxArea+=1;
                }
                for (int [] d:directions) {
                    int r=poll[0]+d[0],c=poll[1]+d[1];
                    if(r<0||r>=row||c<0||c>=col||visited[r][c]||nums[poll[0]][poll[1]]==0){
                        continue;
                    }
                    visited[r][c]=true;
                    queue.add(new int[]{r,c});
                }
            }

        }
        return maxArea;
    }
    private static int count=0;
    public static int maxArea(String[] str){
        int max=0;
        int row=str.length,col=str[0].length();
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <col ; j++) {
                count=0;
                int maxArea=getMaxArea(str,i,j);
                max=Math.max(maxArea,max);
            }
        }
        return max;
    }
    public static int getMaxArea(String []str,int i,int j){
        boolean[][]visited=new boolean[str.length][str[0].length()];
        if(i<0||i>=str.length||j<0||j>=str[0].length()||!canSet(visited,i,j)||str[i].charAt(j)=='*'){
            return 0;
        }
        visited[i][j]=true;
        count++;
        return getMaxArea(str,i+1,j)+getMaxArea(str,i-1,j)+
                getMaxArea(str,i,j+1)+getMaxArea(str,i,j-1)+1;
    }
    public static boolean canSet(boolean [][]visited,int i,int j){
        boolean flag=true;
        if((i-1>=0&&visited[i-1][j])||(j-1>=0&&visited[i][j-1])
                ||(i+1<visited.length&&visited[i+1][j])||(j+1<visited[0].length&&visited[i][j+1])){
            flag=false;
        }
        return flag;
    }
}
