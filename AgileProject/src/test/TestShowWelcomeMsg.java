package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.UI;

class TestShowWelcomeMsg {
	
	private UI aUI = new UI();
	final String WelcomMsg = "Welcom Åwªï!!!\r\n";
	final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@BeforeEach
	void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));
	}

	@AfterEach
	void tearDown() throws Exception {
		aUI = null;
	}

	@Test
	void test() {
		aUI.showWelcomMsg();
		assertEquals(WelcomMsg, outContent);
	}

}
