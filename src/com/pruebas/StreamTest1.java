package com.pruebas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamTest1 {

	public StreamTest1() {
		super();


//		List<String> strList = Stream.of("Daniel","Pepe").map(it -> it).collect(Collectors.toList());
		List<String> strList = Arrays.asList("Daniel","Pepe","Ramon","Rosa","Juan");

		List<String> strListFiltered = strList.stream().map(it -> ("["+it+"]")).collect(Collectors.toList());
		for (String str:strListFiltered)
			System.out.println(str);
		
		
		System.out.println("------------------------------------------");
		Predicate<String> predicate = it -> it.startsWith("R");
		strListFiltered = strList.stream().filter(predicate).collect(Collectors.toList());
		for (String str:strListFiltered)
			System.out.println(str);

		
		System.out.println("------------------------------------------");
		Comparator<String> comparator = (s1,s2) -> s1.compareTo(s2);
		strListFiltered = strList.stream().sorted(comparator).collect(Collectors.toList());
		for (String str:strListFiltered)
			System.out.println(str);
		

		System.out.println("------------------------------------------");
		String str = strList.stream().reduce("", (s1,s2) -> s1 + "-" + s2);
		System.out.println(str);

		System.out.println("------------------------------------------");
		str = strList.stream().sorted(comparator).reduce("", (s1,s2) -> s1 + "-" + s2);
		System.out.println(str);

		

	}
}
