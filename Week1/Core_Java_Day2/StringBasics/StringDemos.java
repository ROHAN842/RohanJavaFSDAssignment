package com.hexaware;

public class StringDemos {
	public static void main(String[] args) {
		StringDemos d1 = new StringDemos();
		StringDemos d2 = new StringDemos();
		StringDemos d3 = new StringDemos();
		StringDemos d4 = d3;
		System.out.println(d1.equals(d2)); //false
		System.out.println(d3.equals(d4)); //true

		String str1 = new String("Hello");
		String str2 = new String("Hello");
		System.out.println("Values:"+str1.equals(str2)); //true
		System.out.println("Hashcode ");
		System.out.println(str1==str2);
	
		String str3 = "rohan";
		String str4 = "rohan";
		System.out.println("Values SCP:"+str3.equals(str4));
		System.out.println("Hashcode ");
		System.out.println(str3==str4); // it compare references or hashcode 
	}

}
