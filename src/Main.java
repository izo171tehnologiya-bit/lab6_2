import javax.swing.*;
import java.awt.*;

class Circle_recurs extends JPanel {
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        fractal(g2, 442, 430, 100, 3);
    }

    public void fractal(Graphics2D g, double x, double y, double r, int remain) {
        double diametr = 2*r;
        g.draw(new java.awt.geom.Ellipse2D.Double(x - r, y - r, diametr, diametr)); //рисует по квадрату
        if (remain == 0) return;
        double nextR = r/3;
        double dist = 2*r;
        for (int k = 0; k < 6; k++) {
            double a = k * Math.PI / 3.0;
            double new_x =x + dist * Math.sin(a);
            double new_y = y + dist * Math.cos(a);
            fractal(g, new_x, new_y, nextR, remain - 1);
        }
    }

    public static void main() {
        JFrame f = new JFrame();
        f.add(new Circle_recurs());
        f.setVisible(true);
    }
}