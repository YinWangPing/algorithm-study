package study.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/5/1 22:46
 */

public class 分割字符串使每一部分都是回文串 {
    public static void main(String[] args) {

    }
    public List<List<String>> partition(String s) {
        List<String>path=new ArrayList<>();
        List<List<String>>res=new ArrayList<>();
        return res;
    }
    public void backing(String s,List<List<String>>res,List<String>path) {
        if(s.length()==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i <s.length() ; i++) {
            if(isPlain(s,0,i)){
                path.add(s.substring(0,i+1));
                backing(s.substring(i+1),res,path);
                path.remove(path.size()-1);
            }
        }
    }
    public boolean isPlain(String str,int start,int end){
        while (start<end){
            if(str.charAt(start++)!=str.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
