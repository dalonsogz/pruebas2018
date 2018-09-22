package com.pruebas.tdd.truefalse;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EvaluatorTest {

	@Test
    public void testTrue() {
		evalua("testTrue",true,"verdadero");
    }

	@Test
    public void testFalse() {
		evalua("testFalse",false,"falso");
    }

	@Test
    public void testParentesis() {
		evalua("testParentesis",true,"(verdadero)");
		evalua("testParentesis",false,"(falso)");
    }
	
	@Test
	public void testEspacios() {
		evalua("testEspacios",true," verdadero  ");
		evalua("testEspacios",false," falso    ");
		evalua("testEspacios",true," ( verdadero   )     ");
		evalua("testEspacios",false," ( falso   )     ");
	}
	
	@Test
	public void testY() {
		evalua("testY",true,"verdadero y verdadero");
		evalua("testY",false,"verdadero y falso");
	}
	
	@Test
	public void testYConParentesis() {
		evalua("testYConParentesis",true,"(verdadero ) y verdadero");
		evalua("testYConParentesis",false,"( falso ) y verdadero");
		evalua("testYConParentesis",true,"(verdadero ) y ( verdadero )");
		evalua("testYConParentesis",false,"(verdadero ) y ( falso )");
	}
	
	@Test
	public void testO(){
		evalua("testO",true,"verdadero o verdadero");
		evalua("testO",true,"falso o verdadero");
	}
	
	@Test
	public void tests(){
	    evalua("tests",true, "( verdadero y falso ) o verdadero");
	}
	
	@Test
	private void evalua(String testCase,boolean expected,String str) {
		EvaluadorBoleano evaluador = new EvaluadorBoleano();
		System.out.println("TestCase:"+testCase+"\t[expected="+expected+";returned="+evaluador.evalua(str)+"]");
		assertThat(expected, equalTo(evaluador.evalua(str)));
	}
}
