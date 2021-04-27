import days.Wednesday;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.*;
import java.util.Date;
import java.util.TimerTask;

public class PairTask extends TimerTask {
    @Override
    public void run() {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\PairShedule\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get(new Wednesday().getPair(2).getLink());/*
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
        }*/
    }
}
