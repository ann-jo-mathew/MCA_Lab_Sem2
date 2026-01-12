class GM2V{
    public static < E > void printArray( E e,E a ) {
     	

     	System.out.println("a= "+e+" b= "+a);
      
    }

   public static void main(String args[]) {

      	Integer ai=10;
      	Integer bi=20;
	Float af=1.02f;
      	Float bf=3.66f;
	String s1="Hello";
	String s2="World";

      	System.out.println("Array integerArray contains:");
      	printArray(ai,bi);   

      	System.out.println("\nArray doubleArray contains:");
      	printArray(af,bf);  

     	System.out.println("\nArray characterArray contains:");
      	printArray(s1,s2);   
   }
}
