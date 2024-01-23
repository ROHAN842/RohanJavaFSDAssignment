package threads;

public class MyThread extends Thread {
	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		
		//Below code is working in main thread
		t1.setPriority(MAX_PRIORITY);
		t1.setName("Child-1");
		System.out.println(t1);
		
		MyThread t2 = new MyThread();
		
		t2.setPriority(MIN_PRIORITY);
		t2.setName("Child-2");
		
		System.out.println(t2);
		
		
		MyThread t3 = new MyThread();
		
		t3.setPriority(NORM_PRIORITY);
		t3.setName("Child-3");
		
		System.out.println(t3);

		
		//Till above code is working inside Main thread
		
		//This below start method will internally call run method that is this method comes into play at run time
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("t1 thread is alive - "+t1.isAlive());
		System.out.println("t2 thread is alive - "+t2.isAlive());
		System.out.println("t3 thread is alive - "+t3.isAlive());
		
		
	}
	
	
		public void run() {
			
			for(int i=0; i<=5; i++)
			{
				System.out.println(Thread.currentThread().getName());
			}
		}
	

}
