package tasks;

import days.Day;
import exceptions.PairNotAvailableException;
import main.Browser;

public class ConnectionPairTask extends PairTask{
    public ConnectionPairTask(Day day, int pairNumber, Browser browser) {
        super(day, pairNumber, browser);
    }

    @Override
    public void run() {
        if(browser == null || ! browser.isActive())
            browser = new Browser();
        try {
            browser.connectToPair(day.getPair(pairNumber));
        } catch (PairNotAvailableException e) {}    //if pair is not available, do nothing
    }
}
