import java.net.*;
import java.io.*;
class TCPPublicServer {
    Socket cs[] = new Socket[50];
    DataOutputStream sout[] = new DataOutputStream[50];
    int count = 0;
    synchronized void addClient(Socket s) throws Exception {
        cs[count] = s;
        sout[count] = new DataOutputStream(s.getOutputStream());
        count++;
        System.out.println("Client connected. Total: " + count);
    }
    synchronized void broadcast(String msg) {
        for (int i = 0; i < count; i++) {
            try {
                sout[i].writeUTF(msg);
            } catch (Exception e) {
            }
        }
    }
    public static void main(String args[]) {
        try {
            TCPPublicServer server = new TCPPublicServer(); // ONE server object
            ServerSocket ss = new ServerSocket(1234);
            System.out.println("Public Chat Server Started...");
            while (true) {
                Socket s = ss.accept();
                server.addClient(s);
                ClientThread t = new ClientThread(s, server);
                t.start();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}






class ClientThread extends Thread {
    Socket s;
    DataInputStream sin;
    TCPPublicServer server;
    ClientThread(Socket s, TCPPublicServer server) throws Exception {
        this.s = s;
        this.server = server;
        sin = new DataInputStream(s.getInputStream());
    }
    public void run() {
        try {
            while (true) {
                String msg = sin.readUTF();
                if (msg.equals("q"))
                    break;
                System.out.println("Msg: " + msg);
                server.broadcast(msg);
            }
        } catch (Exception e) {
        }
    }
}