package tasks;

import days.Day;
import exceptions.PairNotAvailableException;
import main.Brawser;

public class ConnectionPairTask extends PairTask{
    public ConnectionPairTask(Day day, int pairNumber, Brawser brawser) {
        super(day, pairNumber, brawser);
    }

    @Override
    public void run() {
        if(brawser == null || ! brawser.isActive())
            brawser = new Brawser();
        try {
            brawser.connectToPair(day.getPair(pairNumber));
        } catch (PairNotAvailableException e) {}    //if pair is not available, do nothing
    }
}
