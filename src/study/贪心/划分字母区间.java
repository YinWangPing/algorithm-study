package study.贪心;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 划分字母区间 {
    public List<Integer> partitionLabels(String S) {
        int[]lastIndex=new int[26];
        for (int i = 0; i <S.length(); i++) {
            lastIndex[S.charAt(i)-'a']=i;
        }
        int first=0;int last=0;
        List<Integer>res=new ArrayList<>();
        for (int i = 0; i <S.length() ; i++) {
            last=Math.max(last,lastIndex[S.charAt(i)-'a']);
            if(i==last){
                res.add(i-first+1);
                first=i+1;
            }
        }
        return res;
    }






























    public List<Integer> partitionLabels1(String str) {
        int len=str.length();
        int [] lastIndex=new int[26];
        for (int i = 0; i <len ; i++) {
            lastIndex[str.charAt(i)-'a']=i;
        }
        List<Integer> res=new ArrayList<>();
        int first=0,last=0;
        for (int i = 0; i <len ; i++) {
            last=Math.max(last,lastIndex[str.charAt(i)-'a']);
            if(last==i){
                res.add(last-first+1);
                first=i+1;
            }
        }
        return res;
    }
}
