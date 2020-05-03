package study.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/18 10:02
 */

public class LetterCombinations {
    public static void main(String[] args) {
        new LetterCombinations().letterCombinations("23");
    }
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return combinations;
        }
        doCombination(new StringBuilder(), combinations, digits);
        return combinations;
    }

    private void doCombination(StringBuilder prefix, List<String> combinations, final String digits) {
        if (prefix.length() == digits.length()) {
            combinations.add(prefix.toString());
            return;
        }
        int curDigits = digits.charAt(prefix.length()) - '0';
        String letters = KEYS[curDigits];
        for (char c : letters.toCharArray()) {
            prefix.append(c);                         // 添加
            doCombination(prefix, combinations, digits);
            prefix.deleteCharAt(prefix.length() - 1); // 删除
        }
    }
    public List<String> letterCombinations1(String digits) {
        List<String> res=new ArrayList<String>();
        if(digits==null||digits.length()==0){
            return res;
        }
        doCombinations1(new StringBuilder(),res,digits);
        return res;
    }
    public static void doCombinations1(StringBuilder sb,List<String> res,String digits){
        if(sb.length()==digits.length()){
            res.add(sb.toString());
        }
        int num=digits.charAt(sb.length())-'0';
        String str=KEYS[num];
        for(char c:str.toCharArray()){
            sb.append(c);
            doCombinations1(sb,res,digits);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
