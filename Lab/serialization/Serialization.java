import java.io.*;
class Serialization{
    public static void main(String args[])throws Exception{
        Student s1=new Student(01,"Amala");
        FileOutputStream fout=new FileOutputStream("f1.txt");
        ObjectOutputStream out=new ObjectOutputStream(fout);
        out.writeObject(s1);
        out.flush();
    }

}