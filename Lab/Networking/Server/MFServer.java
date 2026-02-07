//Multiple clients file upload download server

import java.io.*;
import java.net.*;
class OneClient extends Thread{
	Socket as;
	DataInputStream sin;
	DataOutputStream sout;
	public OneClient(Socket s) throws Exception{
		as=s;	\\
		sin=new DataInputStream(as.getInputStream());
		sout=new DataOutputStream(as.getOutputStream());
	}
	public void run(){
		try{
			String str="welcome";
			for(;;){
				sout.writeUTF("From Server:"+str);	//writeUTF sends welcome mesage in clinet side
				str=sin.readUTF();		//reads from clients side msg
				if(str.equals("quit"))
					break;
				System.out.println("From CLient:"+str);
			}		
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
class MFServer{
	public static void main(String args[]){
		ServerSocket ss;
		try{
			ss=new ServerSocket(1234);	//listening socket
			for(;;){
				System.out.println("Server Waiting..");
				Socket as=ss.accept();		//obj  declared, server accepts the clients socket and builds connection
								//as is the client socket
				System.out.println("Client Connected");
				OneClient obj=new OneClient(as);	//obj declared and a socket as is passed for each client
				obj.start();		//thread satrted for a client
			}
		}
		catch(Exception e){
			System.out.println("Error "+e);
		}
	}
}
		