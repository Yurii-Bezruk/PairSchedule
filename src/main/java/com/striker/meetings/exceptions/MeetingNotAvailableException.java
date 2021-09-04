package com.striker.meetings.exceptions;

public class MeetingNotAvailableException extends Exception{
    private final int meetingNumber;
    public MeetingNotAvailableException(int meetingNumber) {
        this.meetingNumber = meetingNumber;
    }

    @Override
    public void printStackTrace() {
        System.err.println("This meeting is not available in this day: "+ meetingNumber);
        super.printStackTrace();
    }
}
