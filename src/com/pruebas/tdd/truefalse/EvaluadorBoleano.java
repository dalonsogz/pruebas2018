package com.pruebas.tdd.truefalse;

/**
 * @see <a href="https://www.javamexico.org/blogs/oscarryz/aqui_va_un_ejemplo_de_tdd">Aquí va un ejemplo de TDD</a>
 * @author dalonso
 *
 */
public class EvaluadorBoleano {

	public EvaluadorBoleano() {
		super();
	}
	
	public Boolean evalua(String expresion) {
		if (expresion!=null) {
			expresion = expresion.trim();
	        if (expresion.startsWith("(")) {
	        	expresion = expresion.substring(1, expresion.length()).trim();
	        }
	        if (expresion.endsWith(")")) {
	        	expresion = expresion.substring(0, expresion.length()-1).trim();
	        }

	        int indexOfY = expresion.lastIndexOf(" y ");
		    if( indexOfY > 0 ) {
		    	System.out.println(expresion.substring(0,indexOfY) + " && " + expresion.substring(indexOfY+3));
		        return evalua( expresion.substring(0,indexOfY) ) && evalua( expresion.substring(indexOfY+3));
		    }
		    int indexOfO = expresion.indexOf(" o ");
		    if( indexOfO > 0 ) {
		    	System.out.println(expresion.substring(0,indexOfO) + " || " + expresion.substring(indexOfO+3));
		        return evalua( expresion.substring(0,indexOfO) ) || evalua( expresion.substring(indexOfO+3));
		    }
		    
	        return "verdadero".equals(expresion);
		} else {
			return null;
		}
	}

	
	
}
