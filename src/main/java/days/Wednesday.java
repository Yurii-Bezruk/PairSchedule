package days;

import pairs.MethodsAndSystemsOfArtificialIntelligenceLecture;
import pairs.MethodsAndSystemsOfArtificialIntelligencePractice;
import pairs.Pair;

import java.util.HashMap;

public class Wednesday extends Day{
    public Wednesday() {
        super(new HashMap<Integer, Pair>(){{
            put(2, new MethodsAndSystemsOfArtificialIntelligenceLecture());
            put(3, new MethodsAndSystemsOfArtificialIntelligencePractice());
        }});
    }
}
