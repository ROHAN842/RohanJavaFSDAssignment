package basics;
import java.lang.Object;

public class Student {
	
	static	int sid;              // 0
	 static	String sname;        // null
	
	public static void hello()
	{
		System.out.println("Hello");
	}
	
	public Student()
	{
		super();
	}
	
	public int getSid()
	{
		hello();
		return sid;
	}
//	int sid;
//	String sname;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int amount = 0;

		Student s1 = new Student();
		s1.sid = 99;
		s1.sname = "king";
		System.out.println(s1.sid);
		System.out.println(s1.sname);
		System.out.println(s1);
		
		
		s1.getSid();
		hello();
		
		Student s2 = new Student();
		System.out.println(s2.sid);
		System.out.println(s2.sname);
	}

}
