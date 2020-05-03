package study.回溯;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @description:N*N的矩阵，'.'表示道路，'#'表示障碍，'1-9'表示物资,求能收集的物资数
 * @input: 第一行n，下面n行数据，最后一行初始位置
 * @author: WangPingYin
 * @time: 2020/4/12 10:52
 */
/*6
..1.#.
2##3#8
.#.##.
.#6#9.
4###..
..7..5
0 0 */
public class 荒野行动 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int n = Integer.valueOf(sc.nextLine().trim());
            String[] str = new String[n];
            for (int i = 0; i < n; i++) {
                str[i] = sc.nextLine();
            }
            String[] pos = sc.nextLine().trim().split(" ");
            int[] start = new int[]{Integer.valueOf(pos[0]), Integer.valueOf(pos[1])};
            System.out.println(calculate(str, start));
            System.out.println(maxProfit(str, start));
        }

    }

    private static int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static int maxProfit(String[] str, int[] start) {
        int row = str.length, col = str[0].length(), res = 0;
        boolean visited[][] = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                if (str[poll[0]].charAt(poll[1]) >= '1' && str[poll[0]].charAt(poll[1]) <= '9') {
                    res += str[poll[0]].charAt(poll[1]) - '0';
                }
                for (int[] d : directions) {
                    int r = poll[0] + d[0], c = poll[1] + d[1];
                    if (r < 0 || r >= row || c < 0 || c >= col || visited[r][c] || str[poll[0]].charAt(poll[1]) == '#') {
                        continue;
                    }
                    visited[r][c] = true;
                    queue.add(new int[]{r, c});
                }
            }
        }
        return res;
    }

    public static int calculate(String[] str, int[] start) {
        int n = str.length, res = 0;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                if (str[poll[0]].charAt(poll[1]) >= '1' && str[poll[0]].charAt(poll[1]) <= '9') {
                    res += str[poll[0]].charAt(poll[1]) - '0';
                }
                for (int[] d : directions) {
                    int r = poll[0] + d[0], c = poll[1] + d[1];
                    if (r < 0 || r >= n || c < 0 || c >= n || visited[r][c] || str[poll[0]].charAt(poll[1]) == '#') {
                        continue;
                    }
                    queue.add(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }
        return res;
    }


//    public static int calculate(String[] str, int[] start) {
//        int n = str.length;
//        Queue<int[]> queue = new LinkedList<>();
//        boolean[][] visited = new boolean[n][n];
//        queue.add(start);
//        visited[start[0]][start[1]] = true;
//        int res = 0;
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                int[] poll = queue.poll();
//                if (str[poll[0]].charAt(poll[1]) <= '9' && str[poll[0]].charAt(poll[1]) >= '1')
//                    res += str[poll[0]].charAt(poll[1]) - '0';
//                for (int[] d : directions) {
//                    int r = poll[0] + d[0], c = poll[1] + d[1];
//                    if (r < 0 || r >= n || c < 0 || c >= n || visited[r][c] || str[poll[0]].charAt(poll[1]) == '#') {
//                        continue;
//                    }
//                    visited[r][c] = true;
//                    queue.add(new int[]{r, c});
//                }
//            }
//        }
//        return res;
//    }

    public static int calculate1(String[] str, int[] start) {
        int n = str.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        queue.add(start);
        visited[start[0]][start[1]] = true;
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] top = queue.poll();
                int x = top[0], y = top[1];
                if (str[x].charAt(y) <= '9' && str[x].charAt(y) >= '1') res += str[x].charAt(y) - '0';
                for (int k = 0; k < 4; k++) {
                    int newX = x + directions[k][0];
                    int newY = y + directions[k][1];
                    if (newX < 0 || newX >= n || newY < 0 || newY >= n || visited[newX][newY] || str[x].charAt(y) == '#')
                        continue;
                    visited[newX][newY] = true;
                    queue.add(new int[]{newX, newY});
                }
            }
        }
        return res;
    }
}
