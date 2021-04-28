package start;

import java.util.Date;

public class Time {
    private Time(){}
    public static Date getTodayTime(int hours, int minutes){
        Date now = new Date();
        now.setHours(hours);
        now.setMinutes(minutes);
        now.setSeconds(0);
        return now;
    }
}
