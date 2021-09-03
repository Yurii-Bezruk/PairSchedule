package tasks;

import days.Day;
import exceptions.MeetingNotAvailableException;
import start.Browser;

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
