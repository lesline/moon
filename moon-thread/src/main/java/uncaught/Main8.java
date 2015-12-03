package uncaught;
  
public class Main8 {  
  
    /** 
     * <p> 
     * </p> 
     * @author zhangjunshuai 
     * @date 2014-8-21 ����2:14:52 
     * @param args 
     */  
    public static void main(String[] args) {  
  
        Task task = new Task();  
        Thread thread = new Thread(task);  
        thread.setUncaughtExceptionHandler(new ExceptionHandler());  
        thread.start();  
        System.out.println("---------------");
    }  
  
}