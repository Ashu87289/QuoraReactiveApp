package com.example.UnitTestApp.UnitTestApp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.internal.matchers.NotNull;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UnitTestAppApplicationTests {

	@Test
	void testAddition() {

		int res = 2+3;

		assertEquals(5,res);
		assertNotEquals(6,res);
	}

	@Test
	@DisplayName("Testing String length function test.")
	void testStringLength(){
		String name = "Junit";
		assertEquals(5,name.length());
		assertTrue(name.startsWith("J"));
		assertFalse(3 > 5);
		assertNotNull("hello");

		assertAll("name checks",
				()-> assertEquals(5,name.length()),
				()->assertTrue(name.contains("u")),
				()->assertFalse(name.isEmpty())
		);
	}

	@ParameterizedTest
	@CsvSource({"2,3,5","10,5,15"})
	void testAddition(int a,int b,int sum){
		assertEquals(sum, a+b);
	}

}
