package days;

import exceptions.NotWorkingDayException;
import exceptions.PairNotAvailableException;
import pairs.Pair;

import java.util.Calendar;
import java.util.Map;

public abstract class Day {
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
                return new Monday();
            case Calendar.TUESDAY:
                return new Thuesday();
            case Calendar.WEDNESDAY:
                return new Wednesday();
            case Calendar.THURSDAY:
                return new Thursday();
            case Calendar.FRIDAY:
                return new Friday();
            default:
                throw new NotWorkingDayException(day);
        }
    }
}
