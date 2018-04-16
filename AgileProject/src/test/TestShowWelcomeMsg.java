package test;

import static org.junit.Assert.*;

import java.io.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import main.UI;

class TestShowWelcomeMsg {
	
	private UI aUI = new UI();
	final String WelcomMsg = "Welcom �w��!!!\r\n";
	final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Before
	void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));
	}

	@After
	void tearDown() throws Exception {
		aUI = null;
	}

	@Test
	void test() {
		aUI.showWelcomMsg();
		assertEquals(WelcomMsg, outContent);
	}

}
