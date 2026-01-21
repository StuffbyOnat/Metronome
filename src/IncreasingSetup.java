import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class IncreasingSetup extends JFrame {

    public JPanel getPanel() {
        return panel;
    }

    private JPanel panel;
    private JLabel IncreasementAmount;
    private JTextField enterHereTextField;
    private JButton Continue;
    private JButton Back;

    IncreasingSetup(){
        add(panel);

        IncreasementAmount.putClientProperty("FlatLaf.style", "font: 70% $h1.font");//Font
        ImageIcon back = new ImageIcon(getClass().getResource("/Back.png"));
        Image scaledImage = back.getImage().getScaledInstance(12,12,Image.SCALE_SMOOTH);
        ImageIcon ResizedIcon = new ImageIcon(scaledImage);
        Back.setIcon(ResizedIcon);

        enterHereTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);

                enterHereTextField.setText("");
                enterHereTextField.setBackground(new Color(41,43,46));
            }

            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if(enterHereTextField.getText().isEmpty()){
                    enterHereTextField.setText("enter here");
                    enterHereTextField.setBackground(UIManager.getColor("Component.foreground"));

                }
            }
        });

        Continue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Metronome metronome = new Metronome(true);
                metronome.increaseValue = Integer.parseInt(enterHereTextField.getText());//String to int çevirme
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Continue);
                frame.setContentPane(metronome.getPanel1());
                frame.revalidate();
            }
        });
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Back);
                MainMenu menu = new MainMenu(false);
                frame.setContentPane(menu.getMainPanel());
                frame.revalidate();
            }
        });
    }
}
