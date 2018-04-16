package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Grades;

/*****************************************************************************-
class TestGrade

grade

test case: test Grade's constructor works fine
**************************************************************************** */

class TestGrade {

	@Test
	void testGrade() {
		Grades grade = new Grades();
		assertNotNull(grade);
	}

}
