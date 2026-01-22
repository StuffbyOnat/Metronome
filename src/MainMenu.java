import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    private JLabel Metronome;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private JPanel mainPanel;
    private JButton ClassicButton;
    private JButton IncreasingButton;
    Metronome metronome;
    boolean visible= true;
    boolean increase = false;

    MainMenu(boolean visible){

        this.visible=visible;
       add(mainPanel);
       setTitle("Metronome");
       setSize(400,300);
       setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (visible)
            setVisible(true);
        else
            setVisible(false);

        Metronome.putClientProperty("FlatLaf.styleClass", "h1");//Font

        IncreasingButton.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(IncreasingButton);
            IncreasingSetup setupPanel = new IncreasingSetup();
            frame.setContentPane(setupPanel.getPanel());
            frame.revalidate();
        });
        ClassicButton.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(ClassicButton);
            Metronome metronome = new Metronome(false);
            frame.setContentPane(metronome.getPanel1());
            frame.revalidate();
            System.out.println("Classic geçiş tetiklendi");
        });
    }
}
