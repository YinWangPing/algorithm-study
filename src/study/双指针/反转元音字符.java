package study.双指针;

import java.util.*;

public class 反转元音字符 {
    public static void main(String[] args) {
        System.out.println(new 反转元音字符().reverseVowels1("hello"));
    }
    public String reverseVowels(String s) {
        HashSet<Character>set=new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        if (s == null) return null;
        int i = 0, j = s.length() - 1;
        char[] result = new char[s.length()];
        while (i <= j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!set.contains(ci)) {
                result[i++] = ci;
            } else if (!set.contains(cj)) {
                result[j--] = cj;
            } else {
                result[i++] = cj;
                result[j--] = ci;
            }
        }
        return new String(result);
    }
    public String reverseVowels1(String s) {
        HashSet<Character>set=new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        if (s == null) return null;
        char[] result = new char[s.length()];
        Stack<Character> list=new Stack<>();
        for (int i = 0; i <s.length(); i++) {
            if(!set.contains(s.charAt(i))){
                result[i]=s.charAt(i);
            }else {
                list.add(s.charAt(i));
            }
        }
        for (int i = 0; i <s.length() ; i++) {
            if(result[i]=='\u0000'){
                result[i]=list.pop();
            }
        }
        return new String(result);
    }
}
