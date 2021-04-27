package days;

import pairs.InformationProtectingTechnologiesLecture;
import pairs.Pair;
import pairs.RequirementsAnalysisAndModelingLecture;
import pairs.RequirementsAnalysisAndModelingPractice;

import java.util.HashMap;

public class Monday extends Day{
    public Monday() {
        super(new HashMap<Integer, Pair>(){{
            put(1, new InformationProtectingTechnologiesLecture());
            put(2, new RequirementsAnalysisAndModelingLecture());
            put(3, new RequirementsAnalysisAndModelingPractice());
        }});
    }
}
