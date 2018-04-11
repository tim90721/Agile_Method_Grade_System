package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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
