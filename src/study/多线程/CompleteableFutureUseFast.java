import java.util.concurrent.CompletableFuture;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/2/24 10:37
 */

public class CompleteableFutureUseFast {
    public static void main(String[] args) {
        String result= CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return  "Running 1 Second";
        }).applyToEither(CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return  "Running 3 Second";
        }),(s)->{return s;}).join();
        System.out.println(result);
    }
}
