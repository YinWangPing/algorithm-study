package study.回溯;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/20 15:44
 */

public class 岛屿的最大连通面积 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(new 岛屿的最大连通面积().maxAreaOfIsland(nums, 2, 4));
        System.out.println(new 岛屿的最大连通面积().maxAreaOfIsland(nums));
    }

    private static int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static int maxAreaOfIsland(int[][] nums, int x, int y) {
        int maxArea = 0, row = nums.length, col = nums[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        boolean visited[][] = new boolean[row][col];
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                if (nums[poll[0]][poll[1]] == 1) {
                    maxArea += 1;
                }
                for (int[] d : directions) {
                    int r = poll[0] + d[0], c = poll[1] + d[1];
                    if (r < 0 || r >= row || c < 0 || c >= col || visited[r][c] || nums[poll[0]][poll[1]] == 0) {
                        continue;
                    }
                    visited[r][c] = true;
                    queue.add(new int[]{r, c});
                }
            }

        }
        return maxArea;
    }

    public static int maxAreaOfIsland(int[][] nums) {
        int max = 0;
        int row = nums.length, col = nums[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(nums[i][j]==1) {
                    int maxArea = getMaxArea(nums, i, j);
                    max = Math.max(maxArea, max);
                }
            }
        }
        return max;
    }

    public static int getMaxArea(int[][] nums, int i, int j) {
        if (i < 0 || i >= nums.length || j < 0 || j >= nums[0].length || nums[i][j] == 0) {
            return 0;
        }
        nums[i][j] = 0;
        return getMaxArea(nums, i + 1, j) + getMaxArea(nums, i - 1, j) +
                getMaxArea(nums, i, j + 1) + getMaxArea(nums, i, j - 1) + 1;
    }



    public static int maxAreaOfIsland1(int[][] grid) {
        int row=grid.length,col=grid[0].length;
        int maxArea=0;
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <col ; j++) {
                int max=getMaxAreaOfIsland(grid,i,j);
                maxArea=Math.max(max,maxArea);
            }
        }
        return maxArea;
    }
    public static int getMaxAreaOfIsland(int [][]grid,int r,int c){
        if(r<0||r>=grid.length||c<0||c>=grid[0].length||grid[r][c]==0){
            return 0;
        }
        grid[r][c]=0;
        return getMaxAreaOfIsland(grid,r+1,c)+getMaxAreaOfIsland(grid,r-1,c)
                +getMaxAreaOfIsland(grid,r,c+1)+getMaxAreaOfIsland(grid,r,c-1)+1;
    }

    public static int maxAreaOfIsland2(int[][] grid) {
        int row=grid.length,col=grid[0].length;
        int maxArea=0;
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <col ; j++) {
                int max=getMaxAreaOfIsland(grid,i,j);
                maxArea=Math.max(max,maxArea);
            }
        }
        return maxArea;
    }



























//    public int maxAreaOfIsland(int[][] grid) {
//        int maxArea = 0;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//                //计算最大面积
//                int currMaxArea = getMaxArea(i, j, grid);
//                maxArea = Math.max(currMaxArea, maxArea);
//            }
//        }
//
//        return maxArea;
//    }
//
//    private int getMaxArea(int i, int j, int[][] grid) {
//        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
//            return 0;
//        }
//        //通过将经过的岛屿设置为0来确保下次不会重复访问
//        grid[i][j] = 0;
//
//        int upMaxArea = getMaxArea(i - 1, j, grid);
//
//        int downMaxArea = getMaxArea(i + 1, j, grid);
//
//        int leftMaxArea = getMaxArea(i, j - 1, grid);
//
//        int rightMaxArea = getMaxArea(i, j + 1, grid);
//
//        return upMaxArea + downMaxArea + leftMaxArea + rightMaxArea + 1;
//    }
}
