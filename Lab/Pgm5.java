import java.util.*;
class ArrayPass{  	
	void printArray(int arr[]) { 		//Passing array as a parameter
		System.out.println("Array elements:");
 		for (int x : arr) {
 			System.out.print(x + " ");
       		}
	System.out.println();
	}
	int[] createArray() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter size: ");
		int n = sc.nextInt();
		int a[] = new int[n];
		System.out.println("Enter elements:");
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		return a;
	}
}
class ArrayConstructor {		//Passing array to constructor
	int arr[];
	ArrayConstructor(int a[]) {
		arr = a;
	}
	void show() {
		System.out.println("Array from constructor:");
		for (int x : arr) {
		System.out.print(x + " ");
		}
	}
}
public class Pgm5{
	public static void main(String[] args) {
	ArrayPass obj = new ArrayPass();
	int data[] = obj.createArray();
	obj.printArray(data);
	ArrayConstructor ac = new ArrayConstructor(data);
	ac.show();
	}
}
