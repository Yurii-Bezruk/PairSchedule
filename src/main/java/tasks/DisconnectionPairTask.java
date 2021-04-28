package tasks;

import days.Day;
import exceptions.PairNotAvailableException;
import main.Brawser;

public class DisconnectionPairTask extends PairTask{
    public DisconnectionPairTask(Day day, int pairNumber, Brawser brawser) {
        super(day, pairNumber, brawser);
    }

    @Override
    public void run() {
        if (brawser.isActive()) {
            try {
                brawser.disconnectFromPair(day.getPair(pairNumber));
            } catch (PairNotAvailableException e) {}    //if pair is not available, do nothing
        }
    }
}
