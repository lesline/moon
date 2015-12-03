package Phaser;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class PhaserTest1 {  

    public static void main(String[] args) {  
        Phaser phaser = new Phaser(1); //�˴���ʹ��CountDownLatch(1)  
        for(int i=0; i<3; i++) {  
            new MyThread((char)(97+i), phaser).start();  
        }  
        try {  
            TimeUnit.SECONDS.sleep(3);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        System.out.println("----------------1----------------");
        phaser.arrive();  //�˴���ʹ��latch.countDown()  
        System.out.println("----------------2----------------");
    }  
}  

class MyThread extends Thread {  
    private char c;  
    private Phaser phaser;  
      
    public MyThread(char c, Phaser phaser) {  
        this.c = c;  
        this.phaser = phaser;  
    }  

    @Override  
    public void run() {  
        phaser.awaitAdvance(phaser.getPhase()); //�˴���ʹ��latch.await()  
       System.out.println(Thread.currentThread().getName()+"-------------"+c);
    }  
}  