import days.*;
import exceptions.PairNotAvailableException;

import java.util.TimerTask;

public class PairTask extends TimerTask {
    private Brawser brawser;
    private Day day;
    private int pairNumber;

    public PairTask(Day day, int pairNumber, Brawser brawser) {
        this.day = day;
        this.pairNumber = pairNumber;
        this.brawser = brawser;
    }

    @Override
    public void run() {
        if(! brawser.isActive())
            brawser = new Brawser();
        try {
            brawser.connectToPair(day.getPair(pairNumber));
        } catch (PairNotAvailableException e) {}    //if pair is not available, do nothing
    }
}
