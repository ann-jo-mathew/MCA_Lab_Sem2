//Multi Clients Fiel upload and download

import  java.io.*;
import java.net.*;
class MFClient{
	public static void main(String args[]){
		try{
			Socket cs=new Socket("localhost",1234);		\\licalhost-same computer, diff sysm then give sysms ip adderes 
									\\ 1234- is the server address we are going to communicate, the port the server is listening to
			DataInputStream sin,kin;	\\kin-keyboard input
			DataOutputStream sout;
			sin=new DataInputStream(cs.getInputStream());
			sout=new DataOutputStream(cs.getOutputStream());
			kin=new DataInputStream(System.in);
			for(;;){
				String str=sin.readUTF();		//read the servers message into clinet 
				System.out.println(str);
				System.out.println("Enter data / quit");
				str=kin.readLine();
				sout.writeUTF(str);		//data entered from keyboard sent to server
				if(str.equals("quit"))
					break;
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}