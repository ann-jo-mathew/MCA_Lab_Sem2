import java.net.*;
import java.io.*;
class OClient extends Thread{
	DataInputStream sin;
	DataOutputStream sout;
	String str;
	public OClient(Socket cs){
		try{
			sin=new DataInputStream(cs.getInputStream());
			sout=new DataOutputStream(cs.getOutputStream());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void run(){
		try{
				sout.writeUTF("**Welcome to the CHAT**");
				while(true){
					str=sin.readUTF();
					System.out.println("Client: "+str);
					sout.writeUTF(str);
					if(str.equals("q"))
						break;
				}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
class MultiServer{
	public static void main(String args[]){
		try{
			ServerSocket ss=new ServerSocket(1234);
			while(true){
				System.out.println("Waiting for a client...");
				Socket cs=ss.accept();
				System.out.println("Client Connected");
				OClient obj=new OClient(cs);
				obj.start();
			}
		}
		catch(Exception e){
		 e.printStackTrace();
		}
	}
}
		