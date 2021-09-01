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
                return (Day) Application.CONTEXT.getBean("monday");
            case Calendar.TUESDAY:
                return (Day) Application.CONTEXT.getBean("tuesday");
            case Calendar.WEDNESDAY:
                return (Day) Application.CONTEXT.getBean("wednesday");
            case Calendar.THURSDAY:
                return (Day) Application.CONTEXT.getBean("thursday");
            case Calendar.FRIDAY:
                return (Day) Application.CONTEXT.getBean("friday");
            default:
                throw new NotWorkingDayException(day);
        }
    }
}
