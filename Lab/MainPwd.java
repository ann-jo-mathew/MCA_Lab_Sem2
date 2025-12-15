import java.util.*;
class PwdCheck extends Exception{
	String strError;
	public PwdCheck(){
		System.out.println("Unknown Error");
	}
	public PwdCheck(String s){
		strError=s;		
	}
	public String showError(){
		return strError;
	}
		
}
class MainPwd{
	public static void main(String args[]){
		String p;
		int lcount=0,ucount=0;
		Scanner sc=new Scanner(System.in);
		System.out.print("Password: ");
		try{
			p=sc.nextLine();
			if(p.length()<8){
				throw new PwdCheck("Length must be atleast 8");
			}
			char a[]=new char[p.length()];
			char la[]=new char[p.length()];
			la=la.toLowerCase();
			char ua[]=new char[p.length()];
			ua=ua.toUpperCase();

			for(int i=1;i<=p.length();i++){
				if(a[i]==a[i+1])
					throw new PwdCheck("Cannot have any concecutive repetition ");
				if(a[i]==la[i])
					lcount++;
				if(a[i]==ua[i])
					ucount++;
			}
			if(lcount==0)
				throw new PwdCheck("Password must have at least 1 lowercase character");
			if(ucount==0)
				throw new PwdCheck("Password must have at least 1 uppercase character ");
			
		}
		catch(PwdCheck e){
			System.out.println(e.showError());
		}

	}
}