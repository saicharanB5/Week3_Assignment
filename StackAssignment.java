package week3_Assignment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StackAssignment {

	public static void main(String[] args) {
		
		ArrayList<String> A1=new ArrayList<>();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of items to be inserted : ");
		int a=sc.nextInt();
		System.out.println("Enter the Data:");
		for(int i=0;i<a;i++) {
			String s=sc.next();
			A1.add(s);
			
		}
		Collections.sort(A1);
		Collections.reverse (A1);
		System.out.println(A1);

	}

}
