package com.striker.meetings.app;

import com.striker.meetings.bean.Day;
import com.striker.meetings.bean.Scheduler;
import com.striker.meetings.exceptions.NotWorkingDayException;
import com.striker.meetings.util.Browser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import com.striker.meetings.tasks.ConnectionMeetingTask;

import java.util.*;

public class Application {
    public static ApplicationContext CONTEXT = new FileSystemXmlApplicationContext("MeetingsContext.xml", "DaysContext.xml");
    public static void main(String[] args) {

        Browser browser;
        Day day;
        TimerTask task;
        Timer timer;
        Scheduler scheduler = CONTEXT.getBean("scheduler", Scheduler.class);

        browser = new Browser();
        try {
            day = Day.getCurrentWorkingDayOfWeek();
        } catch (NotWorkingDayException e) {
            e.printStackTrace();
            return;
        }
        //day = CONTEXT.getBean("friday", Day.class);
        timer = new Timer(true);

        task = new ConnectionMeetingTask(day, 1, browser);
        timer.schedule(task, scheduler.getMeetingStartTime(1));

        task = new ConnectionMeetingTask(day, 2, browser);
        timer.schedule(task, scheduler.getMeetingStartTime(2));

//        task = new ConnectionMeetingTask(day, 3, browser);
//        timer.schedule(task, Time.getTodayTime(17, 19));
//
//        task = new ConnectionMeetingTask(day, 4, browser);
//        timer.schedule(task, Time.getTodayTime(17, 21));
//        task = new DisconnectionMeetingTask(day, 4, browser);
//        timer.schedule(task, Time.getTodayTime(17, 22));

        //Thread.currentThread().join();

        Scanner s = new Scanner(System.in);
        while(true){
            if(s.nextLine().equals("exit"))
                break;
        }
        browser.close();
        timer.cancel();
        System.out.println("TimerTask прекращена");
    }
}
