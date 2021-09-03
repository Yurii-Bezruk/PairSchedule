package tasks;

import days.Day;
import exceptions.MeetingNotAvailableException;
import start.Browser;

public class DisconnectionMeetingTask extends MeetingTask {
    public DisconnectionMeetingTask(Day day, int meetingNumber, Browser browser) {
        super(day, meetingNumber, browser);
    }

    @Override
    public void run() {
        if (browser.isActive()) {
            try {
                browser.disconnectFromMeeting(day.getPair(meetingNumber));
            } catch (MeetingNotAvailableException ignored) {}    //if pair is not available, do nothing
        }
    }
}
