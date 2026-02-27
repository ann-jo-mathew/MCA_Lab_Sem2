import java.io.*;
class Deserialization{
    public static void main(String args[])throws Exception{
        FileInputStream fin=new FileInputStream("f1.txt");
        ObjectInputStream in=new ObjectInputStream(fin);
        Student s=(Student)in.readObject();
        s.disp();
    }
}