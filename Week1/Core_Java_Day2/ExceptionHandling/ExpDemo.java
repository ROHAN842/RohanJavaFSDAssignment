package exceptions;

public class ExpDemo {

	public static void main(String[] args) { //caller
		System.out.println("Open File");
		System.out.println("Read Data from File");
		int result = 0;
		try {
			String name = null;
			System.out.println(name.length());
		 result = div(10,0);
		}
		catch(ArithmeticException e)
		{
			System.out.println("Sorry! You can't divide number by zero");
		}	
		catch(NullPointerException e)
		{
			e.printStackTrace();
		}
		finally
		{
		System.out.println("Close File");
		}
		System.out.println("Result is as : "+result);

	}
	
	public static int div(int a, int b) throws ArithmeticException //callee
	{
		return a/b;
	}
}
