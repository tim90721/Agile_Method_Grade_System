package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.GradeSystem;

/*****************************************************************************-
class TestGradeSystem

gradeSystem

test case: test GradeSystem's constructor works fine
**************************************************************************** */

public class TestGradeSystem {

	@Test
	public void testGradeSystem() {
		GradeSystem gradeSystem = new GradeSystem();
		assertNotNull(gradeSystem);
	}

}
