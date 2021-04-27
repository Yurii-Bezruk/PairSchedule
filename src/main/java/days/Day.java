package days;

import pairs.Pair;

import java.util.Map;

public abstract class Day {
    private final Map<Integer,Pair> pairs;

    public Day(Map<Integer,Pair> pairs) {
        this.pairs = pairs;
    }

    public Pair getPair(int number){
        return pairs.get(number);
    }
}
