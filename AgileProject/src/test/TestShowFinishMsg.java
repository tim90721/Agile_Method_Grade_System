package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.UI;

public class TestShowFinishMsg {

	private UI aUI = new UI();
	final String finishMsg = "See you µ²§ô¤F!!!\r\n";
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
		aUI.showFinishMsg();
		assertEquals(finishMsg, outContent.toString());
	}

}
