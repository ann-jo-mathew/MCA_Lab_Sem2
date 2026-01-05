import java.io.*;		//fileo/pstream
import java.util.*;
class FWrite{
	public static void main(String args[]){
		FileOutputStream fout;
		Scanner s;
		s=new Scanner(System.in);
		try{
			System.out.println("Enter the file name");
			String fn=s.nextLine();
			fout=new FileOutputStream(fn);
			while(true){
				System.out.println("Enter data/quit");
				String data=s.nextLine();
				if(data.equals("quit"))
					break;
				fout.write(data.getBytes()); //for converting string to ByteArray
				fout.write("\n".getBytes());	//for writing content in next line when enter is pressed
			}
			fout.close();
		}
		catch(Exception e){
			System.out.println("Error: "+e);
		}
	}
}

//File Handling created f1.txt