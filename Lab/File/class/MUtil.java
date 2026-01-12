import java.util.*;
import java.io.*;

class MUtil
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
		System.out.println(list);
	}
}