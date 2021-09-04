package com.striker.meetings.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.striker.meetings.bean.Meeting;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class Browser {
    private static final By join = By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/div[9]/div[3]/div/div/div[4]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/span/span");
    private static final By leave = By.xpath("//button[@aria-label=\"Завершити дзвінок\"]/i");

    private final WebDriver driver;
    private Keyboard keyboard;
    private boolean active;

    public Browser() {
        ChromeOptions options = initializeOptions();
        String FILE_NAME_PROFILE = "C:\\Users\\User\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1";
        options.addArguments("user-data-dir=" + FILE_NAME_PROFILE); //using default account

        driver = new ChromeDriver(options);
        try {
            keyboard = new Keyboard();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        active = true;
    }
    private ChromeOptions initializeOptions(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);   //disable notifications
        prefs.put("profile.default_content_setting_values.media_stream_mic", 1);    //allow micro
        prefs.put("profile.default_content_setting_values.media_stream_camera",1);  //allow camera
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.setExperimentalOption("excludeSwitches", new String[] { "test-type" });    //allow screen demonstrating
        return options;
    }

    public void connectToMeeting(Meeting meeting){
        try {
            String link = meeting.getLink();
            driver.get(link);
            keyboard.clickKeys(KeyEvent.VK_ENTER);
            sleep(3);
            if(! link.contains("zoom")) {
                keyboard.clickKeys(KeyEvent.VK_CONTROL, KeyEvent.VK_D);   //mute micro
                keyboard.clickKeys(KeyEvent.VK_CONTROL, KeyEvent.VK_E);   //mute camera
                sleep(1);
                driver.findElement(join).click();
            }
        } catch (Exception any){
            active = false;
        }
    }
    public void disconnectFromMeeting(Meeting meeting){
        try {
            if(! meeting.getLink().contains("zoom")) {
                driver.findElement(leave).click();
            }
        } catch (Exception any){
            active = false;
        }
    }

    public boolean isActive() {
        return active;
    }

    public void close(){
        try {
            driver.close();
        } catch (WebDriverException ignored){} //if browser already closed, do nothing
        active = false;
    }

    private void sleep(double seconds){
        try {
            Thread.sleep((long) (seconds*1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
