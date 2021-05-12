package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataUtils {

    private static SimpleDateFormat formatarDiaMes = new SimpleDateFormat("dd/MM");

    public static Date getData(){
        Calendar myCalendar = Calendar.getInstance();
        myCalendar.getTime();
        myCalendar.set(Calendar.HOUR_OF_DAY, 0);
        myCalendar.set(Calendar.MINUTE, 0);
        myCalendar.set(Calendar.SECOND, 0);
        myCalendar.set(Calendar.MILLISECOND, 0);
        return myCalendar.getTime();
    }

    public static String formatData(Date data){
        return formatarDiaMes.format(data);
    }


}
