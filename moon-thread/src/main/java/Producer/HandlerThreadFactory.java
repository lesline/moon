package Producer;

import java.util.concurrent.ThreadFactory;

public class HandlerThreadFactory implements ThreadFactory {
     public Thread newThread(Runnable runnable) {
          Thread t = new Thread(runnable);
          MyUncaughtExceptionHandler myUncaughtExceptionHandler = new MyUncaughtExceptionHandler();
          t.setUncaughtExceptionHandler(myUncaughtExceptionHandler);
          return t;
     }
     
}
 class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler  {
    public void uncaughtException(Thread t, Throwable e) {
       System.out.println("���̳߳������߳�ID="+t.getId()+"|�߳���="+t.getName()+")" +e);
  }
}