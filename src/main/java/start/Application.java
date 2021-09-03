package start;

import days.*;
import exceptions.NotWorkingDayException;
import exceptions.PairNotAvailableException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import tasks.ConnectionPairTask;
import tasks.DisconnectionPairTask;

import java.util.*;

public class Application {
    public static ApplicationContext CONTEXT = new FileSystemXmlApplicationContext("PairsContext.xml", "DaysContext.xml");
    public static void main(String[] args) {

        Browser browser;
        Day day;
        TimerTask task;
        Timer timer;

        browser = new Browser();
        try {
            day = Day.getCurrentWorkingDayOfWeek();
        } catch (NotWorkingDayException e) {
            e.printStackTrace();
            return;
        }
        //day = CONTEXT.getBean("friday", Day.class);
        timer = new Timer(true);

        task = new ConnectionPairTask(day, 1, browser);
        timer.schedule(task, Time.getTodayTime(9, 35));

        task = new ConnectionPairTask(day, 2, browser);
        timer.schedule(task, Time.getTodayTime(17, 17));

        task = new ConnectionPairTask(day, 3, browser);
        timer.schedule(task, Time.getTodayTime(17, 19));

        task = new ConnectionPairTask(day, 4, browser);
        timer.schedule(task, Time.getTodayTime(17, 21));
        task = new DisconnectionPairTask(day, 4, browser);
        timer.schedule(task, Time.getTodayTime(17, 22));

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
