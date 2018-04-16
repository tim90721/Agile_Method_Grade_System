package test;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.GradeSystem;

/*****************************************************************************-
class TestContainsID  
test case 1: ID 962001044 (���T ��v��)
test case 2: ID 96z001044 (2����z)
test case 3: ID 96200104 (�|�̫�4)
test case 4: ID 123456789 (���~ID)
test case 5: ID ����       (empty string)
**************************************************************************** */

class TestContainsID {

	private GradeSystem gradeSystem;
	
	@Before
	public void setUp() {
		gradeSystem = new GradeSystem();
	}
	
	@After
	public void tearDown() {
		gradeSystem = null;
	}
	
	@Test
	public void testContainsID1() {
		assertEquals(true, gradeSystem.containsID("962001044"));
	}
	
	@Test
	public void testContainsID2() {
		assertEquals(false, gradeSystem.containsID("96z001044"));
	}
	
	@Test
	public void testContainsID3() {
		assertEquals(false, gradeSystem.containsID("96200104"));
	}
	
	@Test
	public void testContainsID4() {
		assertEquals(false, gradeSystem.containsID("123456789"));
	}
	
	@Test
	public void testContainsID5() {
		assertEquals(false, gradeSystem.containsID(""));
	}
}
