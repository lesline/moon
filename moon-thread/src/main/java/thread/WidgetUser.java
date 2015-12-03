package thread;
import java.util.ArrayList;
import java.util.List;
class Widget{}
class WidgetMaker extends Thread{
    List finishedWidgets=new ArrayList();
    public void run(){
        try{
            while(true){
                Thread.sleep(5000);//act busy
                Widget w=new Widget();

                /*
notifyAll使所有原来在该对象上等待被notify的线程统统退出wait的状态，变成等待该对象上的锁，一旦该对象被解锁，他们就会去竞争。
notify则文明得多他只是选择一个wait状态线程进行通知，并使它获得该对象上的锁，但不惊动其他同样在等待被该对象notify的线程们，
当第一个线程运行完毕以后释放对象上的锁此时如果该对象没有再次使用notify语句，则即便该对象已经空闲，
其他wait状态等待的线程由于没有得到该对象的通知，继续处在wait状态，直到这个对象发出一个notify或notifyAll，它们等待的是被notify或notifyAll，而不是锁。
                 */
                //也就是说需要5秒钟才能新产生一个Widget，这决定了一定要用notify而不是notifyAll
                //因为上面两行代码不是同步的，如果用notifyAll则所有线程都企图冲出wait状态
                //第一个线程得到了锁，并取走了Widget（这个过程的时间小于5秒，新的Widget还没有生成）
                //并且解开了锁，然后第二个线程获得锁(因为用了notifyAll其他线程不再等待notify语句
                //，而是等待finishedWidgets上的锁，一旦锁放开了，他们就会竞争运行)，运行
                //finishedWidgets.remove(0)，但是由于finishedWidgets现在还是空的，
                //于是产生异常
                //***********这就是为什么下面的那一句不能用notifyAll而是要用notify

                synchronized(finishedWidgets){
                    finishedWidgets.add(w);
                    finishedWidgets.notify(); //这里只能是notify而不能是notifyAll
                }
            }
        }
        catch(InterruptedException e){}
    }

    public Widget waitForWidget(){
        synchronized(finishedWidgets){
            if(finishedWidgets.size()==0){
                try{
                    finishedWidgets.wait();
                }
                catch(InterruptedException e)
                {}
            }
            return (Widget) finishedWidgets.remove(0);
        }
    }
}
public class WidgetUser extends Thread{
    private WidgetMaker maker;
    public WidgetUser(String name,WidgetMaker maker){
        super(name);
        this.maker=maker;
    }
    public void run(){
        Widget w=maker.waitForWidget();
        System.out.println(getName()+"got a widget");
    }

    public static void main(String[] args) {
        WidgetMaker maker=new WidgetMaker();
        maker.start();
        new WidgetUser("Lenny",maker).start();
        new WidgetUser("Moe",maker).start();
        new WidgetUser("Curly",maker).start();
    }
}