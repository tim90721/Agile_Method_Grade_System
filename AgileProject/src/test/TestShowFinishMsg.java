package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.UI;

class TestShowFinishMsg {

	private UI aUI = new UI();
	final String WelcomMsg = "See you �����F!!!\r\n";
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
		aUI.showFinishMsg();
		assertEquals(WelcomMsg, outContent);
	}

}
