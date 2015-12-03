package base.text;

import java.text.MessageFormat;
import java.util.Date;

/**
 * Created by lesline on 15/10/23.
 */
public class MessageFormatTest {

    public static void main(String[] args) {
        Object[] arguments = {
                new Integer(7),
                new Date(System.currentTimeMillis()),
                "a disturbance in the Force"
        };
        String result = MessageFormat.format(
                "At {1,time} on {1,date}, there was {2} on planet {0,number,integer}.",
                arguments);
        System.out.println(result);
    }
}