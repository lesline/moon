package base.string;

/**
 * Created by lesline on 15/11/11.
 */
public class string {
    public static void main(String[] args) {

        String allocates="[{&quot;channelCode&quot;:&quot;01&quot;,&quot;allocationBalance&quot;:4},{&quot;channelCode&quot;:&quot;02&quot;,&quot;allocationBalance&quot;:4}]";
        allocates=allocates.replace("&quot;","\"");
        System.out.println(allocates);

    }
}
