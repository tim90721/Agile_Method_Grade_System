package test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.SequenceInputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.NoSuchCommandExceptions;
import main.UI;

/*
prompt: showGrade, showRank, updateWeights, exit
*/

public class TestPromptCommand {

	private UI aUI;

	private String promptCommandMsg = "輸入指令 \n" + "1) G 顯示成績 (Grade) \n" + "2) R 顯示排名 (Rank) \n"
			+ "3) W 更新配分 (Weight) \n" + "4) E 離開選單 (Exit) \n";
	private String promptGrade = "凌宗廷成績:\n" + "lab1:	87\n" + "lab2:	86\n" + "lab3:	98\n" + "midTerm:	88\n"
			+ "finalExam:	87\n" + "total grade:	88\n";
	private String promptWeights = "舊配分\r\n" + 
			"\tlab1\t10%\n" + 
			"\tlab2\t10%\n" + 
			"\tlab3\t10%\n" + 
			"\tmid-term\t30%\n" + 
			"\tfinal exam\t40%\n" + 
			"輸入新配分\n" + 
			"\tlab1\t\tlab2\t\tlab3\t\tmid-term\t\tfinal exam\t" + 
			"請確認新配分\n" + 
			"\tlab1\t10%\n" + 
			"\tlab2\t10%\n" + 
			"\tlab3\t20%\n" + 
			"\tmid-term\t20%\n" + 
			"\tfinal exam\t40%\n" + 
			"以上正確嗎? Y (Yes) 或 N (No)";
	private String promptRank = "凌宗廷排名第38";
	private ByteArrayInputStream inContent;
	private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUp() throws Exception {
		aUI = new UI();
		System.setOut(new PrintStream(outContent));
		aUI.checkID("962001044");
	}

	@After
	public void tearDown() throws Exception {
		aUI = null;
		outContent = null;
	}

	@Test
	public void testPromptCommand1() throws NoSuchCommandExceptions {
		inContent = new ByteArrayInputStream("G".getBytes());
		System.setIn(inContent);
		String result = aUI.promptCommand();
		assertEquals(promptCommandMsg + promptGrade, outContent.toString());
		assertEquals("Grade", result);
	}

	@Test
	public void testPromptCommand2() throws NoSuchCommandExceptions {
		inContent = new ByteArrayInputStream("R".getBytes());
		System.setIn(inContent);
		String result = aUI.promptCommand();
		assertEquals(promptCommandMsg + promptRank, outContent.toString());
		assertEquals("Rank", result);
	}

	@Test
	public void testPromptCommand3() throws NoSuchCommandExceptions {
		SequenceInputStream weightCommand = new SequenceInputStream(
				new ByteArrayInputStream("10\n10\n20\n20\n40\n".getBytes()), new ByteArrayInputStream("Y".getBytes()));
		SequenceInputStream inContent = new SequenceInputStream(new ByteArrayInputStream("W\n".getBytes()),
				weightCommand);
		System.setIn(inContent);
		String result = aUI.promptCommand();
		assertEquals(promptCommandMsg + promptWeights, outContent.toString());
		assertEquals("Weight", result);
	}

	@Test
	public void testPromptCommand4() throws NoSuchCommandExceptions {
		inContent = new ByteArrayInputStream("E".getBytes());
		System.setIn(inContent);
		String result = aUI.promptCommand();
		assertEquals(promptCommandMsg, outContent.toString());
		assertEquals("Exit", result);
	}

	@Test
	public void testPromptCommand5() throws NoSuchCommandExceptions {
		inContent = new ByteArrayInputStream("showgrade".getBytes());
		System.setIn(inContent);
		String result;
		try {
			result = aUI.promptCommand();
		} catch (NoSuchCommandExceptions ex) {
			result = ex.getMessage();
		}
		assertEquals(promptCommandMsg, outContent.toString());
		assertEquals("No command named showgrade", result);
	}

	@Test
	public void testPromptCommand6() throws NoSuchCommandExceptions {
		inContent = new ByteArrayInputStream("123456".getBytes());
		System.setIn(inContent);
		String result;
		try {
			result = aUI.promptCommand();
		} catch (NoSuchCommandExceptions ex) {
			result = ex.getMessage();
		}
		assertEquals(promptCommandMsg, outContent.toString());
		assertEquals("No command named 123456", result);
	}
}
