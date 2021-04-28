package days;

import exceptions.PairNotAvailableException;
import pairs.Pair;

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
}
