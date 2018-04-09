import static org.junit.Assert.*;

import org.junit.Test;

/*****************************************************************************-
class TestCheckID  
test case 1: ID 962001044 (正確 凌宗廷)
test case 2: ID 96z001044 (2打成z)
test case 3: ID 96200104 (漏最後4)
test case 4: ID 123456789 (錯誤ID)
test case 5: ID “”       (empty string)
**************************************************************************** */
public class TestContainsID {

	@Test
	public void testContainsID1() {
		GradeSystem aGradeSystem = new GradeSystem();
		String ID = "962001044";
		boolean expected_result = true;		
		boolean actual_result = aGradeSystem.containsID(ID);
		assertEquals (expected_result, actual_result);
	}
	@Test
	public void testContainsID2() {
		GradeSystem aGradeSystem = new GradeSystem();
		String ID = "96z001044";
		boolean expected_result = true;		
		boolean actual_result = aGradeSystem.containsID(ID);
		assertEquals (expected_result, actual_result);
	}
	@Test
	public void testContainsID3() {
		GradeSystem aGradeSystem = new GradeSystem();
		String ID = "96200104";
		boolean expected_result = true;		
		boolean actual_result = aGradeSystem.containsID(ID);
		assertEquals (expected_result, actual_result);
	}
	@Test
	public void testContainsID4() {
		GradeSystem aGradeSystem = new GradeSystem();
		String ID = "123456789";
		boolean expected_result = true;		
		boolean actual_result = aGradeSystem.containsID(ID);
		assertEquals (expected_result, actual_result);
	}
	@Test
	public void testContainsID5() {
		GradeSystem aGradeSystem = new GradeSystem();
		String ID = "";
		boolean expected_result = true;		
		boolean actual_result = aGradeSystem.containsID(ID);
		assertEquals (expected_result, actual_result);
	}

}
