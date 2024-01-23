package list;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class ListDemo {

	public static void main(String[] args) {
		List<Number> list = new ArrayList<Number>();
		list.add(30);
		list.add(10);
		list.add(20);
		list.add(40);
		list.add(20);
		list.add(null);
		list.add(5665.23f);
		list.add(456.2);
		list.add(15454542424542L);
		System.out.println(list);
		
		List<Number> list1 = new LinkedList<Number>();
		list1.add(30);
		list1.add(10);
		list1.add(20);
		list1.add(40);
		list1.add(20);
		list1.add(null);
		list1.add(5665.23f);
		list1.add(456.2);
		list1.add(15454542424542L);
		System.out.println(list1);
		
		// First way to print collection elements
		Iterator it = list.iterator();
		
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
		System.out.println("For Each loop");
		
		// Another way to print collection elements 	
		for(Number n:list)
		{
			System.out.println(n);
		}
	}
}
