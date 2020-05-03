import java.util.concurrent.CompletableFuture;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/2/24 10:36
 */
/**
 *result:
 * Use The Result:result
 */
public class CompleteableFutureDemo {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(()->{return "result";}).
                thenAccept((v->{
                    System.out.println("Use The Result:"+v);
                }));
    }
}
