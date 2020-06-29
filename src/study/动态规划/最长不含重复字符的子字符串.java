package study.动态规划;

import java.util.HashMap;

public class 最长不含重复字符的子字符串 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aabaab!bb"));
    }
    public static int lengthOfLongestSubstring(String s) {
//        if(s==null||s.length()==0){
//            return 0;
//        }
        HashMap<Character,Integer>map=new HashMap<>();
        int maxlen=0,index=0;
        for (int i = 0; i <s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                index=Math.max(map.get(s.charAt(i))+1,index);
            }
            maxlen=Math.max(maxlen,i-index+1);
            map.put(s.charAt(i),i);
        }
        return maxlen;
    }
}
