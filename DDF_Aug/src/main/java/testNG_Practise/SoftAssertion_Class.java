package testNG_Practise;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion_Class {
	SoftAssert soft;
	@Test
	public void test4(){
		System.out.println("Test 4");
	}

	@Test
	public void test2(){
		soft = new SoftAssert();
		soft.assertEquals("XXXX", "XXX1");
		System.out.println("Test 2");
		soft.assertAll();
	}

	@Test
	public void test3(){
		System.out.println("Test 3");
	}
	
	@Test
	public void test1(){
		//Assert.assertEquals("A", "B");
		soft = new SoftAssert();
		soft.assertEquals("A", "B");
		System.out.println("Test 1");
		soft.assertAll();
	}
	
	
	
}	

