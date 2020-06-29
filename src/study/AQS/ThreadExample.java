package study.AQS;

public class ThreadExample {
    private static class Mythread extends Thread{
        @Override
        public void run() {
            int count=0;
            while (!interrupted()){
                System.out.println(count++);
            }
            System.out.println("end");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Mythread mythread=new Mythread();
        mythread.start();
        Thread.sleep(10);
        mythread.interrupt();
    }
}
