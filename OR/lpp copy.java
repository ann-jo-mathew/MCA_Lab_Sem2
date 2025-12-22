import java.awt.*;
import javax.swing.*;
import java.util.Scanner;
class LPPGraph extends JPanel{
    double c1, d1, e1, c2, d2, e2;
    LPPGraph(double c1, double d1, double e1,double c2, double d2, double e2) {
        this.c1 = c1;
        this.d1 = d1;
        this.e1 = e1;
        this.c2 = c2;
        this.d2 = d2;
        this.e2 = e2;
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int ox = 50, oy = 350;   // origin
        int scale = 50;         // scale factor
        // Draw axes
        g.drawLine(ox, oy, 400, oy); // X-axis
        g.drawLine(ox, oy, ox, 50);  // Y-axis
        // Constraint 1: c1x + d1y = e1
        int x1 = (int)(e1 / c1 * scale);
        int y1 = (int)(e1 / d1 * scale);
        g.drawLine(ox, oy - y1, ox + x1, oy);
        // Constraint 2: c2x + d2y = e2
        int x2 = (int)(e2 / c2 * scale);
        int y2 = (int)(e2 / d2 * scale);
        g.drawLine(ox, oy - y2, ox + x2, oy);
        // Labels
        g.drawString("x", 380, oy + 15);
        g.drawString("y", ox - 15, 60);
        g.drawString("Feasible Region", 200, 60);
    }
}
public class lpp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Constraint 1 (c1 d1 e1): ");
        double c1 = sc.nextDouble();
        double d1 = sc.nextDouble();
        double e1 = sc.nextDouble();
        System.out.println("Enter Constraint 2 (c2 d2 e2): ");
        double c2 = sc.nextDouble();
        double d2 = sc.nextDouble();
        double e2 = sc.nextDouble();
        JFrame frame = new JFrame("LPP Graphical Solution");
        frame.setSize(450, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LPPGraph panel = new LPPGraph(c1, d1, e1, c2, d2, e2);
        frame.add(panel);
        frame.setVisible(true);
    }
}