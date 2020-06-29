package study.Vivo;

import java.util.List;

public class 智能手机锁 {
    public static void main(String[] args) {
        System.out.println(Integer.valueOf("3"));

//        int ret = 0;
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                boolean[][] visited = new boolean[3][3];
//                ret += bactracking(visited, i, j, 0, 1, 0);
//            }
//        }
        System.out.println(solution2(2,3));
    }

    /**
     * 实现方案
     *
     * @param m int整型 最少m个键
     * @param n int整型 最多n个键
     * @return int整型
     */
    static int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
    //    public int solution(int m, int n) {
//        // write code here
//
//    }
    static int res = 0;

    public static int bactracking(boolean[][] visited, int r, int c, int count, int target, int res) {
        if (count == target) {
            ++res;
        }
        if (r < 0 || r >= 3 || c < 0 || c >= 3 || count > target) {
            return 0;
        }
        if (visited[r][c] == false) {
            visited[r][c] = true;
            for (int[] d : directions) {
                bactracking(visited, r + d[0], c + d[1], count + 1, target, res);
            }
            visited[r][c] = false;
        } else if ((r + c) % 2 == 1 || (r == 1 && c == 1)) {
            for (int[] d : directions) {
                bactracking(visited, r + d[0], c + d[1], count, target, res);
            }
        }
        return res;

    }

    public static boolean bactracking(char[][] board, int r, int c, List<Character> list, String str) {
        if (list.size() == str.length()) {
            return true;
        }
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || list.size() > str.length() || board[r][c] != str.charAt(list.size())) {
            return false;
        }
        list.add(board[r][c]);
        for (int[] d : directions) {
            if (bactracking(board, r + d[0], c + d[1], list, str)) {
                return true;
            }
        }
        list.remove(list.size() - 1);
        return false;
    }


    public static int solution2(int m, int n) {
//         递归实现
        int count = 0;
        n = n > 9 ? 9 : n;
        for (int i = m; i <= n; i++) {
            boolean[][] flags = new boolean[3][3];
            for (int j = 0; j < 3; j++) {
                for (int t = 0; t < 3; t++) {
                    count += findNext(flags, j, t, 0, i);
                }
            }
        }
        return count;
    }

    public static int findNext(boolean[][] flags, int curRow, int curCol, int steps, int n) {
        int count = 0;
        steps++;
        flags[curRow][curCol] = true;
//         步数走完返回
        if (steps == n)
            return 1;
//         如果可以走，那么返回 1
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (flags[i][j] == false && canStep(flags, curRow, curCol, i, j)) {
                    count += findNext(flags, i, j, steps, n);
//                     恢复状态
                    flags[i][j] = false;
                }
            }
        }
        flags[curRow][curCol] = false;
        return count;
    }

    public static boolean canStep(boolean[][] flags, int curRow, int curCol, int targetRow, int targetCol) {
//         在同一行
        if (curRow == targetRow) {
            int low = curCol < targetCol ? curCol : targetCol;
            if (Math.abs(curCol - targetCol) > 1 && flags[curRow][low + 1] == false)
                return false;
        }
//         在同一列
        if (curCol == targetCol) {
            int low = curRow < targetRow ? curRow : targetRow;
            if (Math.abs(curRow - targetRow) > 1 && flags[low + 1][curCol] == false)
                return false;
        }
//         斜对角
        if (Math.abs(curRow - targetRow) == 2 && Math.abs(curCol - targetCol) == 2 && flags[1][1] == false)
            return false;
        return true;
    }
}
