package start;

import days.*;
import exceptions.PairNotAvailableException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tasks.ConnectionPairTask;
import tasks.DisconnectionPairTask;

import java.util.*;

public class Application {
    public static ApplicationContext CONTEXT = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    public static void main(String[] args) throws InterruptedException, PairNotAvailableException {

        Browser browser;
        Day day;
        TimerTask task;
        Timer timer;

        browser = new Browser();
//        try {
//            day = Day.getCurrentWorkingDayOfWeek();
//        } catch (NotWorkingDayException e) {
//            e.printStackTrace();
//            return;
//        }
        day = (Day) CONTEXT.getBean("wednesday");
        timer = new Timer(true);

        task = new ConnectionPairTask(day, 1, browser);
        timer.schedule(task, Time.getTodayTime(17, 38));
        task = new DisconnectionPairTask(day, 1, browser);
        timer.schedule(task, Time.getTodayTime(17, 39));

//        task = new ConnectionPairTask(day, 2, browser);
//        timer.schedule(task, Time.getTodayTime(17, 17));
//        task = new DisconnectionPairTask(day, 2, browser);
//        timer.schedule(task, Time.getTodayTime(17, 18));
//
//        task = new ConnectionPairTask(day, 3, browser);
//        timer.schedule(task, Time.getTodayTime(17, 19));
//        task = new DisconnectionPairTask(day, 3, browser);
//        timer.schedule(task, Time.getTodayTime(17, 20));
//
//        task = new ConnectionPairTask(day, 4, browser);
//        timer.schedule(task, Time.getTodayTime(17, 21));
//        task = new DisconnectionPairTask(day, 4, browser);
//        timer.schedule(task, Time.getTodayTime(17, 22));

        Thread.currentThread().join();
        /*
        Scanner s = new Scanner(System.in);
        while(true){
            if(s.next().equals("exit"))
                break;
        }
        browser.close();
        timer.cancel();
        System.out.println("TimerTask прекращена");*/
    }
}
