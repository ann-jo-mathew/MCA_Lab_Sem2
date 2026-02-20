import java.awt.*;
import java.awt.event.*;
class CList extends Frame implements ActionListener{
    List l1,l2;
    TextField t1;
    Button badd, bright,bleft;
    public CList(){
        super("List Content Transfer");
        l1=new List(5);
        l2=new List(5);
        t1=new TextField(20);
        badd=new Button("Add");
        bright=new Button(">>");
        bleft=new Button("<<");
        setLayout(new FlowLayout());
        add(l1);
        add(bright);
        add(bleft);
        add(l2);
        add(t1);
        add(badd);
        badd.addActionListener(this);
        bright.addActionListener(this);
        bleft.addActionListener(this);
        setSize(700,700);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==badd){
            String s=t1.getText();
            l1.add(s);
            t1.setText("");
        }
        else if(ae.getSource()==bright){
            int p=l1.getSelectedIndex();
            if(p>=0){
                String s=l1.getSelectedItem();
                l2.add(s);
                l1.remove(p);
            }
        }
        else if(ae.getSource()==bleft){
            int p=l2.getSelectedIndex();
            if(p>=0){
                String s=l2.getSelectedItem();
                l1.add(s);
                l2.remove(p);
            }
        }
    }
    public static void main(String args[]){
        new CList();
    }
}