import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;

public class Main {

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
UIManager.setLookAndFeel(new FlatDarkLaf());
        UIManager.put("Button.arc", 999); // 0 → köşesiz, 999 → tam yuvarlak


//Metronome test = new Metronome();
        MainMenu test = new MainMenu(true);

    }
}
