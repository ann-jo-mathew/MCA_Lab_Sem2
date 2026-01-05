import java.io.*;
class FCopy{
	public static void main(String args[]){
		String fn1,fn2;
		FileInputStream fin;
		FileOutputStream fout;
		int ch;
		fn1=args[1];
		fn2=args[2];
		char c;
		try{
			fin=new FileInputStream(fn1);
			fout=new FileOutputStream(fn2);
			while(true){
				ch=fin.read();	//here it gives ascii value that represent the character  
				if(ch==-1)		//end of file is -1
					break;
				c=(char)ch;
				fout.write(c);
			}
			fin.close();
			System.out.println("File copied successfully");
		}
		catch(Exception e){
			System.out.println("Error: "+e);
		}
	}
}