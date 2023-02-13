package week3_Assignment;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListAssignment {
	
	public static Integer MaxArray(ArrayList<Integer> array)
	{
		if(array==null || array.size()==0)
		{
			return null;
		}
		else
		{
			int max=array.get(0);
			for(int i=1;i<array.size();i++)
			{
				if(array.get(i)>max)
				{
					max=array.get(i);
				}
			}
			return max;
		}
			
	}
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		ArrayList<Integer> array1=new ArrayList<>();
		System.out.println("Enter the number of elements :");
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter element "+(i+1)+" : ");
			int a=sc.nextInt();
			array1.add(a);
		}
		Integer max=MaxArray(array1);
		if(max==null)
		{
			System.out.println("Null");
		}
		else
		{
			System.out.println("The maximum element of the array is : "+max);
		}
	}

}

