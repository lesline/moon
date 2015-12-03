package ExecutorService;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/** 
 * ��ʱ������ 
 *  
 * @author dream-victor 
 *  
 */  
public class LongTask implements Callable<String> {  
  
    @Override  
    public String call() throws Exception {  
        TimeUnit.SECONDS.sleep(10);  
        return "success";  
    }  
  
} 