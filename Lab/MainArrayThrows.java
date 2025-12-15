import java.io.*;
class Array{
	int a[],n;
	public void readSize() throws IOException, NumberFormatException{
		DataInputStream din=new DataInputStream(System.in);
		System.out.println("Enter n");
		String s= din.readLine();
		n=Integer.parseInt(s);
	}
	
	public void readArrayElements() throws IOException, NumberFormatException,ArrayIndexOutOfBoundsException{
		DataInputStream din=new DataInputStream(System.in);
		readSize();		//no need toreturn since n can be accesed inside the array
		a=new int[n];
		for(int i=0;i<n;i++){
			System.out.println("Enter a["+i+"]");
			String s=din.readLine();
			a[i]=Integer.parseInt(s);
		}
	}

	public void dispArray() throws ArrayIndexOutOfBoundsException{
		for(int i=0;i<n;i++)
			System.out.println(a[i]);
	}
}
	
class MainArrayThrows{
	public static void main(String args[]){
		try{
			Array obj=new Array();
			obj.readArrayElements();
			obj.dispArray();
		}
		catch(IOException e1){
			System.out.println("Error IO: "+e1);
		}
		catch(NumberFormatException e2){
			System.out.println("Error NFE: "+e2);
		}
		catch(ArrayIndexOutOfBoundsException e3){
			System.out.println("Error AIOBE: "+e3);
		}
		catch(Exception e4){
			System.out.println("Error "+e4);
		}

	}
}