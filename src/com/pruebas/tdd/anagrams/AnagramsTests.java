package com.pruebas.tdd.anagrams;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class AnagramsTests {

	@Test
	void test1() {
		Anagrams anagrams = new Anagrams();
		String[] results = anagrams.calculate("deal");
		assertEquals("deal",results[0]);
		assertEquals("lead",results[1]);
	}

//	private void verify(String testCase,int expected,String val) {
//		Anagrams testClass = new Anagrams();
//		System.out.println("TestCase:"+testCase+"\t[expected="+expected+";returned="+testClass.calculate(val)+"]");
//		assertEquals(expected, testClass.calculate(val));
//	}
	
}
