import java.net.*;
import java.io.*;
class server{
    public static void main(String args[]){
        try{
            DatagramSocket ds=null;
            DatagramPacket dp=null, reply=null;
            byte[] buffer=new byte[1000];
            ds=new DatagramSocket(1234);
            dp=new DatagramPacket(buffer,buffer.length);    //datagram packet to receive data from client
            ds.receive(dp);
            String str=new String(dp.getData()).trim();
            System.out.println("From Client: "+str);
            String str1="Hello from Server";
            reply=new DatagramPacket(str1.getBytes(),str1.length(),dp.getAddress(),dp.getPort()); //datagram packet to send data to client
            ds.send(reply);


        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}