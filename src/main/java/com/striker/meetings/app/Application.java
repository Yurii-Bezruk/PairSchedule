package com.striker.meetings.app;

import com.striker.meetings.bean.Day;
import com.striker.meetings.bean.Scheduler;
import com.striker.meetings.exceptions.NotWorkingDayException;
import com.striker.meetings.util.Browser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import com.striker.meetings.tasks.ConnectionMeetingTask;
import java.util.Scanner;
import java.util.Timer;

public class Application {
    public static ApplicationContext CONTEXT = new FileSystemXmlApplicationContext("MeetingsContext.xml", "DaysContext.xml");
    public static void main(String[] args) {
        Day today;
        try {
            today = Day.getCurrentWorkingDayOfWeek();
        } catch (NotWorkingDayException e) {
            e.printStackTrace();
            System.out.println("***** SCHEDULING CANCELLED *****");
            return;
        }
        Scheduler scheduler = CONTEXT.getBean("scheduler", Scheduler.class);
        Browser browser = new Browser();
        Timer timer = new Timer(true);

        System.out.println("***** SCHEDULING STARTED *****");
        for (int i = 0; i < scheduler.getMeetingsCount(); i++) {
            timer.schedule(
                    new ConnectionMeetingTask(today, i + 1, browser),
                    scheduler.getMeetingStartTime(i + 1)
            );
        }

        Scanner scanner = new Scanner(System.in);
        while(true){
            if(scanner.nextLine().equals("exit"))
                break;
        }
        browser.close();
        timer.cancel();
        System.out.println("***** SCHEDULING FINISHED *****");
        System.out.println("***** BROWSER CLOSED CORRECTLY *****");
    }
}
