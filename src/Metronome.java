import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Metronome extends JPanel implements Utilities {

    public JPanel getPanel1() {
        return panel1;
    }

    private JPanel panel1;
    private JButton PlayButton;
    public JSlider slider1;
    private JButton Plus;
    private JButton Minus;
    private JLabel BPM;
    boolean isPaused = true;
    boolean increase = false;
    int increaseValue;

    Metronome(boolean increase){
        add(panel1);
        this.increase=increase;

        ImageIcon PlayIcon = new ImageIcon(getClass().getResource("/play.png"));
        Image scaledImage = PlayIcon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(scaledImage);
        PlayButton.setPreferredSize(new Dimension(1,200));
        PlayButton.setIcon(resizedIcon);
        PlayButton.setBackground(getBackground());
        PlayButton.setFocusPainted(false);
        PlayButton.setBorderPainted(false);
        BPM.putClientProperty("FlatLaf.styleClass", "h1");//Font

        Mechanism mechanism = new Mechanism(this,increase);

        Timer bpmUpdater = new Timer(100, e -> {
            int bpm = slider1.getValue();
            BPM.setText(bpm + " BPM");
        });
        bpmUpdater.start();


        Plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int current = slider1.getValue();
                if(current < slider1.getMaximum())
                    slider1.setValue(current+1);
            }
        });
        Minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int current = slider1.getValue();
                if(current > slider1.getMinimum())
                    slider1.setValue(current-1);
            }
        });
        PlayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (isPaused) {
                    addIcon(PlayButton,"/pause.png",90,90);
                    isPaused = false;
                    mechanism.start();
                }
                else {
                    addIcon(PlayButton, "/play.png",120,120);
                    isPaused = true;
                    mechanism.stop();
                }
            }
        });
    }

    @Override
    public void addIcon(JButton button, String path, int width, int height) {

        ImageIcon Icon = new ImageIcon(getClass().getResource(path));
        Image scaledImage = Icon.getImage().getScaledInstance(width,height,Image.SCALE_SMOOTH);
        ImageIcon ResizedIcon = new ImageIcon(scaledImage);
        button.setIcon(ResizedIcon);

    }
}
