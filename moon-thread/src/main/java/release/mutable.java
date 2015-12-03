package release;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by lesline on 15/11/17.
 */
public class mutable {


    final static AtomicInteger i = new AtomicInteger(0);

    public static int getNext() {
        return i.addAndGet(1);
    }

    public static void main(String[] args) {
        for (int j = 0; j < 100; j++) {
            System.out.println(mutable.getNext());

        }
    }


}
