package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.UI;

class TestPromptID {
	
	private UI aUI = new UI();
	
	private ByteArrayInputStream inContent;
	private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@BeforeEach
	void setUp() throws Exception {
		System.setOut (new PrintStream (outContent));
	}

	@AfterEach
	void tearDown() throws Exception {
		aUI = null;
		outContent = null;
	}

	@Test
	void testPromptID1() {
		inContent = new ByteArrayInputStream("Q".getBytes());
		System.setIn(inContent);
		String result = aUI.promptID();
		assertEquals("輸入ID或 Q (結束使用)？", outContent);
		assertEquals ("Q", result);
	}
	
	@Test
	void testPromptID2() {
		inContent = new ByteArrayInputStream("962001044".getBytes());
		System.setIn(inContent);
		String result = aUI.promptID();
		assertEquals("輸入ID或 Q (結束使用)？", outContent);
		assertEquals ("962001044", result);
	}
	
	@Test
	void testPromptID3() {
		inContent = new ByteArrayInputStream("1234567".getBytes());
		System.setIn(inContent);
		String result = aUI.promptID();
		assertEquals("輸入ID或 Q (結束使用)？", outContent);
		assertEquals ("1234567", result);
	}

}
