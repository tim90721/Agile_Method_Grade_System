package test;
import static org.junit.Assert.*;
import java.util.*;

import org.junit.Before;
import org.junit.Test;

import main.Grades;


/*****************************************************************************-
class TestCalculateTotalGrade 
aGrade: ID 962001051 name§õ«Â§Ê lab1 81  lab2 98  lab3 84  midTerm 90 finalExam 93

test case 1: lab1 0.1  lab2 0.1  lab3 0.1  midTerm 0.3  finalExam 0.4
test case 2: lab1 0.2  lab2 0.2  lab3 0.2  midTerm 0.2  finalExam 0.2
test case 3: lab1 0.1  lab2 0.1  lab3 0.0  midTerm 0.4  finalExam 0.4
**************************************************************************** */
public class TestCalculateTotalGrade {

	private Grades aGrades;
	
	@Before
	public void setUp() {
		aGrades = new Grades();
		aGrades.setGrade("962001051", "§õ«Â§Ê", 81, 98, 84, 90, 93);
	}
	
	@Test
	public void testCalculateTotalGrade1() {
		int expected_result = 91;
		List<Double> weight = Arrays.asList(0.1, 0.1, 0.1, 0.3, 0.4);
		int actual_result = aGrades.calculateTotalGrade(weight);
		assertEquals (expected_result, actual_result);
	}
	@Test
	public void testCalculateTotalGrade2() {
		int expected_result = 89;
		List<Double> weight = Arrays.asList(0.2, 0.2, 0.2, 0.2, 0.2);
		int actual_result = aGrades.calculateTotalGrade(weight);
		assertEquals (expected_result, actual_result);
		
	}
	@Test
	public void testCalculateTotalGrade3() {
		int expected_result = 91;
		List<Double> weight = Arrays.asList(0.1, 0.1, 0.0, 0.4, 0.4);
		int actual_result = aGrades.calculateTotalGrade(weight);
		assertEquals (expected_result, actual_result);
	}
}
