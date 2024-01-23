package threads;

import java.util.Iterator;

public class ThreadDemo extends Thread {
	public static void main(String[] args) {
		System.out.println("Welcome");
		Thread t1 = new ThreadDemo();
		System.out.println(t1);
		
		t1.start();
		
		for(int i=0; i<=5; i++)
		{
			 System.out.println("Main Thread");
			 try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}

	@Override
	public void run() {
		//System.out.println("Run() method is called......");
		for(int i=0; i<=5; i++)
		{
			 System.out.println("Child Thread");
			 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
