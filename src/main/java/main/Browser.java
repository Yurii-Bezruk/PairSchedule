package main;

import exceptions.UserNotDefinedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pairs.Pair;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class Browser {
    private static final String AUTHORIZATION_PAGE = "https://accounts.google.com/signin/v2/challenge/pwd?elo=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin&cid=1&navigationDirection=forward&TL=AM3QAYZo-81FtA5whALcGueua3MT2F7xE1GuyFnNVc4CK9Ozbwcio27UY-jW_Ftb";
    private static final By emailField = By.xpath("//*[@id=\"identifierId\"]");
    private static final By emailNext = By.xpath("//*[@id=\"identifierNext\"]/div/button/div[2]");
    private static final By passwordField = By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input");
    private static final By passwordNext = By.xpath("//*[@id=\"passwordNext\"]/div/button/div[2]");
    private static final By join = By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/div[9]/div[3]/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div/div[1]/div[1]/span/span");
    private static final By leave = By.xpath("//*[@id=\"ow3\"]/div[1]/div/div[9]/div[3]/div[9]/div[2]/div[2]/div");

    private WebDriver driver;
    private Keyboard keyboard;
    private Account user;
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

    public Browser(Account user) {
        ChromeOptions options = initializeOptions();
        driver = new ChromeDriver(options);
        try {
            keyboard = new Keyboard();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        this.user = user;
        active = true;
    }
    private ChromeOptions initializeOptions(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\PairShedule\\chromedriver_win32\\chromedriver.exe");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);   //disable notifications
        prefs.put("profile.default_content_setting_values.media_stream_mic", 1);    //allow micro
        prefs.put("profile.default_content_setting_values.media_stream_camera",1);  //allow camera
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        return options;
    }

    public void authorizate() throws UserNotDefinedException {
        if(user == null)
            throw new UserNotDefinedException();
        driver.get(AUTHORIZATION_PAGE);
        sleep(2);
        driver.findElement(emailField).click();
        sleep(1);
        keyboard.setEnglish();
        keyboard.type(user.getEmail());
        driver.findElement(emailNext).click();
        sleep(2);
        driver.findElement(passwordField).click();
        keyboard.type(user.getPassword());
        driver.findElement(passwordNext).click();
        sleep(2);
    }

    public void connectToPair(Pair pair){
        String link = pair.getLink();
        driver.get(link);
        keyboard.clickKeys(KeyEvent.VK_ENTER);
        sleep(3);
        if(! link.contains("zoom")) {
            keyboard.clickKeys(KeyEvent.VK_CONTROL, KeyEvent.VK_D);        //mute micro
            keyboard.clickKeys(KeyEvent.VK_CONTROL, KeyEvent.VK_E);         //mute camera
            driver.findElement(join).click();
        }
    }
    public void disconnectFromPair(Pair pair){
        if(! pair.getLink().contains("zoom")) {
            driver.findElement(leave).click();
        }
    }

    public boolean isActive() {
        return active;
    }

    public void close(){
        driver.close();
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
