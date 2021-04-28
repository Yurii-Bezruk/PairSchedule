import days.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        new Wednesday().getPair(1);
       /* Brawser brawser = new Brawser();
        Day day;


        TimerTask task = new PairTask(day, 1, brawser);
        Date now = new Date();
        int hours, minutes;
        try {
            hours = Integer.parseInt(args[0]);
            minutes = Integer.parseInt(args[1]);
        } catch (Exception e) {
            e.printStackTrace();
            hours = 17;
            minutes = 50;
        }

        now.setHours(hours);
        now.setMinutes(minutes);
        now.setSeconds(0);
        Timer timer = new Timer(true);
        timer.schedule(task, now);
        //timer.scheduleAtFixedRate(task, 0, 10*1000);
        //System.out.println(now);

        // вызываем cancel() через какое-то время
        Scanner s = new Scanner(System.in);
        while(true){
            if(s.next().equals("exit"))
                break;
        }
        timer.cancel();
        System.out.println("TimerTask прекращена");*/
    }
}
