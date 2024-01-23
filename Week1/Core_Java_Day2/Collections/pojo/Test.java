package pojo;
public class Test {

	public static void main(String[] args) {
		Employee emp = new Employee(101,"King",454672.2);
		Employee emp2 = new Employee();
		emp2.setEid(102);
		System.out.println(emp);
		System.out.println(emp.getEid());
		System.out.println(emp2);
		System.out.println(emp2.getEid());
	}
}
