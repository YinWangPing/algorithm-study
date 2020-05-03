package study.剑指offer;

/**
 * @description:将一个字符串中的空格替换成 "%20"
 * @author: WangPingYin
 * @time: 2020/2/13 11:52
 */

public class 替换空格 {
    public static void main(String[] args) {
        String str = "We are  happy .";
        System.out.println(replaceSpace0(str, " ", "%20"));
        System.out.println(replaceSpace1(str, " ", "%20"));
        System.out.println(replaceSpace2(str));
    }
    /**
     *使用str自带的replace方法
     */
    public static String replaceSpace0(String str, String ori, String des) {
        return str.replace(ori, des);
    }
    /**
     *str的split方法，以及join方法
     */
    public static String replaceSpace1(String str, String ori, String des) {
        String[] res = str.split(ori);
        return String.join(des, res);
    }
    /**
     *先将String转为Stringbuffer，在根据空格的个数进行扩容
     * 最后从原String最后一个开始，不为空格则移至最后，否则进行替换（倒着进行）
     */
    public static String replaceSpace2(String string) {
        StringBuffer str = new StringBuffer(string);
        int P1 = str.length() - 1;
        for (int i = 0; i <= P1; i++)
            if (str.charAt(i) == ' ')
                str.append("  ");

        int P2 = str.length() - 1;
        while (P1 >= 0 && P2 > P1) {
            char c = str.charAt(P1--);
            if (c == ' ') {
                str.setCharAt(P2--, '0');
                str.setCharAt(P2--, '2');
                str.setCharAt(P2--, '%');
            } else {
                str.setCharAt(P2--, c);
            }
        }
        return str.toString();
    }
}
