import java.net.*;
import java.io.*;
class UDPS{
	public static void main(String args[]){
		DatagramSocket ds=null;
		DatagramPacket dp=null,reply;	//reply is a datagram packet
		try{
			ds=new DatagramSocket(1234);
			byte[] buffer=new byte[1000];
			dp=new DatagramPacket(buffer,buffer.length);
			ds.receive(dp);
			System.out.println("From client: "+(new String(dp.getData())).trim());
			System.out.println("Client port:"+dp.getPort());
			reply=new DatagramPacket("From Server:".getBytes(),"From Server".length(),dp.getAddress(),dp.getPort());
			ds.send(reply);
		}
		catch(Exception e){
			System.out.println("Error:"+e);
		}
	}
}
