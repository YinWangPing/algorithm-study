package study.回溯;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/4/14 9:16
 */

public class 填充围绕区域 {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'X', 'O', 'X', 'O', 'X', 'O'}, {'O', 'X', 'O', 'X', 'O', 'X'}, {'X', 'O', 'X', 'O', 'X', 'O'}, {'O', 'X', 'O', 'X', 'O', 'X'}};
        new 填充围绕区域().solve(board);
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int row = board.length, col = board[0].length;
        boolean visited[][] = new boolean[row][col];
        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i, visited);
            }
            if (board[row - 1][i] == 'O') {
                dfs(board, row - 1, i, visited);
            }
        }
        for (int i = 1; i < col - 1; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0, visited);
            }
            if (board[i][col - 1] == 'O') {
                dfs(board, i, col - 1, visited);
            }
        }
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public void dfs(char[][] board, int r, int c, boolean[][] visited) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || visited[r][c] || board[r][c] == 'X') {
            return;
        }
        visited[r][c] = true;
        for (int[] d : directions) {
            dfs(board, r + d[0], c + d[1], visited);
        }
    }
}
