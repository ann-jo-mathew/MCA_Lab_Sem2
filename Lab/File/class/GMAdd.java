class GMAdd{
	public static <E> E add(E e1, E e2){
		E t=null;
		if(e1 instanceof Integer){
			Integer a,b;
			a=(Integer)e1;
			b=(Integer)e2;
			t=(E)new Integer(a.intValue()+b.intValue());
			System.out.println(t);
		}
		else if(e1 instanceof String){
			String a,b;
			a=(String)e1;
			b=(String)e2;
			t=(E)new String(a+b);
			System.out.println(t);
		}
		else if(e1 instanceof Float){
			Float a,b;
			a=(Float)e1;
			b=(Float)e2;
			t=(E)new Float(a.floatValue()+b.floatValue());
			System.out.println(t);
		}
		return t;
	}
	public static void main(String args[]) {

      		Integer ai=10;
      		Integer bi=20;
		Float af=1.02f;
      		Float bf=3.66f;
		String s1="Hello";
		String s2="World";

      		System.out.println("Integer");
		System.out.println(add(ai,bi));   

      		System.out.println("\nArray doubleArray contains:");
		System.out.println(add(af,bf));   

     		System.out.println("\nArray characterArray contains:");
		System.out.println(add(s1,s2));   
   	}
}
