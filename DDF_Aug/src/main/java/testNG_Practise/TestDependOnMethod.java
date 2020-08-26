package testNG_Practise;

import org.testng.SkipException;
import org.testng.annotations.Test;

import net.bytebuddy.implementation.bytecode.Throw;

public class TestDependOnMethod {
	
	@Test
	public void test1(){
		System.out.println("Test 1");
	}
	
	@Test(dependsOnMethods="A")
	public void A_test(){
		System.out.println("A Test Without Priority");
	}
	
	@Test(dependsOnMethods="A_test_Minus")
	public void A(){
		System.out.println("A Without Priority");
	}
	
	@Test(priority =-1, dependsOnMethods="test1")
	public void A_test_Minus(){
		System.out.println("A Test Priority_Minus_one");
	}
	// ------------- Sequence ------------
	
	@Test(dependsOnMethods="c")
	public void a(){
		System.out.println("AAAAAAAAAAAAAAAAAAA");
	}

	@Test
	public void b(){
		System.out.println("BBBBBBBBBBBBBBBBBBB");
	}
	
	@Test
	public void c(){
		System.out.println("CCCCCCCCCCCCCCCCCCC");
	}
	
}
