import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author WangPingYin
 * @description:
 * @date 2020/1/8 16:11
 */
class DLinkedNode {//双向链表
    String key;
    String value;
    DLinkedNode pre;
    DLinkedNode next;
}
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private final int CACHE_SIZE;

    // 这里就是传递进来最多能缓存多少数据
    public LRUCache(int cacheSize) {
        // 设置一个hashmap的初始大小，最后一个true指的是让linkedhashmap按照访问顺序来进行排序，最近访问的放在头，最老访问的就在尾
        super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
        CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        // 当map中的数据量大于指定的缓存个数的时候，就自动删除最老的数据
        return size() > CACHE_SIZE;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put("1", "7");
        lruCache.put("2", "0");
        lruCache.put("3", "1");
        lruCache.put("4", "2");
        System.out.println(lruCache.get("2"));
        lruCache.put("5", "3");
        lruCache.put("4", "4");
        System.out.println(lruCache.get("2"));
        lruCache.put("6", "4");
    }
}
//public class LRUCache {
//    private HashMap<String,DLinkedNode>map =new HashMap<String,DLinkedNode>();
//    private int capacity;
//    private int count;
//    private DLinkedNode head,end;
//    public LRUCache(int capacity){//
//        // 初始化容量，首尾节点
//        this.capacity=capacity;
//        this.count=0;
//        head=new DLinkedNode();
//        head.pre=null;
//        end=new DLinkedNode();
//        end.pre=head;
//        head.next=end;
//        end.next=null;
//
//    }
//    public void set(String key,String value){//添加数据
//        DLinkedNode node =map.get(key);
//        if(node==null){
//            node =new DLinkedNode();
//            node.key=key;
//            node.value=value;
//            addNode(node);
//            map.put(key,node);
//            this.count++;
//            if(this.count>capacity){
//                DLinkedNode rem=end.pre;
//                removeNode(rem);
//                map.remove(rem.key);
//            }
//        }else {
//            node.value=value;
//            removeNode(node);
//            addNode(node);
//        }
//    }
//    public String get(String key){
//        //根据key获取value，并将其移至链表首位
//        DLinkedNode node=map.get(key);
//        if(node==null){
//            return null;
//        }
//        removeNode(node);
//        addNode(node);
//        return node.value;
//    }
//    public void addNode(DLinkedNode node){
//        //首插法
//        node.pre=head;
//        head.next.pre=node;
//        node.next=head.next;
//        head.next=node;
//
//    }
//    public void removeNode(DLinkedNode node){
//        DLinkedNode pre=node.pre;
//        pre.next=node.next;
//        node.next.pre=pre;
//    }
//    public static void main(String[] args) {
//        LRUCache lruCache = new LRUCache(3);
//        lruCache.set("1", "7");
//        lruCache.set("2", "0");
//        lruCache.set("3", "1");
//        lruCache.set("4", "2");
//        System.out.println(lruCache.get("2"));
//        lruCache.set("5", "3");
//        lruCache.set("4", "4");
//        System.out.println(lruCache.get("2"));
//        lruCache.set("6", "4");
//    }
//}