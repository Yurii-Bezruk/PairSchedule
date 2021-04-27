import days.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
            Brawser brawser = new Brawser(Account.loadFromFile("account.txt"));
            //brawser.authorizate();
            brawser.connectToPair(new Friday().getPair(3));
            Thread.sleep(2000);
            brawser.connectToPair(new Friday().getPair(4));

            Scanner s = new Scanner(System.in);
            while(true){
                if(s.next().equals("exit"))
                    break;
            }
            brawser.close();

        //email.sendKeys((CharSequence) "xa12284003@student.karazin.ua", Keys.ENTER);
       /* Actions builder = new Actions(driver);
        builder.keyDown(Keys.TAB).perform();*/
        //email.sendKeys((CharSequence) "xa12284003@student.karazin.ua");
        //driver.findElement()
        /*TimerTask task = new PairTask();
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
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*timer.cancel();
        System.out.println("TimerTask прекращена");
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://pn.com.ua//ct//1003");
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_T);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_T);

            driver.get("https://pn.com.ua//ct//1003");
            Thread.sleep(2000);
            driver.get("https://pn.com.ua//ct//1003");
        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();*/
    }
}
