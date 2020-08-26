package testNG_Practise;

import org.testng.annotations.Test;

public class TestNG_Sequence {
	
	@Test(priority=0)
	public void test_0(){
		System.out.println("Test 0");
	}
	
	@Test(priority=2)
	public void test2(){
		System.out.println("Test 2");
	}

	@Test(priority=1)
	public void test1(){
		System.out.println("Test 1");
	}
	
	@Test
	public void A_test(){
		System.out.println("A Test Without Priority");
	}
	
	@Test
	public void A(){
		System.out.println("A Without Priority");
	}
	
	@Test(priority =-1)
	public void A_test_Minus(){
		System.out.println("A Test Priority_Minus_one");
	}
	
	@Test(priority =-3)
	public void A_test_Minus_three(){
		System.out.println("A Test Priority_Minus_Three");
	}
	
}
