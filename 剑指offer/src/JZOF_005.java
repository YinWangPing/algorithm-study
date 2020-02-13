/**
 * @description:将一个字符串中的空格替换成 "%20"
 * @author: WangPingYin
 * @time: 2020/2/13 11:52
 */

public class JZOF_005 {
    public static void main(String[] args) {
        String str = "We are  happy .";
        System.out.println(replaceSpace0(str," ","%20"));
        System.out.println(replaceSpace1(str," ","%20"));
        System.out.println(replaceSpace2(str," ","%20"));
    }
    public static String replaceSpace0(String str,String ori,String des){
        return str.replace(ori,des);
    }
    public static String replaceSpace1(String str,String ori,String des){
        String [] res=str.split(ori);
        return String.join(des,res);
    }
    public String replaceSpace2(StringBuffer str) {
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
