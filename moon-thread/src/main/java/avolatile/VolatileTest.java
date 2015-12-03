package avolatile;
public class VolatileTest {
    public  int inc = 0;
     
    public void increase() {
        inc++;
        System.out.println(inc);
    }
    public int get() {
        return inc;
    }
    public static void main(String[] args) throws InterruptedException {
        final VolatileTest test = new VolatileTest();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<10;j++){
                        test.increase();
                        System.out.println(test.get());
                    }
                };
            }.start();
        }
         
        while(Thread.activeCount()>1)  //保证前面的线程都执行完
            Thread.yield();
        
        Thread.currentThread().sleep(1000);
        System.out.println("-----------");
        System.out.println(test.inc);
    }
}