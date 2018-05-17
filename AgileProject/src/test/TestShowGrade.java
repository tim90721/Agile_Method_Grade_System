package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.GradeSystem;

/*****************************************************************************-
class TestCalculateTotalGrade 
aGrade: ID 962001051 name§õ«Â§Ê lab1 81  lab2 98  lab3 84  midTerm 90 finalExam 93
aGrade: ID 962001044 name­â©v§Ê lab1 87  lab2 86  lab3 98  midTerm 88 finalExam 87

test case1: ID 962001051
test case2: ID 962001044
test case3: ID 1234567
test case4: ID ""
**************************************************************************** */

class TestShowGrade {
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
	public void testShowGrade1() {
		String output = "§õ«Â§Ê¦¨ÁZ:lab1:\t81\n"
				+ "lab2:\t98\n"
				+ "lab3:\t84\n"
				+ "midTerm:\t90\n"
				+ "finalExam:\t93\n"
				+ "total grade:\t91\n";
		assertEquals(output, gradeSystem.showGrade("962001051"));
	}
	
	@Test
	public void testShowGrade2() {
		String output = "­â©v§Ê¦¨ÁZ:lab1:\t87\n"
				+ "lab2:\t86\n"
				+ "lab3:\t98\n"
				+ "midTerm:\t88\n"
				+ "finalExam:\t87\n"
				+ "total grade:\t88\n";
		assertEquals(output, gradeSystem.showGrade("962001044"));
	}

	@Test
	public void testShowGrade3() {
		String output = "Input Error";
		assertEquals(output, gradeSystem.showGrade("1234567"));
	}
	
	@Test
	public void testShowGrade4() {
		String output = "Input Error";
		assertEquals(output, gradeSystem.showGrade(""));
	}
}
