package set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetDemo {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("king");
		set.add("smith");
		set.add("adam");
		set.add("ford");
		System.out.println(set);
		
		Set<Integer> set2 = new HashSet<Integer>();
		set2.add(34);
		set2.add(12);
		set2.add(56);
		set2.add(9);
		System.out.println(set2);
		
		//Upon running above both cases for HashSet we are getting the output in any random order because it is printing the order
		// as per order of HashCode which is not visible but the order is based as per HashCode only for it 
		
		Set<String> set3 = new LinkedHashSet<String>();
		set3.add("king");
		set3.add("smith");
		set3.add("adam");
		set3.add("ford");
		System.out.println(set3);
		
		for (String i:set3)
		{
			System.out.println(i);
		}
	}

}
