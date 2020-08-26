package testNG_Practise;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Annotation_Sequence {
	
	@BeforeTest
	public void beforeTest(){
		System.out.println("beforeTest Annotation");
	}
	
	@BeforeClass
	public void beforeClass(){
		System.out.println("beforeClass Annotation");
	}
	
	@BeforeMethod
	public void beforeMethod(){
		System.out.println("before Method Annotation");
	}
	
	@Test
	public void test1(){
		System.out.println(" Test 1 Annotation");
	}
	
	@Test
	public void test2(){
		System.out.println(" Test 2 Annotation");
	}
	
	@AfterTest
	public void afterTest(){
		System.out.println("afterTest Annotation");
	}

	@AfterClass
	public void afterClass(){
		System.out.println("after Class Annotation");
	}
	
	@AfterMethod
	public void afterMethod(){
		System.out.println("afterMethod Annotation");
	}
	
	@BeforeSuite
	public void beforeSuite(){
		System.out.println("beforeSuite Annotation");
	}
	
	@AfterSuite
	public void afterSuite(){
		System.out.println("afterSuite Annotation");
	}
}
