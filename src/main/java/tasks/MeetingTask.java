package tasks;

import days.*;
import start.Browser;

import java.util.TimerTask;

public abstract class MeetingTask extends TimerTask {
    protected Browser browser;
    protected Day day;
    protected int meetingNumber;

    public MeetingTask(Day day, int meetingNumber, Browser browser) {
        this.day = day;
        this.meetingNumber = meetingNumber;
        this.browser = browser;
    }

    @Override
    public abstract void run();
}
