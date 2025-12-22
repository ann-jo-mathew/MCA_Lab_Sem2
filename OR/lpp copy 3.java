import java.awt.*;
import javax.swing.*;
import java.util.Scanner;
class LPPGraph extends JPanel {     //contraints in the from a[i]x + b[i]y ≤ c[i] and obj in form Z = px + qy
    double p,q,a[],b[],c[];     //p,q stores coefficients of obj; a,b,c stores coefficients of constraints 
    int n,type;     //n - number of constraints; type store int value for indicating 1.max/2.min
    double optX,optY,optZ;   //stores optimal solution to plot
    LPPGraph(double a[],double b[],double c[],int n,double p,double q,int type,double optX,double optY,double optZ) {
        this.a=a;
        this.b=b;
        this.c=c;
        this.n=n;
        this.p=p;
        this.q=q;
        this.type=type;
        this.optX=optX;
        this.optY=optY;
        this.optZ=optZ;
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int ox=50,oy=350;   // ox,oy origin of graph(0,0)
        int scale=50;   //scale of graph used for converting math units to pixels to plot int the graph
        g.setColor(Color.BLACK);
        g.drawLine(ox,oy,400,oy);
        g.drawLine(ox,oy,ox,50);
        g.setColor(new Color(180,220,255));      // Feasible region
        for (int px=ox;px<=400;px++) {
            for (int py=oy;py>=50;py--) {
                double x=(px-ox)/(double)scale;     //x,y converted real values
                double y=(oy-py)/(double)scale;
                boolean feasible = true;
                for (int i=0;i<n;i++) {
                    if (a[i]*x+b[i]*y>c[i]) {
                        feasible=false;
                        break;
                    }
                }
                if (feasible)
                    g.fillRect(px,py,1,1);
            }
        }
        g.setColor(Color.BLACK);
        for (int i=0;i<n;i++) {
            int xInt=(int)((c[i]/a[i])*scale);  // x-intercept of contraint line
            int yInt=(int)((c[i]/b[i])*scale);  // y-intercept of contraint line, used to draw constraint lines on graph
            g.drawLine(ox,oy-yInt,ox+xInt,oy);
        }
        g.drawString((type==1?"Maximize Z= ":"Minimize Z= ")+p+"x+"+q+"y",150,40);
        g.drawString("x",380,oy+15);
        g.drawString("y",ox-15,60);
        g.setColor(Color.RED);
        int pxOpt=ox+(int)(optX*scale);
        int pyOpt=oy-(int)(optY*scale);
        g.fillOval(pxOpt-4,pyOpt-4,8,8);
        g.drawString("Optimal ("+optX+", "+optY+")",pxOpt+5,pyOpt-5);

    }
}
public class lpp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
        for (int i=0;i<n;i++) {
            System.out.println("Enter three constraint cofficients: ");
            a[i]=sc.nextDouble();
            b[i]=sc.nextDouble();
            c[i]=sc.nextDouble();
        }
        double optZ=(type==1)?-Double.MAX_VALUE:Double.MAX_VALUE;   //stores optimal value of Z, they are initialized as -infinity for max and +infinity for min
        double optX=0,optY=0;   //stores optimal values of x and y
        for(int i=0;i<n;i++){       // Check all intersection points
            for(int j=i+1;j<n;j++){
                double det=a[i]*b[j]-a[j]*b[i]; //used to check lines intersection
                if(det==0) 
                    continue; // parallel lines no intersection
                double x=(c[i]*b[j]-c[j]*b[i])/det;
                double y=(a[i]*c[j]-a[j]*c[i])/det;
                if(x<0||y<0)continue;
                boolean feasible=true;
                for(int k=0;k<n;k++) {
                    if (a[k]*x+b[k]*y>c[k]){
                        feasible=false;
                        break;
                    }
                }
                if(feasible){
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
        frame.setSize(450,450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new LPPGraph(a,b,c,n,p,q,type,optX,optY,optZ));
        frame.setVisible(true);
    }
}