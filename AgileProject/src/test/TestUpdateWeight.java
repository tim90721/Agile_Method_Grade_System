package test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.GradeSystem;

/*****************************************************************************-
class TestGetWeight
weight

test case1: weight lab1 0.1		lab2 0.1	lab3 0.2	midTerm	0.3		finalExam 0.3
test case2: weight lab1 0.1		lab2 0.2	lab3 0.2	midTerm	0.3		finalExam 0.3
test case2: weight lab1 0.01		lab2 0.2	lab3 0.2	midTerm	0.3		finalExam 0.3

**************************************************************************** */

class TestUpdateWeight {
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
	public void testUpdateWeight1() {
		ArrayList<Double> newWeights = new ArrayList<Double>(Arrays.asList(0.2, 0.2, 0.1, 0.2, 0.3));
		ByteArrayInputStream inContent = new ByteArrayInputStream("0.2 0.2 0.1 0.2 0.3".getBytes());
		System.setIn(inContent);
		assertEquals(true, gradeSystem.updateWeight());
		for(int i = 0;i < 5;i++) {
			assertEquals(newWeights.get(i), gradeSystem.getWeight(i));
		}
	}
	
	@Test
	public void testUpdateWeight2() {
		ArrayList<Double> oldWeights = new ArrayList<Double>(Arrays.asList(0.1, 0.1, 0.1, 0.3, 0.4));
//		ArrayList<Double> newWeights = new ArrayList<Double>(Arrays.asList(0.1, 0.2, 0.2, 0.3, 0.3));
		ByteArrayInputStream inContent = new ByteArrayInputStream("0.1 0.2 0.2 0.3 0.3".getBytes());
		System.setIn(inContent);
		assertEquals(false, gradeSystem.updateWeight());
		for(int i = 0;i < 5;i++) {
			assertEquals(oldWeights.get(i), gradeSystem.getWeight(i));
		}
	}
	
	@Test
	public void testUpdateWeight3() {
		ArrayList<Double> oldWeights = new ArrayList<Double>(Arrays.asList(0.1, 0.1, 0.1, 0.3, 0.4));
		ArrayList<Double> newWeights = new ArrayList<Double>(Arrays.asList(0.01, 0.2, 0.2, 0.3, 0.3));
		ByteArrayInputStream inContent = new ByteArrayInputStream("0.01 0.2 0.2 0.3 0.3".getBytes());
		System.setIn(inContent);
		assertEquals(false, gradeSystem.updateWeight());
		for(int i = 0;i < 5;i++) {
			assertEquals(oldWeights.get(i), gradeSystem.getWeight(i));
		}
	}
}
