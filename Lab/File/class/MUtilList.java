import java.util.*;

class MUtilList
{
	public static void main(String args[])
	{
		List l;
		l = new ArrayList();
		
		l.add(new Integer(10));
		l.add(new Integer(20));
		l.add(new Integer(30));
		
		for(Iterator c = l.iterator();c.hasNext();)
		{
			System.out.println(c.next());
		}
	}
}