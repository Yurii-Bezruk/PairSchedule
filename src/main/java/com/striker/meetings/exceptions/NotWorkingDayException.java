package com.striker.meetings.exceptions;

import java.util.Calendar;

public class NotWorkingDayException extends Exception{
    private final int day;
    public NotWorkingDayException(int day) {
        this.day = day;
    }

    @Override
    public void printStackTrace() {
        System.err.println("Current day of week is not working day: "+(day == Calendar.SATURDAY ? "Saturday" : "Sunday"));
        super.printStackTrace();
    }
}
