package test;

import static org.junit.Assert.*;

import java.io.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import main.UI;

/*****************************************************************************-
class TestShowWelcomeMsg
aGrade: ID 962001051 name§õ«Â§Ê 

test case1: ID 962001051
**************************************************************************** */
public class TestShowWelcomeMsg {
	
	private UI aUI = new UI();
	final String welcomMsg = "Welcome Åwªï!!!";

	final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void tearDown() throws Exception {
		aUI = null;
	}

	@Test
	public void test() {
		String ID = "962001051";
		aUI.showWelcomeMsg(ID);
		assertEquals(welcomMsg + "§õ«Â§Ê\r\n", outContent.toString());
	}

}
