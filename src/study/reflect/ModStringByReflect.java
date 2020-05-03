package study.reflect;

import java.lang.reflect.Field;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/5 10:46
 */

public class ModStringByReflect {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String str=" a  b  c    ";
        System.out.println(str.hashCode());
        Field field=str.getClass().getDeclaredField("value");
        field.setAccessible(true);
        field.set(str,str.trim().toCharArray());
        System.out.println(str.hashCode());
        System.out.println(str+"**");
    }
}
