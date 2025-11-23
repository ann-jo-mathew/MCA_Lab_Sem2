import java.io.*;

class Bitwise{
    public static void main(String args[]) {
	DataInputStream d=new DataInputStream(System.in);
	try{
		System.out.println("Enter the numbers:");
		int a=Integer.parseInt(d.readLine());
		int b=Integer.parseInt(d.readLine());    
        	System.out.println("a = "+a+", b = "+b);
        	//AND
       	 	System.out.println("a & b = "+(a&b));
        	//OR
        	System.out.println("a | b = "+(a|b));
        	//XOR
        	System.out.println("a ^ b = "+(a^b));
        	//NOT
        	System.out.println("~a = "+(~a));
        	//Left Shift
        	System.out.println("a << = "+(a<<1));
        	//Right Shift
        	System.out.println("a >> = "+(a>>1));
	}
	catch(Exception e){
		System.out.println("Error: "+e);
	}

    }
}
