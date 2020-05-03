/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/2/26 19:41
 */

public class ReferenceCount {
    public Object instance = null;
    public static void main(String[] args) {
        ReferenceCount a=new ReferenceCount();
        ReferenceCount b=new ReferenceCount();
        a.instance=b;
        b.instance=a;
        a=null;
        b=null;
        System.out.println(a==b);
    }
}
