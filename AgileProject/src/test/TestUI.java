package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.UI;

class TestUI {

	@Test
	void testUI() {
		assertNotNull(new UI());
	}

}
