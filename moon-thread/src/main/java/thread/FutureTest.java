package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FutureTest {
    
    /** ????? */
    private Semaphore semaphore = new Semaphore(0); // 1
    
    /** ???? */
    private ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 5, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3));
    
    /** Future */
    private Future<String> future ;
    
    public void test(){
        
        future = pool.submit(new Callable<String>() {
 
            @Override
            public String call() {
                String result = null;
                try {
                    // ???????????????
                    semaphore.acquire();
                    result = "ok";
                } catch (InterruptedException e) {
                    result = "interrupted";
                }
                return result;


            }
        });
        String result = "timeout";
        try {
            // ???3s
            result = future.get(3, TimeUnit.SECONDS);
        }catch (Exception e) {
            System.out.println("?????");
        }
        
        // ?????????????
        boolean cancelResult = future.cancel(true);
        
        System.out.println("result is " + result);
        System.out.println("????????"  +cancelResult);
        System.out.println("???active???????" +pool.getActiveCount());
        
    }
 
    public static void main(String[] args) {
    	FutureTest o = new FutureTest();        
        o.test();
    }
 
}