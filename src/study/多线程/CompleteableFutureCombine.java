import java.util.concurrent.CompletableFuture;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/2/24 10:37
 */
/**
 * result:
 *part1	part2
 */
public class CompleteableFutureCombine {
    public static void main(String[] args) {
        String combineResult= CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return  "part1";
        }).thenCombine(CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return  "part2";
        }),(result1,result2)->{return result1+"\t"+result2;}).join();
        System.out.println(combineResult);
    }
}
