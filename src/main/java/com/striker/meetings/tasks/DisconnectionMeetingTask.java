package com.striker.meetings.tasks;

import com.striker.meetings.bean.Day;
import com.striker.meetings.exceptions.MeetingNotAvailableException;
import com.striker.meetings.util.Browser;

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
