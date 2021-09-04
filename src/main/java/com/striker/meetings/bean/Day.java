package com.striker.meetings.bean;

import com.striker.meetings.exceptions.NotWorkingDayException;
import com.striker.meetings.exceptions.MeetingNotAvailableException;
import com.striker.meetings.app.Application;

import java.util.Calendar;
import java.util.Map;

public class Day {
    private final Map<Integer, Meeting> meeting;

    public Day(Map<Integer, Meeting> meeting) {
        this.meeting = meeting;
    }

    public Meeting getPair(int number) throws MeetingNotAvailableException {
        Meeting meeting = this.meeting.get(number);
        if (meeting == null) {
           throw new MeetingNotAvailableException(number);
        }
        return meeting;
    }
    public static Day getCurrentWorkingDayOfWeek() throws NotWorkingDayException {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        switch (day) {
            case Calendar.MONDAY:
                return Application.CONTEXT.getBean("monday", Day.class);
            case Calendar.TUESDAY:
                return Application.CONTEXT.getBean("tuesday", Day.class);
            case Calendar.WEDNESDAY:
                return Application.CONTEXT.getBean("wednesday", Day.class);
            case Calendar.THURSDAY:
                return Application.CONTEXT.getBean("thursday", Day.class);
            case Calendar.FRIDAY:
                return Application.CONTEXT.getBean("friday", Day.class);
            default:
                throw new NotWorkingDayException(day);
        }
    }
}
