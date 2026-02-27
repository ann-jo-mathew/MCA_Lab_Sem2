//single msg client side
import java.net.*;
import java.io.*;
class Client{
	public static void main(String args[]){
		try{
			Socket ss=new Socket("localhost",1234);
			DataInputStream sin= new DataInputStream(ss.getInputStream());
			DataOutputStream sout=new DataOutputStream(ss.getOutputStream());
			String str=sin.readUTF();
			System.out.println("Server: "+str);
			str="Hello";
			sout.writeUTF(str);
		}
		catch(Exception e){
		 e.printStackTrace();
		}
	}
}
