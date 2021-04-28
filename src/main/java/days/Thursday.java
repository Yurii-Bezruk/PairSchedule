package days;
import pairs.*;
import java.util.HashMap;

public class Thursday extends Day{
    public Thursday() {
        super(new HashMap<Integer, Pair>(){{
            put(2, new ApplicationProgrammingLanguagesPractice());
            put(3, new DataBaseAndKnowlegeOrganizingPractice());
            put(4, new NumberMethodsPractice());
        }});
    }
}