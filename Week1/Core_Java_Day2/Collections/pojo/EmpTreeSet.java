package pojo;

import java.util.HashSet;
import java.util.Set;

import pojo1.Student;

public class EmpTreeSet {
	public static void main(String[] args) {
		Set<Employee> set = new HashSet<Employee>();
		set.add(new Employee(101,"king",8000));
		set.add(new Employee(101,"tom",9000));
		//System.out.println(set);
		for (Employee i:set)
		{
			System.out.println(i);
		}
	}

}
