import java.net.*;
import java.io.*;
class UDPC{
	public static void main(String args[]){
		DatagramSocket ds=null;
		InetAddress shost=null;
		DatagramPacket dp=null,reply=null;
		try{
			ds=new DatagramSocket();
			byte[] m="Bye".getBytes();
			shost=InetAddress.getByName("192.168.17.46");
			dp=new DatagramPacket(m,3,shost,1234);			\\3-length of bye 
			ds.send(dp);
			byte[] buffer=new byte[1000];
			reply=new DatagramPacket(buffer,buffer.length);
			ds.receive(reply);
			System.out.println("Reply: "+(new String(reply.getData())).trim());
		}
		catch(Exception e){
			System.out.println("Error: "+e);
		}
	}
}