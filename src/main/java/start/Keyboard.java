package start;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.im.InputContext;

public class Keyboard {
    private final Robot robot;

    public Keyboard() throws AWTException {
        this.robot = new Robot();
    }

    public void clickKeys(int... keys){
        for (int key : keys) {
            robot.keyPress(key);
        }
        for (int key : keys) {
            robot.keyRelease(key);
        }
    }
    public void setEnglish() {
        String language = InputContext.getInstance().getLocale().getDisplayLanguage();
        if(language.equals("украинский")){
            clickKeys(KeyEvent.VK_CONTROL, KeyEvent.VK_SHIFT);
        }
        else if(language.equals("русский")){
            clickKeys(KeyEvent.VK_CONTROL, KeyEvent.VK_SHIFT);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clickKeys(KeyEvent.VK_CONTROL, KeyEvent.VK_SHIFT);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void type(String text) {
        if(Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK)){
            Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_CAPS_LOCK, false);
        }
        char[] keys = text.toCharArray();
        for (char key : keys) {
            switch (key){
                case 'q': clickKeys(KeyEvent.VK_Q); break;
                case 'w': clickKeys(KeyEvent.VK_W); break;
                case 'e': clickKeys(KeyEvent.VK_E); break;
                case 'r': clickKeys(KeyEvent.VK_R); break;
                case 't': clickKeys(KeyEvent.VK_T); break;
                case 'y': clickKeys(KeyEvent.VK_Y); break;
                case 'u': clickKeys(KeyEvent.VK_U); break;
                case 'i': clickKeys(KeyEvent.VK_I); break;
                case 'o': clickKeys(KeyEvent.VK_O); break;
                case 'p': clickKeys(KeyEvent.VK_P); break;
                case 'a': clickKeys(KeyEvent.VK_A); break;
                case 's': clickKeys(KeyEvent.VK_S); break;
                case 'd': clickKeys(KeyEvent.VK_D); break;
                case 'f': clickKeys(KeyEvent.VK_F); break;
                case 'g': clickKeys(KeyEvent.VK_G); break;
                case 'h': clickKeys(KeyEvent.VK_H); break;
                case 'j': clickKeys(KeyEvent.VK_J); break;
                case 'k': clickKeys(KeyEvent.VK_K); break;
                case 'l': clickKeys(KeyEvent.VK_L); break;
                case 'z': clickKeys(KeyEvent.VK_Z); break;
                case 'x': clickKeys(KeyEvent.VK_X); break;
                case 'c': clickKeys(KeyEvent.VK_C); break;
                case 'v': clickKeys(KeyEvent.VK_V); break;
                case 'b': clickKeys(KeyEvent.VK_B); break;
                case 'n': clickKeys(KeyEvent.VK_N); break;
                case 'm': clickKeys(KeyEvent.VK_M); break;

                case 'Q': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_Q); break;
                case 'W': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_W); break;
                case 'E': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_E); break;
                case 'R': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_R); break;
                case 'T': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_T); break;
                case 'Y': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_Y); break;
                case 'U': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_U); break;
                case 'I': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_I); break;
                case 'O': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_O); break;
                case 'P': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_P); break;
                case 'A': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_A); break;
                case 'S': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_S); break;
                case 'D': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_D); break;
                case 'F': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_F); break;
                case 'G': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_G); break;
                case 'H': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_H); break;
                case 'J': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_J); break;
                case 'K': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_K); break;
                case 'L': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_L); break;
                case 'Z': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_Z); break;
                case 'X': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_X); break;
                case 'C': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_C); break;
                case 'V': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_V); break;
                case 'B': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_B); break;
                case 'N': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_N); break;
                case 'M': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_M); break;

                case '1': clickKeys(KeyEvent.VK_1); break;
                case '2': clickKeys(KeyEvent.VK_2); break;
                case '3': clickKeys(KeyEvent.VK_3); break;
                case '4': clickKeys(KeyEvent.VK_4); break;
                case '5': clickKeys(KeyEvent.VK_5); break;
                case '6': clickKeys(KeyEvent.VK_6); break;
                case '7': clickKeys(KeyEvent.VK_7); break;
                case '8': clickKeys(KeyEvent.VK_8); break;
                case '9': clickKeys(KeyEvent.VK_9); break;
                case '0': clickKeys(KeyEvent.VK_0); break;

                case '!': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_1); break;
                case '@': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_2); break;
                case '#': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_3); break;
                case '$': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_4); break;
                case '%': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_5); break;
                case '^': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_6); break;
                case '&': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_7); break;
                case '*': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_8); break;
                case '(': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_9); break;
                case ')': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_0); break;

                case '-': clickKeys(KeyEvent.VK_MINUS); break;
                case '=': clickKeys(KeyEvent.VK_EQUALS); break;
                case '[': clickKeys(KeyEvent.VK_OPEN_BRACKET); break;
                case ']': clickKeys(KeyEvent.VK_CLOSE_BRACKET); break;
                case ';': clickKeys(KeyEvent.VK_SEMICOLON); break;
                case '\'': clickKeys(KeyEvent.VK_QUOTE); break;
                case ',': clickKeys(KeyEvent.VK_COMMA); break;
                case '.': clickKeys(KeyEvent.VK_DECIMAL); break;
                case '/': clickKeys(KeyEvent.VK_SLASH); break;
                case '\\': clickKeys(KeyEvent.VK_BACK_SLASH); break;
                case ' ': clickKeys(KeyEvent.VK_SPACE); break;

                case '_': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_MINUS); break;
                case '+': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_EQUALS); break;
                case '{': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_OPEN_BRACKET); break;
                case '}': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_CLOSE_BRACKET); break;
                case ':': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_SEMICOLON); break;
                case '"': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_QUOTE); break;
                case '<': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_COMMA); break;
                case '>': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_PERIOD); break;
                case '?': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_SLASH); break;
                case '|': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_BACK_SLASH); break;
                case '~': clickKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_BACK_QUOTE); break;
            }
        }
    }
}
