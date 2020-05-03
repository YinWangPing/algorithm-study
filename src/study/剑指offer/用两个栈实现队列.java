package study.剑指offer;

import java.util.Stack;

/**
 * @description:用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。
 * @author: WangPingYin
 * @time: 2020/2/14 11:35
 */
class MyQueue<T>{
    private Stack<T> in=new Stack<T>();
    private Stack<T> out=new Stack<T>();
    public MyQueue(){}
    public MyQueue(T[] args){
        for (T t:args) {
            in.push(t);
        }
    }
    public void push(T t){
        in.push(t);
    }
    public T pop() throws Exception {
        if(out.isEmpty()){
            out.push(in.pop());
        }
        if(out.isEmpty()){
            throw new Exception("queue is empty");
        }
        return out.pop();
    }
}
public class 用两个栈实现队列 {
    public static void main(String[] args) throws Exception {
        test1();
    }
    public static void test0() throws Exception {
        MyQueue<Integer> myQueue=new MyQueue<Integer>();
        for (int i = 0; i <10 ; i++) {
            myQueue.push(i);
        }
        for (int i = 0; i <10 ; i++) {
            System.out.println(myQueue.pop());
        }

    }
    public static void test1() throws Exception {
        String [] strings=new String[]{"a","b","c","d","e"};
        MyQueue<String> myQueue=new MyQueue<String>(strings);
        for (int i = 0; i <10 ; i++) {
            myQueue.push(""+i);
        }
        for (int i = 0; i <15 ; i++) {
            System.out.println(myQueue.pop());
        }

    }
    public static void test2() throws Exception {
        for (int i = 0; i <10 ; i++) {
            push(i);
        }
        for (int i = 0; i <10 ; i++) {
            System.out.println(pop());
        }

    }
    /**
     *CS-Note
     */
    static Stack<Integer> in = new Stack<Integer>();
    static Stack<Integer> out = new Stack<Integer>();
    public static void push(int key){
        in.push(key);
    }
    public static int pop() throws Exception {
        if(out.isEmpty()){
            out.push(in.pop());
        }
        if(out.isEmpty()){
            throw new Exception("queue is empty");
        }
        return out.pop();
    }
}
