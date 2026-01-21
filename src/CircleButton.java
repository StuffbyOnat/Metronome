import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class CircleButton extends JButton {
    public CircleButton(String label) {
        super(label);
        setOpaque(false); // Arka planı şeffaf yapar
        setFocusPainted(false); // Odak çizgisini kaldırır
        setContentAreaFilled(false); // Varsayılan dolgu rengini kaldırır
        setBorderPainted(false); // Varsayılan kenarlığı kaldırır
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        // Butonun basılı olup olmadığını kontrol et
        if (getModel().isArmed()) {
            g2.setColor(getBackground().darker());
        } else {
            g2.setColor(getBackground());
        }

        // Daireyi çiz
        g2.fillOval(0, 0, getWidth(), getHeight());

        // Metni çiz
        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(Color.GRAY);
        g2.drawOval(0, 0, getWidth() - 1, getHeight() - 1);
        g2.dispose();
    }

    @Override
    public boolean contains(int x, int y) {
        Ellipse2D circle = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
        return circle.contains(x, y);
    }
}