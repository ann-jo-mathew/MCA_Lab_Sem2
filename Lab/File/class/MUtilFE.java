import java.util.*;
import java.io.*;

class MUtilFE
{
	public static void main(String args[])
	{
		List list = new ArrayList();
		Integer I = new Integer(12);
		String str = "Test";
		Float f = new Float(123.5F);
		list.add(I);
		list.add(str);
		list.add(f);
		
		Integer IR;
		String SR;
		Float FR;

		Iterator i = list.iterator();	//iterate over a collection
		while (i.hasNext())
  		{
    			Object obj = i.next();		//Object class that points to any type of obejct
			if(obj instanceof Integer)
			{
				IR = (Integer)obj;
				System.out.println(IR.intValue());		//Integer variable to int
			}
			else if(obj instanceof String)
			{
				SR = (String)obj;
				System.out.println(SR);
			}
			else if(obj instanceof Float)	//instanceof used to identify the actual object to which ot points to
			{
				FR = (Float)obj;
				System.out.println(FR.floatValue());
			}
  		}
	}
}