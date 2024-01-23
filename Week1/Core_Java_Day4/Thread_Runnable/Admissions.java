package synchronize;

public class Admissions implements Runnable {
	
	int seat = 1;
	
	public static void main(String[] args) {
		
		Runnable admission = new Admissions();
		
		Thread t1 = new Thread(admission,"Mohit");
		Thread t2 = new Thread(admission,"Rohan");
		
		t1.start();
		t2.start();
	
		
	}
	
	@Override
	public void run() {

		System.out.println("Number of seats before :"+seat);
		
		synchronized(this) {
		
		if(seat>0)
		{
			System.out.println("Seat allocated to "+Thread.currentThread().getName());
			seat = seat - 1;
		}
		else {
			System.out.println("Sorry try next year.");
		}
		}

		
		System.out.println("Number of seats left after "+seat);
	}
	

}
