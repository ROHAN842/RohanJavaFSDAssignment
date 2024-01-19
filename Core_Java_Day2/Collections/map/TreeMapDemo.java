package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import pojo.Employee;
import set.MyComparator;

public class TreeMapDemo {
	public static void main(String[] args) {
		Map<Integer,String> map = new TreeMap<Integer,String>();
		map.put(103,"ravi");
		map.put(102,"tom");
		map.put(101,"sai");
		map.put(104,"smith");
		map.put(103,"john");
		map.put(105,"Sibi");

		System.out.println(map);
		//Ascending order here we will get 
		
		Map<Employee,String> map2 = new TreeMap<>(new MyComparator());
		map2.put(new Employee(105,"Ravi",8000.32), "Hyderabad");
		map2.put(new Employee(106,"Rajesh",9000),"Pune");
		map2.put(new Employee(107,"Mayank",10000),"Mumbai");
		map2.put(new Employee(109,"Kavita",12000),"Delhi");
		System.out.println(map2);
	}

}
