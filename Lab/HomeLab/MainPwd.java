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
		int lcount=0,ucount=0,spcount=0;
		Scanner sc=new Scanner(System.in);
		System.out.print("Password: ");
		try{
			p=sc.nextLine();
			if(p.length()<8){
				throw new PwdCheck("Length must be atleast 8");
			}
			String l=p.toLowerCase();
			String u=p.toUpperCase();

			for(int i=0;i<p.length()-1;i++){
				if(p.charAt(i)==p.charAt(i+1))
					throw new PwdCheck("Cannot have any concecutive repetition ");
			}
			for(int i=0;i<p.length();i++){
				if(p.charAt(i)==l.charAt(i))
					lcount++;
				if(p.charAt(i)==u.charAt(i))
					ucount++;
				if((p.charAt(i)>='a'&&p.charAt(i)<='z')||(p.charAt(i)>='A'&&p.charAt(i)<='Z')||(p.charAt(i)>='0'&&p.charAt(i)<='9')){
				}
				else if(p.charAt(i)=='@'||p.charAt(i)=='*'||p.charAt(i)=='!'||p.charAt(i)=='{'||p.charAt(i)=='}'||p.charAt(i)=='('||p.charAt(i)==')'||p.charAt(i)=='['||p.charAt(i)==']'||p.charAt(i)=='&'||p.charAt(i)=='=')
					spcount++;
				else
					throw new PwdCheck("Password can only have alphanumeric characters and special characters @,*,!,{,},(,),[,],& and = ");
			}
			if(lcount==0)
				throw new PwdCheck("Password must have at least 1 lowercase character");
			if(ucount==0)
				throw new PwdCheck("Password must have at least 1 uppercase character ");
			if(spcount==0)
				throw new PwdCheck("Password must have at least 1 special case character ");
			
		}
		catch(PwdCheck e){
			System.out.println(e.showError());
		}

	}
}