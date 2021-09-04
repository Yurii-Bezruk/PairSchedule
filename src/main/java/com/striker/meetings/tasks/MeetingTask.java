package com.striker.meetings.tasks;

import com.striker.meetings.bean.Day;
import com.striker.meetings.util.Browser;

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
