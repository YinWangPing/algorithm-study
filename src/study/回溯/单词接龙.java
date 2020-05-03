package study.回溯;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/5/2 10:49
 */

public class 单词接龙 {
    public static void main(String[] args) {

    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        boolean[]visited=new boolean[wordList.size()];
        Queue<String> queue=new LinkedList<>();
        queue.add(beginWord);
        int res=0;
        while (!queue.isEmpty()){
            int size=queue.size();
            res++;
            while (size-->0){
                String poll=queue.poll();
                if(isNext(poll,endWord)){
                    return res+1;
                }
                for (int i = 0; i <wordList.size() ; i++) {
                    if(!isNext(wordList.get(i),poll)||visited[i]){
                        continue;
                    }
                    visited[i]=true;
                    queue.add(wordList.get(i));
                }
            }
        }
        return 0;
    }
    public boolean isNext(String str1,String str2){
        int count=0;
        for (int i = 0; i <str1.length() ; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                count++;
            }
            if(count>1){
                return false;
            }
        }
        return true;
    }
}
