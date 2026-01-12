import java.util.*;
import java.io.*;

class GenStackI <T>
{
	ArrayList <T> stack = new ArrayList<T>();
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

class MGenStackInteger
{
	public static void main(String args[])
	{
		GenStackI <Integer> is = new GenStackI<Integer>();
		is.push(12);
		is.push(30);

		is.pop();
		is.pop();		
	}
}

//Integer Stack