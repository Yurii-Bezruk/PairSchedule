package main;

import days.*;
import exceptions.NotWorkingDayException;
import exceptions.PairNotAvailableException;
import tasks.ConnectionPairTask;
import tasks.PairTask;

import java.util.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, PairNotAvailableException {
        Browser browser = new Browser();
        Day day = null;
        try {
            day = Day.getCurrentWorkingDayOfWeek();
        } catch (NotWorkingDayException e) {
            e.printStackTrace();
            return;
        }
        TimerTask task = new ConnectionPairTask(day, 1, browser);
        Date now = new Date();
        now.setHours(8);
        now.setMinutes(30);
        now.setSeconds(0);
        Timer timer = new Timer(true);
        timer.schedule(task, now);
        //timer.scheduleAtFixedRate(task, 0, 10*1000);
        Scanner s = new Scanner(System.in);
        while(true){
            if(s.next().equals("exit"))
                break;
        }
        browser.close();
       //timer.cancel();
        System.out.println("TimerTask прекращена");
    }
}
