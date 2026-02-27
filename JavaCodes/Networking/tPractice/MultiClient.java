import java.net.*;
import java.io.*;
class MultiClient{
	public static void main(String args[]){
		try{
			Socket cs=new Socket("localhost",1234);
			DataInputStream sin=new DataInputStream(cs.getInputStream());	
			DataOutputStream sout=new DataOutputStream(cs.getOutputStream());
			DataInputStream kin=new DataInputStream(System.in);
			String str;
            str=sin.readUTF();
            System.out.println("Server: "+str);
			while(true){
				
				System.out.print("Me: ");
				str=kin.readLine();
				sout.writeUTF(str);
				if(str.equals("q"))
					break;

				str=sin.readUTF();
				if(str.equals("q"))
					break;
				System.out.println("Client 2: "+str);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}