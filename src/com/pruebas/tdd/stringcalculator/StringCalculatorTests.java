package com.pruebas.tdd.stringcalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StringCalculatorTests {


	@Test
	public void testNull() throws Exception {
		verify("test1",0,"");
	}

	@Test
	public void test1and2() throws Exception {
		verify("test1and2",1,"1");
		verify("test1and2",2,"2");
	}
	
	@Test
	public void test1plus2() throws Exception {
		verify("test1and2",3,"1,2");
	}

	@Test
	public void testSeveralSum() throws Exception {
		verify("testSeveralSum",29,"1,2,7,19");
	}

	@Test
	public void testCarriageReturn() throws Exception {
		verify("testCarriageReturn",3,"1\n2");
		verify("testCarriageReturn",6,"1\n2,3");
	}

	@Test
	public void testDefineDelimiter() throws Exception {
		verify("testDefineDelimiter",3,"//;\n1;2");
		verify("testDefineDelimiter",6,"//;\n1;2,2\n1");
		verify("testDefineDelimiter",11,"//*\n1*2,2\n1*5");
	}

	@Test
	public void testNegatives() throws Exception {
		try {
			verify("testDefineDelimiter",3,"//;\n1;2;-1,-5,4,-3");
		} catch (Exception e) {
			assertEquals("negatives not allowed -1,-5,-3",e.getMessage());
		}
		try {
			verify("testDefineDelimiter",6,"//;\n1;2,2\n1,-7,-8,9,-7");
		} catch (Exception e) {
			assertEquals("negatives not allowed -7,-8,-7",e.getMessage());
		}
	}
	
	@Test
	public void testBigNumbers() throws Exception {
		verify("testBigNumbers",9,"//;\n1;2,6,1004");
		verify("testBigNumbers",8,"//;\n1;2,2\n1,1005;2");
		verify("testBigNumbers",1008,"//;\n1;2,2\n1,1000;2");
	}

	@Test
	public void testAnyLengthDelimiters() throws Exception {
		verify("testAnyLengthDelimiters",3,"//[abc]\n1abc2");
		verify("testAnyLengthDelimiters",7,"//[abc]\n1abc2,2\n1abc1");
		verify("testAnyLengthDelimiters",12,"//[abc]\n1abc2,2\n1abc1,5");
	}

	@Test
	public void testSeveralAnyLengthDelimiters() throws Exception {
		verify("testSeveralAnyLengthDelimiters",3,"//[abc][ac]\n1abc2");
		verify("testSeveralAnyLengthDelimiters",7,"//[abc][ac]\n1ac2,2\n1abc1");
		verify("testSeveralAnyLengthDelimiters",12,"//[abc][ac][**]\n1abc2,2\n1ac1,5");
		verify("testSeveralAnyLengthDelimiters",18,"//[abc][ac][***]\n1abc2,2\n1ac1,5***4,2");
		verify("testSeveralAnyLengthDelimiters",17,"//[abc][ac][*]\n1abc2,2\n1ac1,5*4,1");
	}


    private void verify(String testCase,int expected,String val) throws Exception {
    	StringCalculator testClass = new StringCalculator();
		System.out.println("TestCase:"+testCase+"\t[expected="+expected+";returned="+testClass.add(val)+"]");
//		assertThat(expected, equalTo(testClass.add(val)));
		assertEquals(expected, testClass.add(val));
    }
	
	
}
