package study.排序;

import java.util.*;

public class 字符出现次数排序 {
    public String frequencySort(String s) {
        Map<Character,Integer> map=new HashMap<>();
        for (int i = 0; i <s.length() ; i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        List<Map.Entry<Character,Integer>>list=new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i <list.size() ; i++) {
            for (int j = list.get(i).getValue(); j >0 ; j--) {
                sb.append(list.get(i).getKey());
            }
        }
        return sb.toString();
    }
}
