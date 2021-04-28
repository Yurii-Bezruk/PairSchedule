package tasks;

import days.*;
import start.Browser;

import java.util.TimerTask;

public abstract class PairTask extends TimerTask {
    protected Browser browser;
    protected Day day;
    protected int pairNumber;

    public PairTask(Day day, int pairNumber, Browser browser) {
        this.day = day;
        this.pairNumber = pairNumber;
        this.browser = browser;
    }

    @Override
    public abstract void run();
}
