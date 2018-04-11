package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import main.GradeSystem;

/*****************************************************************************-
class TestGetWeight
test a default weight -->
weight: lab1 0.1	lab2 0.1	lab3 0.1	midTerm 0.3		finalExam 0.4

test case1: Index 0
test case2: Index 0 ~ 4

**************************************************************************** */

class TestGetWeight {
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
	public void testGetWeight1() {
		assertEquals(0.1, gradeSystem.getWeight(0), 0.1);
	}

	@Test
	public void testGetWeight2() {
		double[] expectedWeights = new double[]{0.1, 0.1, 0.1, 0.3, 0.4};
		for(int i = 0;i < 5;i++) {
			assertEquals(expectedWeights[i], gradeSystem.getWeight(i), 0.1);
		}
	}
}
