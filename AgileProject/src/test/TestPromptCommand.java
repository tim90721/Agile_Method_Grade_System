package test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.UI;

/*
prompt: showGrade, showRank, updateWeights, exit
*/



class TestPromptCommand {

	private UI aUI = new UI();
	
	private ByteArrayInputStream inContent;
	private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Before
	void setUp() throws Exception {
		System.setOut (new PrintStream (outContent));
	}

	@After
	void tearDown() throws Exception {
		aUI = null;
		outContent = null;
	}

	@Test
	void testPromptCommand1() {
		inContent = new ByteArrayInputStream("showGrade".getBytes());
		System.setIn(inContent);
		String result = aUI.promptCommand();
		assertEquals("��J commend : showGrade, showRank, updateWeights �� exit�H", outContent);
		assertEquals ("showGrade", result);
	}

	@Test
	void testPromptCommand2() {
		inContent = new ByteArrayInputStream("showRank".getBytes());
		System.setIn(inContent);
		String result = aUI.promptCommand();
		assertEquals("��J commend : showGrade, showRank, updateWeights �� exit�H", outContent);
		assertEquals ("showRank", result);
	}

	@Test
	void testPromptCommand3() {
		inContent = new ByteArrayInputStream("updateWeights".getBytes());
		System.setIn(inContent);
		String result = aUI.promptCommand();
		assertEquals("��J commend : showGrade, showRank, updateWeights �� exit�H", outContent);
		assertEquals ("updateWeights", result);
	}

	@Test
	void testPromptCommand4() {
		inContent = new ByteArrayInputStream("exit".getBytes());
		System.setIn(inContent);
		String result = aUI.promptCommand();
		assertEquals("��J commend : showGrade, showRank, updateWeights �� exit�H", outContent);
		assertEquals ("exit", result);
	}

	@Test
	void testPromptCommand5() {
		inContent = new ByteArrayInputStream("showgrade".getBytes());
		System.setIn(inContent);
		String result = aUI.promptCommand();
		assertEquals("��J commend : showGrade, showRank, updateWeights �� exit�H", outContent);
		assertEquals ("showgrade", result);
	}

	@Test
	void testPromptCommand6() {
		inContent = new ByteArrayInputStream("123456".getBytes());
		System.setIn(inContent);
		String result = aUI.promptCommand();
		assertEquals("��J commend : showGrade, showRank, updateWeights �� exit�H", outContent);
		assertEquals ("123456", result);
	}

}
