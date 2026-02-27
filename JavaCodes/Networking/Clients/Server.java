import java.io.*;
import java.net.*;
class Server{
	public static void main(String args[]){
		ServerSocket ss=new ServerSocket(1234);
		Socket cs=ss.accept();	//recieves the socket from the client through listening socket
		DataInputStream sin=new DataInputStream(cs.getInputStream());
		DataOutputStream sout=new DataOutputStream(cs.getOutputStream());
		String str="Welcome";
		sout.writeUTF(str);
		str=sin.readUTF();
		System.out.println("Client: "+str);
	}
}