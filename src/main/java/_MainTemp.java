import java.io.IOException;

import function.DateTimeStringFormatter;

public class _MainTemp {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, IOException {
        DateTimeStringFormatter d  =  new DateTimeStringFormatter("20220915100342493");
        System.out.println(d.ReadableFormat());
        System.out.println(d.getLocalDateTime());
        System.out.println(d.getMonth());
        System.out.println(d.getMinute());
        System.out.println(d.getSecond());
    }

}
