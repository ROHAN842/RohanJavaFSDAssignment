package Inheritance;

public class Child extends Parent {
	
	int cid = 99;
	
	public Child()
	{
		super();
		System.out.println("Child object created........");
	}
	
	//toString method is the method present in 
	@Override
	public String toString()
	{
		return ("Class is present here..");
	}
	public Child(int cid)
	{
		this.cid = cid;
		System.out.println("Parameterised constructor for child class");
	}
	
	public void m2()

	{
		System.out.println("m2() called from Parent...");
	}
	
	public void m1()
	{
		System.out.println("m1() called from Parent..");
	}
	
	public static void main(String[] args) {
		Child c = new Child();
		System.out.println(c); 
		System.out.println(c.cid);
		c.m2();
		System.out.println(c.pid);
		c.m1();
		
		Child c2 = new Child(101);
		System.out.println(c2.cid);
		
		Parent p = new Parent();
		System.out.println(p);
		 
		
	}
}
