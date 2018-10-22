package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

    public static final String format1 = "MM/dd HH:mm:ss";

    public static String convertTimeStampToStr(Long timestamp, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        if (timestamp.toString().length() == 10) {
            timestamp = timestamp * 1000;
        }
        Date date = new Date(timestamp);
        return sdf.format(date);
    }
}
