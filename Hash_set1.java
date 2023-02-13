package week3_Assignment;

import java.util.HashSet;
import java.util.Set;

public class Hash_set1 {

	public static void main(String[] args) {
			
		Set<String> Stack1=new HashSet<>();
		Set<String> Stack2=new HashSet<>();
		
		Stack1.add("Chemistry");
		Stack1.add("Mathematics");
		Stack1.add("Biology");
		Stack1.add("English");
		
		Stack2.add("Biology");
		Stack2.add("English");
		Stack2.add("Geography");
		Stack2.add("Physics");
		
		Set<String> Stack1Dup=new HashSet<>(Stack1);
		Set<String> Stack2Dup=new HashSet<>(Stack2);
		
		Stack1Dup.removeAll(Stack2);
		Stack2Dup.removeAll(Stack1);
		
		System.out.println("The subjects that are in Stack1 only are : "+Stack1Dup);
		System.out.println("The subjects that are in Stack1 only are : "+Stack2Dup);
		
		

	}

}

