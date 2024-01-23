package set;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import pojo.Employee;

public class TreeDemo {

	public static void main(String[] args) {
		Set<String> set = new TreeSet<String>();
		set.add("B");
		set.add("D");
		set.add("C");
		set.add("A");

		System.out.println(set);
	// Here for this case output is getting in ascending order as per ASCII value for A,B,C,D
		
		Set<Integer> set2 = new TreeSet<Integer>();
		set2.add(34);
		set2.add(12);
		set2.add(56);
		set2.add(9);
		System.out.println("Sorted " + set2);
		
		
		Set<Employee> set3 = new TreeSet<>(new MyComparator());
		set3.add(new Employee(105, "Ravi", 8000.32));
		set3.add(new Employee(106, "Rajesh", 9000));
		set3.add(new Employee(107, "Mayank", 10000));
		set3.add(new Employee(109, "Kavita", 12000));

		System.out.println(set3);

	}
}
