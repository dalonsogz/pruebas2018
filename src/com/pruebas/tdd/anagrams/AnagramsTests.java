package com.pruebas.tdd.anagrams;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

class AnagramsTests {

	@Test
	void test1() {
		Anagrams anagrams = new Anagrams();
		assertNotNull((String[])anagrams.calculate("deal"));
	}

//	private void verify(String testCase,int expected,String val) {
//		Anagrams testClass = new Anagrams();
//		System.out.println("TestCase:"+testCase+"\t[expected="+expected+";returned="+testClass.calculate(val)+"]");
//		assertEquals(expected, testClass.calculate(val));
//	}
	
}
