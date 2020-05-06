package study.双指针;

import java.util.List;

public class 匹配最长子序列 {
    public String findLongestWord(String s, List<String> d) {
        int max=0;
        String res="";
        for (String str:d) {
            if(isMatch(s,str)){
                if(max==str.length()){
                    if(res.compareTo(str)>0){
                        res=str;
                    }
                }else if(max<str.length()){
                    res = str;
                    max = str.length();
                }else {
                    continue;
                }
            }
        }
        return res;
    }
    public boolean isMatch(String s,String str){
        int index=0;
        for (int i = 0; i <s.length() ; i++) {
            if(s.charAt(i)==str.charAt(index)){
                index++;
            }
            if(index==str.length()){
                return true;
            }
        }
        return false;
    }
}
