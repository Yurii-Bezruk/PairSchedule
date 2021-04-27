import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pairs.Pair;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class Brawser {
    private static final String AUTHORIZATION_PAGE = "https://accounts.google.com/signin/v2/challenge/pwd?elo=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin&cid=1&navigationDirection=forward&TL=AM3QAYZo-81FtA5whALcGueua3MT2F7xE1GuyFnNVc4CK9Ozbwcio27UY-jW_Ftb";
    private WebDriver driver;
    private Keyboard keyboard;
    private Account user;

    public Brawser(Account user) {
        this.user = user;
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);   //выкл всплывашки
        prefs.put("profile.default_content_setting_values.media_stream_mic", 1);    //вкл микро
        prefs.put("profile.default_content_setting_values.media_stream_camera",1);  //вкл камера
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        String FILE_NAME_PROFILE = "C:\\Users\\User\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1";
        options.addArguments("user-data-dir=" + FILE_NAME_PROFILE);


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\PairShedule\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver(options);
        try {
            keyboard = new Keyboard();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void authorizate(){
        driver.get(AUTHORIZATION_PAGE);
        sleep(2);
        driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).click();
        sleep(1);
        keyboard.setEnglish();
        //driver.findElement(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[1]/div/div[3]")).click();
        keyboard.type(user.getEmail());
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/div[2]")).click();
        sleep(2);
        driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).click();
        keyboard.type(user.getPassword());
        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/div[2]")).click();
        sleep(2);
    }

    public void connectToPair(Pair pair){
        String link = pair.getLink();
        driver.get(link);
        keyboard.clickKeys(KeyEvent.VK_ENTER);
        sleep(3);
        if(!link.contains("zoom")) {
            keyboard.clickKeys(KeyEvent.VK_CONTROL, KeyEvent.VK_D);
            keyboard.clickKeys(KeyEvent.VK_CONTROL, KeyEvent.VK_E);
            driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/div[9]/div[3]/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div/div[1]/div[1]/span/span")).click();
        }
    }

    public void close(){
        driver.close();
    }

    private void sleep(double seconds){
        try {
            Thread.sleep((long) (seconds*1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
