import java.net.*;
import java.io.*;
class CtoCServer{
	public static void main(String args[]){
		try{
            Socket cs1=null,cs2=null;
            ServerSocket ss=new ServerSocket(1234);
			System.out.println("Waiting for a client 1...");
            cs1=ss.accept();
            System.out.println("Waiting for a client 2...");
            cs2=ss.accept();
            System.out.println("CLient 1 and Client 2 connected...");
            DataInputStream sin1=new DataInputStream(cs1.getInputStream());	
			DataOutputStream sout1=new DataOutputStream(cs1.getOutputStream());
            DataInputStream sin2=new DataInputStream(cs2.getInputStream());	
			DataOutputStream sout2=new DataOutputStream(cs2.getOutputStream());
            String str;
			while(true){
				str=sin1.readUTF();//from client 1 we have to give it to client 2
                sout2.writeUTF(str);
                System.out.println("Client 1 send a msg");
				if(str.equals("q"))
					break;
                
				str=sin2.readUTF();
                sout1.writeUTF(str);
                System.out.println("Client 2 send a msg");
				if(str.equals("q"))
					break;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}