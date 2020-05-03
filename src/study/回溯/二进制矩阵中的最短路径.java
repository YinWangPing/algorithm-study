package study.回溯;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/4/13 10:19
 */

public class 二进制矩阵中的最短路径 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int row = sc.nextInt(), col = sc.nextInt();
            int[][] grids = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    grids[i][j] = sc.nextInt();
                }
            }
            System.out.println(shortestPath1(grids));
        }
    }

    private static int[][] directions = new int[][]{{1, 1}, {1, 0}, {1, -1}, {0, 1}, {0, -1}, {-1, 1}, {-1, 0}, {-1, -1}};

    public static int shortestPath(int[][] grids) {
        int row = grids.length, col = grids[0].length, minPath = 0;
        if (grids == null || row < 1 || col < 1) {
            return -1;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int size = queue.size();
            minPath++;
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                if (grids[poll[0]][poll[1]] == 1) {
                    continue;
                }
                if (poll[0] == row - 1 && poll[1] == col - 1) {
                    return minPath;
                }
                grids[poll[0]][poll[1]] = 1;
                for (int[] d : directions) {
                    int r = poll[0] + d[0], c = poll[1] + d[1];
                    if (r < 0 || r >= row || c < 0 || c >= col) {
                        continue;
                    }
                    queue.add(new int[]{r, c});
                }

            }
        }
        return -1;
    }
    public static int shortestPath1(int[][] grids) {
        int row = grids.length, col = grids[0].length, minPath = 0;
        if (grids == null || row < 1 || col < 1) {
            return -1;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        boolean visited[][]=new boolean[row][col];
        visited[0][0]=true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            minPath++;
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                if (poll[0] == row - 1 && poll[1] == col - 1) {
                    return minPath;
                }
                for (int[] d : directions) {
                    int r = poll[0] + d[0], c = poll[1] + d[1];
                    if (r < 0 || r >= row || c < 0 || c >= col||visited[r][c]||grids[poll[0]][poll[1]] == 1) {
                        continue;
                    }
                    visited[r][c]=true;
                    queue.add(new int[]{r, c});
                }

            }
        }
        return -1;
    }




    public static int shortestPath2(int[][] grids) {
        if(grids==null||grids.length<1||grids[0].length<1||grids[0][0]==1||grids[grids.length][grids[0].length]==1){
            return 1;
        }
        Queue<int[]>queue=new LinkedList<>();
        int row=grids.length,col=grids[0].length;
        boolean visited[][]=new boolean[row][col];
        queue.add(new int[]{0,0});
        int res=0;
        while (!queue.isEmpty()){
            int size=queue.size();
            res++;
            for (int i = 0; i <size ; i++) {
                int[]poll=queue.poll();
                if(poll[0]==row-1&&poll[1]==col-1){
                    return res;
                }
                for (int j = 0; j <directions.length ; j++) {
                    int r=poll[0]+directions[j][0],c=poll[1]+directions[j][1];
                    if(r<0||r>=row||c<0||c>=col||visited[r][c]||grids[r][c]==1){
                        continue;
                    }
                    queue.add(new int[]{r,c});
                    visited[r][c]=true;

                }
            }
        }
        return -1;
    }
}
