package pojo1;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Iterator;

public class StuHashSet {

	public static void main(String[] args) {
		Set<Student> set = new HashSet<Student>();
		set.add(new Student(12,"Rajesh"));
		set.add(new Student(32,"Mohit"));
		//System.out.println(set);
		for (Student i:set)
		{
			System.out.println(i);
		}
		
		System.out.println("Example of Tree set");
		Set<Student> set1 = new TreeSet<Student>();
		set1.add(new Student(23,"Ajay"));
		set1.add(new Student(58,"Rohit"));
		//System.out.println(set);
		for (Student i:set1)
		{
			System.out.println(i);
		}
		
	}
}
