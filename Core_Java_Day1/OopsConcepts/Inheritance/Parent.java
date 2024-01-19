package Inheritance;

public class Parent extends Object {
	
	int pid = 100;
	
	public Parent()
	{  //super refer to immediate parent class object
	// super() refers to immediate parent class constructor object
		super();
		System.out.println("Parent object is created...");
	}
	@Override
	public String toString()
	{
		return ("Class is present here..");
	}
	public void m1()
	{
		System.out.println("m1() called from Parent..");
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
