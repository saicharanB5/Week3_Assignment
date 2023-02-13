package week3_Assignment;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
public class Hash_set2 {

	public static void main(String[] args) {
		
		Set<String> students=new HashSet<>();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of students");
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter Student "+(i+1)+" name : ");
			String name=sc.next();
			students.add(name);
		}
		
		Set<String> studentsSorted=new TreeSet<>(students);
		System.out.println("Students names after sorting and removing duplicates are : "+studentsSorted);
		System.out.println("Total number of students are : "+studentsSorted.size());
		
	}

}

