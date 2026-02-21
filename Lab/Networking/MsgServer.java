import java.net.*;
import java.io.*;
class MsgServer{
	public static void main(String args[]){
		try{
			ServerSocket ss=new ServerSocket(1234);
			System.out.println("Waiting for a client...");
			Socket cs=ss.accept();
			DataInputStream sin=new DataInputStream(cs.getInputStream());	
			DataOutputStream sout=new DataOutputStream(cs.getOutputStream());
			DataOutputStream kin=new DataInputStream(System.in);
			String str;
			while(true){
				System.out.print("*Enter Message/type q to quit: ");
				str=kin.readLine();
				sout.writeUTF(str);
				if(str.equals()=="q")
					break;
				str=sin.readUTF();
				System.out.println("Client: "+str);
				if(str.equals()=="q")
					break;
				}
		}
		catch(Exception e){
		 e.printStackTrace();
		}
	}
}
		