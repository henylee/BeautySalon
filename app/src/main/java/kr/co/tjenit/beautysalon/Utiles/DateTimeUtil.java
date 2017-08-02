package kr.co.tjenit.beautysalon.Utiles;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by the on 2017-07-27.
 */

public class DateTimeUtil {

    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 M월 d일");
    static SimpleDateFormat dateFormats = new SimpleDateFormat("yyyy-MM-dd");

    static SimpleDateFormat timeFormat = new SimpleDateFormat("a hh:mm");

    static SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy년 MM월 dd일 H시:mm분");

    public static String getDateString(Calendar dateCal) {
        String str = dateFormat.format(dateCal.getTime());
        return str;
    }

    public static String getTimeString(Calendar timeCal) {
        String str = timeFormat.format(timeCal.getTime());
        return str;
    }

    public static String getdateTimeString(Calendar datetimeCal) {
        String str = datetimeFormat.format(datetimeCal.getTime());
        return str;
    }

    public static String getdateString2(Calendar datetimeCal) {
        String str = dateFormats.format(datetimeCal.getTime());
        return str;
    }

}
