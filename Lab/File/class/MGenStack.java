import java.util.*;
import java.io.*;

class GenStack <T>
{
	ArrayList <T> stack = new ArrayList<T>();	//T given
	int top = -1;

	public void push(T d)
	{
		stack.add(d);
		top++;
	}
	public void pop()
	{
		if(top == -1)
		{
			System.out.println("Empty..");
		}
		else
		{
			System.out.println(stack.remove(top--));
		}
	}
}

class MGenStack
{
	public static void main(String args[])
	{
		GenStack <Integer> is = new GenStack<Integer>();
		GenStack <String> ss = new GenStack<String>();
		is.push(12);
		is.push(30);

		ss.push("Test");
		ss.push("two");

		ss.pop();
		ss.pop();

		is.pop();
		is.pop();		
	}
}

//stack calss used for int as well as String