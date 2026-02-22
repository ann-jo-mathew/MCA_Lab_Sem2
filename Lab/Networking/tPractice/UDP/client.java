import java.net.*;
import java.io.*;
class client{
    public static void main(String args[]){
        try{
            DatagramSocket ds=null;
            DatagramPacket dp=null,reply=null;
            InetAddress shost;
            ds=new DatagramSocket();
            shost=InetAddress.getByName("localhost");
            byte[] bmsg="Bye".getBytes();
            dp=new DatagramPacket(bmsg,bmsg.length,shost,1234);
            ds.send(dp);
            byte[] buffer=new byte[1000];
            reply=new DatagramPacket(buffer,buffer.length);
            ds.receive(reply);
            String str=new String(reply.getData()).trim();
            System.out.println("Server:"+str);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}