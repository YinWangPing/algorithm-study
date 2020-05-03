package study.贪心;

public class 判断是否为子序列 {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc","addddbnnnc"));
    }
    public static boolean isSubsequence(String s, String t) {
        if(s.length()==0){
            return true;
        }
        int index=0;
        for (int i = 0; i <t.length() ; i++) {
            if(t.charAt(i)==s.charAt(index)){
                index++;
            }
            if(index==s.length()){
                return true;
            }
        }
        return index==s.length();
    }
}
