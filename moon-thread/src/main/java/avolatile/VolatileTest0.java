package avolatile;
import java.util.concurrent.*;  

public class VolatileTest0 {  
	
	/*
	 * 永远不会退出。原因是程序优化为：
	    int i = 0;  
	    while (!stop) {  
	        i++;  
	    }  
	 */
    private static /*volatile*/ boolean stop = false;  
    public static void main(String[] args) throws Exception {  
        Thread t = new Thread(new Runnable() {  
            public void run() {  
                int i = 0;  
                while (!stop) {  
                    i++;  
                //System.out.println(i++);  
                }  
            }  
        });  
        t.start();  

        Thread.sleep(1000);  
        TimeUnit.SECONDS.sleep(1);  
        System.out.println("Stop Thread");  
        stop = true;  
    }  
}  