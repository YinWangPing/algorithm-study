import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/17 20:39
 */

public class NthUglyNumber {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber1(10));
    }

    public static int nthUglyNumber(int index) {
        if (index == 0) {
            return 0;
        }
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        long[] primes = new long[]{2, 3, 5};
        for (long prime : primes) {
            priorityQueue.offer(prime);
            set.add(prime);
        }
        long num = 1;
        for (int i = 1; i < index; i++) {
            num = priorityQueue.poll();
            for (int j = 0; j < 3; j++) {
                if (!set.contains(num * primes[j])) {
                    priorityQueue.offer(num * primes[j]);
                    set.add(num * primes[j]);
                }
            }
        }
        return (int) num;
    }

    public static int nthUglyNumber1(int n) {
        int[] res = new int[n];
        res[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            // 更新数组
            res[i] = Math.min(res[p2] * 2, Math.min(res[p3] * 3, res[p5] * 5));
            // 移动指针
            if (res[i] == res[p2] * 2) p2++;
            if (res[i] == res[p3] * 3) p3++;
            if (res[i] == res[p5] * 5) p5++;
        }
        return res[n - 1];
    }
}
