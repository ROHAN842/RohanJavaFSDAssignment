package test;

import org.junit.Test;
import org.junit.jupiter.api.Tag;

public class ClassTestA {
	@Test
	@Tag("development")
	@Tag("production")
	
	public void testA(){
		System.out.println("TestA() called.......");
		
		
	}

}
