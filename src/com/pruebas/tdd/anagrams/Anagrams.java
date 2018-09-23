package com.pruebas.tdd.anagrams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Anagrams {

	public Anagrams() {}

	public String[] calculate(String str) {
		
		String fileName = "wordlist.txt";
		ArrayList<String> anagrams = null;

		HashSet<String> words = new HashSet<String>();

		StringBuilder sb = new StringBuilder();
		try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
			lines.forEach( (p) -> {
				String[] strs = p.split(" ");
				Set<String> test = Arrays.stream(strs).collect(Collectors.toSet());
				words.addAll(test);
			});
			
		} catch (IOException e) {
			e.printStackTrace();
		}

//		for (String word:words) {
//			System.out.print(word+"-");
//		}
		
		for (String word:words) {
			String wordBak = word;
			if (word.length()!=str.length()) continue;
			for (int i=0; i<str.length(); i++) {
				char c = str.charAt(i);
				if (word.contains(c+"")) {
					word = word.replaceFirst(c+"", "");
				}
			}
			if (word.isEmpty()) {
				if (anagrams==null) anagrams=new ArrayList<String>();
				anagrams.add(wordBak);
			}
				
		}
		
		if (anagrams!=null) {
			String[] result = new String[anagrams.size()];
			int i = 0;
			for (String anagram:anagrams) {
				result[i++]=anagram;
				System.out.print(anagram+"\t");
			}
			return (result);
		} else {
			return null;
		}
	}

	
	
}
