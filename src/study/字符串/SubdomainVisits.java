package study.字符串;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/20 20:02
 */

public class SubdomainVisits {
    public static void main(String[] args) {
        String[] str = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        List<String> res = new SubdomainVisits().subdomainVisits(str);
        for (String s : res) {
            System.out.println(s);
        }
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        ArrayList<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        int count = cpdomains.length;
        for (int i = 0; i < count; i++) {
            String[] str = cpdomains[i].split(" ");
            int num = Integer.valueOf(str[0]);
            String[] split = str[1].split("\\.");
            if (split.length == 3) {
                map.put(str[1], num + map.getOrDefault(str[1], 0));
                map.put(split[1] + "." + split[2], num + map.getOrDefault(split[1] + "." + split[2], 0));
                map.put(split[2], num + map.getOrDefault(split[2], 0));
            } else if (split.length == 2) {
                map.put(str[1], num + map.getOrDefault(str[1], 0));
                map.put(split[1], num + map.getOrDefault(split[1], 0));
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            list.add(entry.getValue() + " " + entry.getKey());
        }
        return list;
    }
}
