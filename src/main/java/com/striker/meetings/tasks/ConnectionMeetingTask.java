package com.striker.meetings.tasks;

import com.striker.meetings.bean.Day;
import com.striker.meetings.exceptions.MeetingNotAvailableException;
import com.striker.meetings.util.Browser;

public class ConnectionMeetingTask extends MeetingTask {
    public ConnectionMeetingTask(Day day, int meetingNumber, Browser browser) {
        super(day, meetingNumber, browser);
    }

    @Override
    public void run() {
        if(browser == null || ! browser.isActive())
            browser = new Browser();
        try {
            browser.connectToMeeting(day.getPair(meetingNumber));
        } catch (MeetingNotAvailableException ignored) {}    //if pair is not available, do nothing
    }
}
