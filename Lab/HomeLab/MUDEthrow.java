class UDE extends Exception{
	String strError;
	public UDE(){
		strError="Unknown Error";
	}
	public UDE(String s){
		strError=s;
	}
	public String showError(){
		return strError;
	}	
}
class MUDEthrow{
	public static void main(String args[]){
		int a=5,b=0,c;
		try{
			if(b==0)
				throw new UDE("Dr is ZERO");	//object created with argument so constructor with argument is invoked
			//Dinominator
			c=a/b;
			System.out.println(c);
		}
		catch(UDE e){
			System.out.println(e.showError());	//Printd the exception
		}
	}
}