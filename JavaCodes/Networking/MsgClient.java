import java.net.*;
import java.io.*;
class MsgClient{
	public static void main(String args[]){
		try{
			Socket cs=new Socket("localhost",1234);
			DataInputStream sin=new DataInputStream(cs.getInputStream());	
			DataOutputStream sout=new DataOutputStream(cs.getOutputStream());
			DataInputStream kin=new DataInputStream(System.in);
			String str;
			while(true){
				str=sin.readUTF();
				if(str.equals("q"))
					break;
				System.out.println("Server: "+str);
				System.out.print("Enter message/ q to quit: ");
				str=kin.readLine();
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