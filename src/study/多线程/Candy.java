import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/16 15:34
 */

public class Candy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line1 = sc.nextLine();
            String line2 = sc.nextLine();
            System.out.println(calculate(transfer(line1), transfer(line2)));
            System.out.println("-----------------");
            System.out.println(calculae1(line1,line2));
        }

    }

    public static int[] transfer(String string) {
        String[] str = string.split(" ");
        int[] res = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            res[i] = Integer.valueOf(str[i]);
        }
        return res;
    }

    public static int calculate(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int count = 0, sizea = a.length - 1, sizeb = b.length - 1;
        while (sizea >= 0 && sizeb >= 0) {
            if (a[sizea] <= b[sizeb]) {
                count++;
                sizea--;
                sizeb--;
            } else {
                sizea--;
            }
        }
        return count;
    }

    public static int calculae1(String line1, String line2) {
        String[] stra = line1.split(" ");
        String[] strb = line2.split(" ");
        Arrays.sort(stra);
        Arrays.sort(strb);
        int count = 0, sizea = stra.length - 1, sizeb = strb.length - 1;
        while (sizea >= 0 && sizeb >= 0) {
            if (Integer.valueOf(stra[sizea]) <= Integer.valueOf(strb[sizeb])) {
                count++;
                sizea--;
                sizeb--;
            } else {
                sizea--;
            }
        }
        return count;
    }
}
