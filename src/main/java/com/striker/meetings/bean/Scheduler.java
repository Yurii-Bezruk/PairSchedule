package com.striker.meetings.bean;

import com.striker.meetings.util.Time;

import java.util.Date;

public final class Scheduler {
    private final MeetTime[] meetings;

    public Scheduler(MeetTime[] meetings) {
        this.meetings = meetings;
    }

    public Date getMeetingStartTime(int meetingNumber){
        return getTime(meetings[meetingNumber - 1].getStart());
    }
    public Date getMeetingEndTime(int meetingNumber){
        return getTime(meetings[meetingNumber - 1].getStart());
    }
    private Date getTime(String time) {
        int hour = Integer.parseInt(time.substring(0, time.indexOf(':')));
        int minute = Integer.parseInt(time.substring(time.indexOf(':') + 1));
        return Time.getTodayTime(hour, minute);
    }
}
