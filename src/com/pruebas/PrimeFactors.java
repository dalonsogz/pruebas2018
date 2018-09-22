package com.pruebas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PrimeFactors {

	private final static int NUMBER = 126;
	
	public static void main(String[] args) {
		
		List<Integer> primefactors = computeFactorsFor(NUMBER);
		
		String strPtrimefactors=primefactors.stream().map(p -> p.toString()).collect(Collectors.joining(","));
		
		System.out.println("Prime factors of "+NUMBER+" are "+strPtrimefactors);

	}

	public static List<Integer> computeFactorsFor(int n) {
		ArrayList<Integer> factors = new java.util.ArrayList<Integer>();

		for (int candidate = 2; n > 1; candidate++) {
			System.out.println(candidate);
			for (; n % candidate == 0; n /= candidate) {
				System.out.println("\t" + candidate);
				factors.add(candidate);
			}
		}

		return factors;
	}

}
