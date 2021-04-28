package tasks;

import days.Day;
import exceptions.PairNotAvailableException;
import main.Browser;

public class DisconnectionPairTask extends PairTask{
    public DisconnectionPairTask(Day day, int pairNumber, Browser browser) {
        super(day, pairNumber, browser);
    }

    @Override
    public void run() {
        if (browser.isActive()) {
            try {
                browser.disconnectFromPair(day.getPair(pairNumber));
            } catch (PairNotAvailableException e) {}    //if pair is not available, do nothing
        }
    }
}
