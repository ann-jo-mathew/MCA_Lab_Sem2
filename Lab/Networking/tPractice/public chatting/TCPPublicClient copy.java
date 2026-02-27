import java.net.*;
import java.io.*;
import java.util.Scanner;
class TCPPublicClient {
    public static void main(String args[]) {
        try {
            Socket ss = new Socket("localhost", 1234);
            DataInputStream sin = new DataInputStream(ss.getInputStream());
            DataOutputStream sout = new DataOutputStream(ss.getOutputStream());
            Scanner kin = new Scanner(System.in);
            new ReadThread(sin).start();
            System.out.println("Type message. Type q to quit.");
            while (true) {
                String msg = kin.nextLine();
                sout.writeUTF(msg);
                if (msg.equals("q"))
                    break;
            }
            ss.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
class ReadThread extends Thread {
    DataInputStream sin;
    ReadThread(DataInputStream sin) {
        this.sin = sin;
    }
    public void run() {
        try {
            while (true) {
                System.out.println(sin.readUTF());
            }
        } 
        catch (Exception e) {
        }
    }
}