package test;
import static org.junit.Assert.*;

import org.junit.Test;

import main.UI;


/*****************************************************************************-
class TestCheckID  
test case 1: ID 962001044 (正確 凌宗廷)
test case 2: ID 96z001044 (2打成z)
test case 3: ID 96200104 (漏最後4)
test case 4: ID 123456789 (錯誤ID)
test case 5: ID “”       (empty string)
**************************************************************************** */
public class TestCheckID {

	@Test
	public void testCheckID1() {
		UI aUI = new UI();
		String ID = "962001044";
		boolean expected_result = true;		
		boolean actual_result = aUI.checkID(ID);
		assertEquals (expected_result, actual_result);
	}
	@Test
	public void testCheckID2() {
		UI aUI = new UI();
		String ID = "96z001044";
		boolean expected_result = true;		
		boolean actual_result = aUI.checkID(ID);
		assertEquals (expected_result, actual_result);
	}
	@Test
	public void testCheckID3() {
		UI aUI = new UI();
		String ID = "96200104";
		boolean expected_result = true;		
		boolean actual_result = aUI.checkID(ID);
		assertEquals (expected_result, actual_result);
	}
	@Test
	public void testCheckID4() {
		UI aUI = new UI();
		String ID = "123456789";
		boolean expected_result = true;		
		boolean actual_result = aUI.checkID(ID);
		assertEquals (expected_result, actual_result);
	}
	@Test
	public void testCheckID5() {
		UI aUI = new UI();
		String ID = "";
		boolean expected_result = true;		
		boolean actual_result = aUI.checkID(ID);
		assertEquals (expected_result, actual_result);
	}

}
