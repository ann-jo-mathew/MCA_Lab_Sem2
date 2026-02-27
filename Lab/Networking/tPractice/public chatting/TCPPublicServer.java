import java.net.*;
import java.io.*;
class ChatRoom {
    Socket cs[] = new Socket[50];
    DataOutputStream sout[] = new DataOutputStream[50];//broadcast purpose
    int count = 0;//count no. of clinets
    public synchronized void add(Socket s) throws Exception {
        cs[count] = s;
        sout[count] = new DataOutputStream(s.getOutputStream());//creates an output stream for each clinet
        count++;
        System.out.println("Client connected. Total: " + count);
    }
    public synchronized void broadcast(String msg) throws Exception {
        for (int i = 0; i < count; i++) {
            sout[i].writeUTF(msg);//all msges in the server send to all clinets
        }
    }
}
class ClientThread extends Thread {
    Socket s;
    DataInputStream sin;
    ChatRoom room;
    ClientThread(Socket s, ChatRoom room) throws Exception {
        this.s = s;
        this.room = room;
        sin = new DataInputStream(s.getInputStream());
    }
    public void run() {
        try {
            while (true) {
                String msg = sin.readUTF(); //receive msg
                if (msg.equals("q"))
                    break;
                room.broadcast(msg);//send the msg frm a client to every other client
            }
        } 
        catch (Exception e) {}
    }
}
class TCPPublicServer {
    public static void main(String args[]) throws Exception {
        ServerSocket ss = new ServerSocket(1234);
        System.out.println("Public Chat Server Started on 1234...");
        ChatRoom room = new ChatRoom(); // ONE shared object (like CPrint p)
        while (true) {
            Socket s = ss.accept();
            room.add(s);
            ClientThread t = new ClientThread(s, room);
            t.start();
        }
    }
}