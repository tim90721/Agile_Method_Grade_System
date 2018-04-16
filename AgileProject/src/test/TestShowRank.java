package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.GradeSystem;

/*****************************************************************************-
class TestCalculateTotalGrade 
aGrade: ID 962001051 name���§� lab1 81  lab2 98  lab3 84  midTerm 90 finalExam 93
aGrade: ID 962001044 name��v�� lab1 87  lab2 86  lab3 98  midTerm 88 finalExam 87

test case1: ID 962001051
test case2: ID 962001044
test case3: ID 1234567
test case4: ID ""
**************************************************************************** */

class TestShowRank {
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
	public void testShowRank1() {
		String output = "���§ʱƦW��1\n";
		assertEquals(output, gradeSystem.showRank("962001051"));
	}

	@Test
	public void testShowRank2() {
		String output = "��v�ʱƦW��2\n";
		assertEquals(output, gradeSystem.showRank("962001044"));
	}
	
	@Test
	public void testShowRank3() {
		String output = "Input Error";
		assertEquals(output, gradeSystem.showRank("1234567"));
	}
	
	@Test
	public void testShowRank4() {
		String output = "InputError";
		assertEquals(output, gradeSystem.showRank(""));
	}
	
}
