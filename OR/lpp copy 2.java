import java.awt.*;
import javax.swing.*;
import java.util.Scanner;

class LPPGraph extends JPanel {

    double a[], b[], c[];
    int n;

    LPPGraph(double a[], double b[], double c[], int n) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.n = n;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int ox = 50, oy = 350;
        int scale = 50;

        // Axes
        g.drawLine(ox, oy, 400, oy);
        g.drawLine(ox, oy, ox, 50);

        //g.setColor(new Color(200, 200, 255));

        // Constraint lines
        for (int i = 0; i < n; i++) {
            if (a[i] == 0 || b[i] == 0) continue;

            int xInt = (int)((c[i] / a[i]) * scale);
            int yInt = (int)((c[i] / b[i]) * scale);

            g.drawLine(ox, oy - yInt, ox + xInt, oy);
            //g.drawString("C" + (i + 1), ox + xInt + 5, oy - yInt + 5);
        }

        g.drawString("x", 380, oy + 15);
        g.drawString("y", ox - 15, 60);
        //g.drawString("Feasible Region", 200, 60);
    }
}

public class lpp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);     
        System.out.print("Enter 1 for Maximization, 2 for Minimization: ");
        int choice = sc.nextInt();
        // Constraints
        System.out.print("Enter number of constraints: ");
        int n = sc.nextInt();
        // Objective function
        System.out.println("Objective Function: Z = px + qy");
        System.out.print("Enter p: ");
        double p = sc.nextDouble();
        System.out.print("Enter q: ");
        double q = sc.nextDouble();

        double a[] = new double[n];
        double b[] = new double[n];
        double c[] = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter constraint " + (i + 1) + " (a b c): ");
            a[i] = sc.nextDouble();
            b[i] = sc.nextDouble();
            c[i] = sc.nextDouble();
        }

        // Corner points (basic graphical method)
        double[][] points = {
            {0, 0},
            {c[0] / a[0], 0},
            {0, c[0] / b[0]},
            {c[1] / a[1], 0},
            {0, c[1] / b[1]}
        };

        double bestZ = (choice == 1) ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
        double bestX = 0, bestY = 0;

        for (double[] pt : points) {
            double x = pt[0];
            double y = pt[1];

            boolean feasible = true;
            for (int i = 0; i < n; i++) {
                if (a[i] * x + b[i] * y > c[i]) {
                    feasible = false;
                    break;
                }
            }

            if (feasible) {
                double Z = p * x + q * y;

                if ((choice == 1 && Z > bestZ) ||
                    (choice == 2 && Z < bestZ)) {
                    bestZ = Z;
                    bestX = x;
                    bestY = y;
                }
            }
        }

        System.out.println("\nOptimal Solution:");
        System.out.println("Z = " + bestZ + " at (" + bestX + ", " + bestY + ")");

        // Graph window
        JFrame frame = new JFrame("LPP Graphical Solution");
        frame.setSize(450, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new LPPGraph(a, b, c, n));
        frame.setVisible(true);
    }
}
