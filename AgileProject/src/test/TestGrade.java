package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Grades;

/*****************************************************************************-
class TestGrade

grade

test case: test Grade's constructor works fine
**************************************************************************** */

public class TestGrade {

	@Test
	public void testGrade() {
		Grades grade = new Grades();
		assertNotNull(grade);
	}

}
