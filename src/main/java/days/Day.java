package days;

import exceptions.NotWorkingDayException;
import exceptions.PairNotAvailableException;
import pairs.Pair;
import start.Application;

import java.util.Calendar;
import java.util.Map;

public class Day {
    private final Map<Integer,Pair> pairs;

    public Day(Map<Integer,Pair> pairs) {
        this.pairs = pairs;
    }

    public Pair getPair(int number) throws PairNotAvailableException {
        Pair pair = pairs.get(number);
        if (pair == null) {
           throw new PairNotAvailableException(number);
        }
        return pair;
    }
    public static Day getCurrentWorkingDayOfWeek() throws NotWorkingDayException {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        switch (day) {
            case Calendar.MONDAY:
                return Application.CONTEXT.getBean("monday", Day.class);
            case Calendar.TUESDAY:
                return Application.CONTEXT.getBean("tuesday", Day.class);
            case Calendar.WEDNESDAY:
                return Application.CONTEXT.getBean("wednesday", Day.class);
            case Calendar.THURSDAY:
                return Application.CONTEXT.getBean("thursday", Day.class);
            case Calendar.FRIDAY:
                return Application.CONTEXT.getBean("friday", Day.class);
            default:
                throw new NotWorkingDayException(day);
        }
    }
}
