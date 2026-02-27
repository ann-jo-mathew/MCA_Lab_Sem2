import java.net.*;
import java.io.*;  
class ReadThread extends Thread {       //class responsible for displaying all the chats thats been broadcasted
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
        catch (Exception e) {}
    }
}
class TCPPublicClient {
    public static void main(String args[]) throws Exception {
        Socket ss = new Socket("localhost", 1234);
        DataInputStream sin = new DataInputStream(ss.getInputStream());
        DataOutputStream sout = new DataOutputStream(ss.getOutputStream());
        DataInputStream kin = new DataInputStream(System.in);
        new ReadThread(sin).start();
        System.out.println("Type message. Type q to quit.");
        while (true) {
            String msg = kin.readLine();
            sout.writeUTF(msg);
            if (msg.equals("q"))
                break;
        }
        ss.close();
    }
}