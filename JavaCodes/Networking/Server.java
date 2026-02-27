//single msg server side
import java.io.*;
import java.net.*;
class Server{
	public static void main(String args[]){
		try{
			ServerSocket ss=new ServerSocket(1234);
			System.out.println("Server Listening....");
			Socket cs=ss.accept();	//recieves the socket from the client through listening socket
			System.out.println("Cleint socket recieved...");
			DataInputStream sin=new DataInputStream(cs.getInputStream());
			DataOutputStream sout=new DataOutputStream(cs.getOutputStream());
			String str="Welcome";
			sout.writeUTF(str);
			str=sin.readUTF();
			System.out.println("Client: "+str);
		}
		catch(Exception e){
			System.out.println("Error: "+e);
		}
		
	}
}