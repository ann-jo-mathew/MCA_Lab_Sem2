import java.awt.*;
import javax.swing.*;
import java.util.Scanner;
class LPPGraph extends JPanel {     //contraints in the from a[i]x + b[i]y ≤ c[i] and obj in form Z = px + qy
    double p,q,a[],b[],c[];     //p,q stores coefficients of obj; a,b,c stores coefficients of constraints 
    int n,type;                //n - number of constraints; type store int value for indicating 1.max/2.min
    double optX,optY;          //stores optimal x and y values
    LPPGraph(double a[],double b[],double c[],int n,double p,double q,int type,double optX,double optY) {
        this.a=a;
        this.b=b;
        this.c=c;
        this.n=n;
        this.p=p;
        this.q=q;
        this.type=type;
        this.optX=optX;
        this.optY=optY;
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2=(Graphics2D)g;
        g2.setStroke(new BasicStroke(2));

        int ox=60,oy=360;   // ox,oy origin of graph(0,0)
        int scale=50;       //scale of graph used for converting math units to pixels

        g2.setColor(Color.BLACK);
        g2.drawLine(ox,oy,420,oy);   // X-axis
        g2.drawLine(ox,oy,ox,60);    // Y-axis

        // Scale markings
        for(int i=0;i<=6;i++) {
            int x=ox+i*scale;
            int y=oy-i*scale;

            g2.drawLine(x,oy-3,x,oy+3);
            g2.drawLine(ox-3,y,ox+3,y);

            if(i!=0) {
                g2.drawString(""+i,x-5,oy+20);
                g2.drawString(""+i,ox-25,y+5);
            }
        }

        g2.setColor(new Color(200,230,250));      // Feasible region
        for(int px=ox;px<=420;px++) {
            for(int py=oy;py>=60;py--) {

                double x=(px-ox)/(double)scale;   //pixel to graph conversion
                double y=(oy-py)/(double)scale;

                boolean feasible=true;
                for(int i=0;i<n;i++) {
                    if(a[i]*x+b[i]*y>c[i]) {
                        feasible=false;
                        break;
                    }
                }
                if(feasible)
                    g2.fillRect(px,py,1,1);
            }
        }

        g2.setColor(Color.BLACK);
        for(int i=0;i<n;i++) {
            int xInt=(int)((c[i]/a[i])*scale);   // x-intercept of contraint line
            int yInt=(int)((c[i]/b[i])*scale);   // y-intercept of contraint line
            g2.drawLine(ox,oy-yInt,ox+xInt,oy);
            g2.drawString(a[i]+"x + "+b[i]+"y ≤ "+c[i],250,80+i*15);
        }

        // Optimal point plotting
        int px=ox+(int)(optX*scale);
        int py=oy-(int)(optY*scale);

        g2.setColor(Color.RED);
        g2.fillOval(px-4,py-4,8,8);
        g2.drawString("Optimal ("+optX+", "+optY+")",px+6,py-6);

        g2.setColor(Color.BLACK);
        g2.drawString((type==1?"Maximize Z= ":"Minimize Z= ")+p+"x+"+q+"y",150,40);
        g2.drawString("x",415,oy+20);
        g2.drawString("y",ox-20,65);
    }
}

public class lpp {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        double p,q,a[],b[],c[];

        System.out.print("1. Maximization \n2. Minimization \nEnter your choice: ");
        int type=sc.nextInt();

        System.out.println("Enter objective function coefficients: ");
        p=sc.nextDouble();
        q=sc.nextDouble();

        System.out.print("Enter number of constraints: ");
        int n=sc.nextInt();

        a=new double[n];
        b=new double[n];
        c=new double[n];

        for(int i=0;i<n;i++) {
            System.out.println("Enter three constraint cofficients: ");
            a[i]=sc.nextDouble();
            b[i]=sc.nextDouble();
            c[i]=sc.nextDouble();
        }

        double optZ=(type==1)?-Double.MAX_VALUE:Double.MAX_VALUE;   //stores optimal value of Z
        double optX=0,optY=0;   //stores optimal values of x and y

        for(int i=0;i<n;i++){       // Check all intersection points
            for(int j=i+1;j<n;j++){

                double det=a[i]*b[j]-a[j]*b[i]; //used to check lines intersection
                if(det==0)
                    continue; // parallel lines no intersection

                double x=(c[i]*b[j]-c[j]*b[i])/det;
                double y=(a[i]*c[j]-a[j]*c[i])/det;

                if(x<0||y<0) continue;

                boolean feasible=true;
                for(int k=0;k<n;k++) {
                    if(a[k]*x+b[k]*y>c[k]) {
                        feasible=false;
                        break;
                    }
                }

                if(feasible) {
                    double Z=p*x+q*y;   //value of objective function at (x,y)
                    if((type==1&&Z>optZ)||(type==2&&Z<optZ)) {
                        optZ=Z;
                        optX=x;
                        optY=y;
                    }
                }
            }
        }

        System.out.println("\nOptimal Solution:");
        System.out.println("x= "+optX);
        System.out.println("y= "+optY);
        System.out.println("Optimal Z= "+optZ);

        JFrame frame=new JFrame("LPP Graphical Method");
        frame.setSize(500,480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new LPPGraph(a,b,c,n,p,q,type,optX,optY));
        frame.setVisible(true);
    }
}
