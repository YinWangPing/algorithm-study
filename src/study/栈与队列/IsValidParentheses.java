package study.栈与队列;

import java.util.Stack;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/17 15:28
 */

public class IsValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("()(){}[[]"));
    }
    public static boolean isValid(String s){
        int len=s.length();
        Stack<Character>stack=new Stack<>();
        for (int i = 0; i <len ; i++) {
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }
            if(s.charAt(i)=='}'&&stack.isEmpty()||s.charAt(i)=='}'&&stack.pop()!='{'){
                return false;
            }
            if(s.charAt(i)==')'&&stack.isEmpty()||s.charAt(i)==')'&&stack.pop()!='('){
                return false;
            }
            if(s.charAt(i)==']'&&stack.isEmpty()||s.charAt(i)==']'&&stack.pop()!='['){
                return false;
            }
        }
        if(stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
