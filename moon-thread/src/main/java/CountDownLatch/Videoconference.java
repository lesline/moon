package CountDownLatch;



import java.util.concurrent.CountDownLatch;  

public class Videoconference implements Runnable{  

    private final CountDownLatch controller;  
    public Videoconference(int number){  
        controller = new CountDownLatch(number);  
    }  
      
    public void arrive(String name){  
        System.out.println("-------"+name+" has arrived.");  
        System.out.println("-------1VideoConference:Waiting for "+controller.getCount());  
        controller.countDown();  
        System.out.println("-------2VideoConference:Waiting for "+controller.getCount());  
    }  
      
    @Override  
    public void run() {  

        System.out.println("VideoConference:Initialization:"+controller.getCount());  
          
        try {  
            controller.await();  
            System.out.printf("++++++VideoConference: All the participants have come\n");  
            System.out.printf("++++++VideoConference: Let's start...\n");  

        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
    }  
}  