package days;
import pairs.*;
import java.util.HashMap;

public class Friday extends Day{
    public Friday() {
        super(new HashMap<Integer, Pair>(){{
            put(2, new AlternativeCountingMethodsLecture());
            put(3, new InformationTechnologies());
            put(4, new AlternativeCountingMethodsPractice());
        }});
    }
}
