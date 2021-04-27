package days;

import pairs.*;

import java.util.HashMap;

public class Thuesday extends Day{
    public Thuesday() {
        super(new HashMap<Integer, Pair>(){{
            put(1, new ApplicationProgrammingLanguagesLecture());
            put(2, new DataBaseAndKnowlegeOrganizingLecture());
            put(3, new NumberMethodsLecture());
            put(4, new InformationProtectingTechnologiesPractice());
        }});
    }
}
