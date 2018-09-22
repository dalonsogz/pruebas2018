package com.pruebas.tdd.roman;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class RomanNumberTest {

    @Test
    public void testSequential() throws Exception {
        verifyRomanNumber("testSequential()",1,"I");
        verifyRomanNumber("testSequential()",2,"II");
        verifyRomanNumber("testSequential()",3,"III");
        verifyRomanNumber("testSequential()",4,"IV");
        verifyRomanNumber("testSequential()",5,"V");
        verifyRomanNumber("testSequential()",6,"VI");
        verifyRomanNumber("testSequential()",7,"VII");
        verifyRomanNumber("testSequential()",8,"VIII");
        verifyRomanNumber("testSequential()",9,"IX");
        verifyRomanNumber("testSequential()",10,"X");
        verifyRomanNumber("testSequential()",11,"XI");
        verifyRomanNumber("testSequential()",14,"XIV");
        verifyRomanNumber("testSequential()",15,"XV");
        verifyRomanNumber("testSequential()",19,"XIX");
        verifyRomanNumber("testSequential()",20,"XX");
        verifyRomanNumber("testSequential()",30,"XXX");
        verifyRomanNumber("testSequential()",49,"XLIX");
        verifyRomanNumber("testSequential()",50,"L");
        verifyRomanNumber("testSequential()",90,"XC");
        verifyRomanNumber("testSequential()",99,"XCIX");
        verifyRomanNumber("testSequential()",100,"C");
        verifyRomanNumber("testSequential()",399,"CCCXCIX");
        verifyRomanNumber("testSequential()",400,"CD");
        verifyRomanNumber("testSequential()",500,"D");
        verifyRomanNumber("testSequential()",1000,"M");
        verifyRomanNumber("testSequential()",3000,"MMM");
    }

    @Test
    public void tests() throws Exception {
        verifyRomanNumber("tests()",1990,"MCMXC");
        verifyRomanNumber("tests()",2014,"MMXIV");
        verifyRomanNumber("tests()",2025,"MMXXV");
        verifyRomanNumber("tests()",1998,"MCMXCVIII");
        verifyRomanNumber("tests()",3762,"MMMDCCLXII");
        verifyRomanNumber("tests()",3999,"MMMCMXCIX");
    }
    

    private void verifyRomanNumber(String testCase,int val,String expected) {
        RomanNumber romanNumber = new RomanNumber();
		System.out.println("TestCase:"+testCase+"\t[expected="+expected+";returned="+romanNumber.convertirANumerosRomanos(val)+"]");
		assertThat(expected, equalTo(romanNumber.convertirANumerosRomanos(val)));
    }

}
