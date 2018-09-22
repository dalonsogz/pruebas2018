package com.pruebas.tdd.stringcalculator2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StringCalculatorTestsOldAdapted {


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
		verify("testDefineDelimiter",6,"//;\n1;2;2;1");
		verify("testDefineDelimiter",11,"//*\n1*2*2*1*5");
	}

	@Test
	public void testNegatives() throws Exception {
		try {
			verify("testDefineDelimiter",3,"//;\n1;2;-1;-5;4;-3");
		} catch (Exception e) {
			assertEquals("negative number: -1,-5,-3",e.getMessage());
		}
		try {
			verify("testDefineDelimiter",6,"//;\n1;2;2;1;-7;-8;9;-7");
		} catch (Exception e) {
			assertEquals("negative number: -7,-8,-7",e.getMessage());
		}
	}
	
	@Test
	public void testBigNumbers() throws Exception {
		verify("testBigNumbers",13,"//;\n1;2;6;1004");
		verify("testBigNumbers",12,"//;\n1;2;2;1005;2");
		verify("testBigNumbers",8,"//;\n1;2;2;1;1000;2");
	}

	@Test
	public void testAnyLengthDelimiters() throws Exception {
		verify("testAnyLengthDelimiters",3,"//[abc]\n1abc2");
		verify("testAnyLengthDelimiters",7,"//[abc]\n1abc2abc2abc1abc1");
		verify("testAnyLengthDelimiters",12,"//[abc]\n1abc2abc2abc1abc1abc5");
	}

	@Test
	public void testSeveralAnyLengthDelimiters() throws Exception {
		verify("testSeveralAnyLengthDelimiters",3,"//[abc][ac]\n1abc2");
		verify("testSeveralAnyLengthDelimiters",7,"//[abc][ac]\n1ac2ac2abc1abc1");
		verify("testSeveralAnyLengthDelimiters",12,"//[abc][ac][**]\n1abc2**2**1ac1**5");
		verify("testSeveralAnyLengthDelimiters",18,"//[abc][ac][***]\n1abc2***2***1ac1***5***4***2");
		verify("testSeveralAnyLengthDelimiters",17,"//[abc][ac][*]\n1abc2*2ac1ac1*5*4*1");
	}


    private void verify(String testCase,int expected,String val) throws Exception {
		System.out.println("TestCase:"+testCase+"\t[expected="+expected+";returned="+StringCalculator.sum(val)+"]");
//		assertThat(expected, equalTo(StringCalculator.sum(val)));
		assertEquals(expected, StringCalculator.sum(val));
    }

}
