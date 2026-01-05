import java.io.*;
import java.util.*;
class FRead{
	public static void main(String args[]){
		Scanner s;
		String fn;
		FileInputStream fin;
		int ch;
		s=new Scanner(System.in);
		System.out.println("Enter the filename");
		fn=s.nextLine();
		try{
			fin=new FileInputStream(fn);
			while(true){
				ch=fin.read();	//here it gives ascii value that represent the character  
				if(ch==-1)		//end of file is -1
					break;
				System.out.print((char)ch);
			}
			fin.close();
		}
		catch(Exception e){
			System.out.println("Error: "+e);
		}
	}
}