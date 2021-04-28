package tasks;

import days.*;
import exceptions.PairNotAvailableException;
import main.Brawser;

import java.util.TimerTask;

public abstract class PairTask extends TimerTask {
    protected Brawser brawser;
    protected Day day;
    protected int pairNumber;

    public PairTask(Day day, int pairNumber, Brawser brawser) {
        this.day = day;
        this.pairNumber = pairNumber;
        this.brawser = brawser;
    }

    @Override
    public abstract void run();
}
