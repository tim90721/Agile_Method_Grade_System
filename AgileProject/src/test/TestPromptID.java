package test;

import static org.junit.Assert.*;

import java.io.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.UI;

public class TestPromptID {
	
	private UI aUI = new UI();
	
	private ByteArrayInputStream inContent;
	private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private String outMsg = "輸入ID或Q(結束使用)?\r\n";
	@Before
	public void setUp() throws Exception {
		System.setOut (new PrintStream (outContent));
	}

	@After
	public void tearDown() throws Exception {
		aUI = null;
		outContent = null;
	}

	@Test
	public void testPromptID1() {
		inContent = new ByteArrayInputStream("Q".getBytes());
		System.setIn(inContent);
		String result = aUI.promptID();
		assertEquals(outMsg, outContent.toString());
		assertEquals ("Q", result);
	}
	
	@Test
	public void testPromptID2() {
		inContent = new ByteArrayInputStream("962001044".getBytes());
		System.setIn(inContent);
		String result = aUI.promptID();
		assertEquals(outMsg, outContent.toString());
		assertEquals ("962001044", result);
	}
	
	@Test
	public void testPromptID3() {
		inContent = new ByteArrayInputStream("1234567".getBytes());
		System.setIn(inContent);
		String result = aUI.promptID();
		assertEquals(outMsg, outContent.toString());
		assertEquals ("1234567", result);
	}

}
