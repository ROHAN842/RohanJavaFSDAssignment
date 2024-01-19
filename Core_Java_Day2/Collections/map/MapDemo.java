package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapDemo {
	public static void main(String[] args) {
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(103,"ravi");
		map.put(102,"tom");
		map.put(101,"sai");
		map.put(104,"smith");
		map.put(103,"john");
		map.put(105,"Sibi");

		System.out.println(map);
		
		Set<Integer> set = map.keySet();
		Iterator<Integer> it = set.iterator();
		while(it.hasNext())
		{
			Integer k = (Integer) it.next();
			System.out.println(k + " " + map.get(k));
		}
		Collection<String> list = map.values();
		for(String name:list)
		{
			System.out.println(name);
		}
		}
}
