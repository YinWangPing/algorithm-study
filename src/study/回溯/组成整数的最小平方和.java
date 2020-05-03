package study.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/4/13 11:50
 */

public class 组成整数的最小平方和 {
    public static void main(String[] args) {

    }

    public static int numSquares(int n) {
        boolean visited[] = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                int poll = queue.poll();
                int square = 1, diff = 3;
                for (; square <= n; ) {
                    int remain = poll - square;
                    square += diff;
                    diff += 2;
                    if (remain < 0) {
                        break;
                    }
                    if (remain == 0) {
                        return level;
                    }
                    if (visited[remain]) {
                        continue;
                    }
                    visited[remain] = true;
                    queue.add(remain);
                }
            }
        }
        return n;
    }

    public static int numSquares1(int n) {
        boolean visited[] = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> squares = generateSquares(n);
        queue.add(n);
        visited[n] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                int poll = queue.poll();
                for (int square : squares) {
                    int remain = poll - square;
                    if (remain < 0) {
                        break;
                    }
                    if (remain == 0) {
                        return level;
                    }
                    if (visited[remain]) {
                        continue;
                    }
                    visited[remain] = true;
                    queue.add(remain);
                }
            }
        }
        return n;
    }

    public static List<Integer> generateSquares(int n) {
        List<Integer> list = new ArrayList<>();
        int square = 1, diff = 3;
        while (square <= n) {
            list.add(square);
            square += diff;
            diff += 2;
        }
        return list;
    }
    public static int numSquares2(int n) {
        boolean visited[] = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = true;
        int res = 0;
        List<Integer> square = generateSquares(n);
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            for (int i = 0; i < size; i++) {
                int poll = queue.poll();
                for (int j = 0; j < square.size(); j++) {
                    int remain=poll-square.get(i);
                    if (remain<0) {
                        break;
                    }
                    if (remain==0) {
                        return res;
                    }
                    if(visited[remain]){
                        continue;
                    }
                    queue.add(remain);
                    visited[remain]=true;
                }
            }
        }
        return n;
    }
}
