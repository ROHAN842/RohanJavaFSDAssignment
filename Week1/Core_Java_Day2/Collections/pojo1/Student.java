package pojo1;

import java.util.Iterator;
import java.util.Objects;

public class Student {
	private int sid;
	private String sname;
	
	public Student()
	{
		super();
	}
	
	public Student(int sid, String sname)
	{
		this.sid = sid;
		this.sname = sname;
	}

	//ToString method generated
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + "]";
	}
	
	// Getters and Setters 

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}
	
	// HashCode method

	@Override
	public int hashCode() {
		return Objects.hash(sid, sname);
	}
	
	// Equals Method

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return sid == other.sid && Objects.equals(sname, other.sname);
	}
	
	public static void main(String[] args) {
		Student s1 = new Student(25,"Rohan");
		System.out.println(s1);
		s1.setSid(45);
		System.out.println(s1.getSid());
		s1.setSname("Ankit");
		System.out.println(s1.getSname());
	}

	
	
	

}
