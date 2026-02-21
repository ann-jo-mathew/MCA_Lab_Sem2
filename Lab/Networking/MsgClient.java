import java.net.*;
import java.io.*;
class MsgClient{
	public static void main(String args[]){
		try{
			Socket ss=new Socket("localhost",1234);
			DataInputStream sin=new DataInputStream(cs.getInputStream());	
			DataOutputStream sout=new DataOutputStream(cs.getOutputStream());
			DataOutputStream kin=new DataInputStream(System.in);
		