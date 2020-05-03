package study.栈与队列;

import java.util.Stack;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/17 17:10
 */

public class DecodeString {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
    }
    public static String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<String> result = new Stack<>();
        result.push("");

        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {  // 数字
                int start = i;
                while (Character.isDigit(s.charAt(i+1))) {
                    i ++;
                }
                count.push(Integer.parseInt(s.substring(start, i+1)));
            } else if (ch == '[') {  // 子字符串开始
                result.push("");
            } else if (ch == ']') {  // 子字符串结尾
                String substr = result.pop();
                StringBuilder str = new StringBuilder();
                int times = count.pop();
                for (int k = 0; k < times; k ++) {
                    str.append(substr);
                }
                result.push(result.pop() + str.toString());
            } else {  // 字符
                result.push(result.pop() + ch);
            }
            i ++;
        }
        return result.pop();
    }

    static int next = 0;

    public static String decodeString1(String s) {
        return loop(s,0);
    }

    public static String loop(String s,int offset){
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i = offset;i < len;i++){
            char c = s.charAt(i);
            if(c == ']'){
                next = i;
                return sb.toString();
            }else if(Character.isDigit(c)){
                for(int j = i+1;j < len;j++){
                    if(s.charAt(j) == '['){
                        int k = Integer.parseInt(s.substring(i,j));
                        String ss = loop(s,j+1);
                        while(k-- > 0){
                            sb.append(ss);
                        }
                        break;
                    }
                }
                i = next;
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
