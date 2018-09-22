package com.pruebas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.pruebas.beans.Bar;
import com.pruebas.beans.Foo;
import com.pruebas.beans.Person;

/**
 * @see <a href="https://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/">Java 8 Stream Tutorial</a>
 * @author dalonso
 *
 */
public class StreamPerson {

	public StreamPerson() {
		super();

		
		// Different kind of streams ///////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("--Different kind of streams----------------------------------------------------------");
		
		List<String> myList =
			    Arrays.asList("a1", "a2", "b1", "c2", "c1");

			myList
			    .stream()
			    .filter(s -> s.startsWith("c"))
			    .map(String::toUpperCase)
			    .sorted()
			    .forEach(System.out::println);

			// C1
			// C2
		
		System.out.println("------------------------------------------------------------");
		Arrays.asList("a1", "a2", "a3")
		    .stream()
		    .findFirst()
		    .ifPresent(System.out::println);  // a1
		System.out.println("------------------------------------------------------------");
		Stream.of("a1", "a2", "a3")
		    .findFirst()
		    .ifPresent(System.out::println);  // a1
			System.out.println("------------------------------------------------------------");
			IntStream.range(1, 4)
		    .forEach(System.out::println);
			// 1
			// 2
			// 3
		System.out.println("------------------------------------------------------------");
		Arrays.stream(new int[] {1, 2, 3})
		    .map(n -> (2 * n) + 1)
		    .average()
		    .ifPresent(System.out::println);  // 5.0
		System.out.println("------------------------------------------------------------");
		Stream.of("a1", "a2", "a3")
		    .map(s -> s.substring(1))
		    .mapToInt(Integer::parseInt)
		    .max()
		    .ifPresent(System.out::println);  // 3
		System.out.println("------------------------------------------------------------");
		IntStream.range(1, 4)
		    .mapToObj(i -> "a" + i)
		    .forEach(System.out::println);
			// a1
			// a2
			// a3
		System.out.println("------------------------------------------------------------");
		Stream.of(1.0, 2.0, 3.0)
		    .mapToInt(Double::intValue)
		    .mapToObj(i -> "a" + i)
		    .forEach(System.out::println);
			// a1
			// a2
			// a3
		
		// Processing Order ////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("--Processing Order----------------------------------------------------------");

		Stream.of("d2", "a2", "b1", "b3", "c")
		    .filter(s -> {
		        System.out.println("filter: " + s);
		        return true;
		    })
		    .forEach(s -> System.out.println("forEach: " + s));
//		    filter:  d2
//		    forEach: d2
//		    filter:  a2
//		    forEach: a2
//		    filter:  b1
//		    forEach: b1
//		    filter:  b3
//		    forEach: b3
//		    filter:  c
//		    forEach: c

		    System.out.println("------------------------------------------------------------");
		
		Stream.of("d2", "a2", "b1", "b3", "c")
		    .map(s -> {
		        System.out.println("map: " + s);
		        return s.toUpperCase();
		    })
		    .anyMatch(s -> {
		        System.out.println("anyMatch: " + s);
		        return s.startsWith("A");
		    });
	
			// map:      d2
			// anyMatch: D2
			// map:      a2
			// anyMatch: A2
		
		// Why order matters ////////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("--Why order matters----------------------------------------------------------");
		
		Stream.of("d2", "a2", "b1", "b3", "c")
		    .map(s -> {
		        System.out.println("map: " + s);
		        return s.toUpperCase();
		    })
		    .filter(s -> {
		        System.out.println("filter: " + s);
		        return s.startsWith("A");
		    })
		    .forEach(s -> System.out.println("forEach: " + s));

			// map:     d2
			// filter:  D2
			// map:     a2
			// filter:  A2
			// forEach: A2
			// map:     b1
			// filter:  B1
			// map:     b3
			// filter:  B3
			// map:     c
			// filter:  C
		
		System.out.println("------------------------------------------------------------");

		Stream.of("d2", "a2", "b1", "b3", "c")
		    .filter(s -> {
		        System.out.println("filter: " + s);
		        return s.startsWith("a");
		    })
		    .map(s -> {
		        System.out.println("map: " + s);
		        return s.toUpperCase();
		    })
		    .forEach(s -> System.out.println("forEach: " + s));
	
			// filter:  d2
			// filter:  a2
			// map:     a2
			// forEach: A2
			// filter:  b1
			// filter:  b3
			// filter:  c
		
		System.out.println("------------------------------------------------------------");

		Stream.of("d2", "a2", "b1", "b3", "c")
		    .sorted((s1, s2) -> {
		        System.out.printf("sort: %s; %s\n", s1, s2);
		        return s1.compareTo(s2);
		    })
		    .filter(s -> {
		        System.out.println("filter: " + s);
		        return s.startsWith("a");
		    })
		    .map(s -> {
		        System.out.println("map: " + s);
		        return s.toUpperCase();
		    })
		    .forEach(s -> System.out.println("forEach: " + s));
		
//		sort:    a2; d2
//		sort:    b1; a2
//		sort:    b1; d2
//		sort:    b1; a2
//		sort:    b3; b1
//		sort:    b3; d2
//		sort:    c; b3
//		sort:    c; d2
//		filter:  a2
//		map:     a2
//		forEach: A2
//		filter:  b1
//		filter:  b3
//		filter:  c
//		filter:  d2
		
		System.out.println("------------------------------------------------------------");

		Stream.of("d2", "a2", "b1", "b3", "c")
		    .filter(s -> {
		        System.out.println("filter: " + s);
		        return s.startsWith("a");
		    })
		    .sorted((s1, s2) -> {
		        System.out.printf("sort: %s; %s\n", s1, s2);
		        return s1.compareTo(s2);
		    })
		    .map(s -> {
		        System.out.println("map: " + s);
		        return s.toUpperCase();
		    })
		    .forEach(s -> System.out.println("forEach: " + s));

			// filter:  d2
			// filter:  a2
			// filter:  b1
			// filter:  b3
			// filter:  c
			// map:     a2
			// forEach: A2
		
		System.out.println("------------------------------------------------------------");

		
		// Advanced Operations //////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("--Advanced Operations----------------------------------------------------------");
		
		List<Person> persons =
			    Arrays.asList(
			        new Person("Max", 18),
			        new Person("Peter", 23),
			        new Person("Pamela", 23),
			        new Person("David", 12));
		
		// Collect ////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("--Collect----------------------------------------------------------");
		
		
		List<Person> filtered =
			    persons
			        .stream()
			        .filter(p -> p.name.startsWith("P"))
			        .collect(Collectors.toList());
	
		System.out.println(filtered);    // [Peter, Pamela]

		
		System.out.println("------------------------------------------------------------");
		
		
		Map<Integer, List<Person>> personsByAge = persons
			    .stream()
			    .collect(Collectors.groupingBy(p -> p.age));

		personsByAge.forEach((age, p) -> System.out.format("age %s: %s\n", age, p));

			// age 18: [Max]
			// age 23: [Peter, Pamela]
			// age 12: [David]
			
		System.out.println("------------------------------------------------------------");
			
		
		Double averageAge = persons
			    .stream()
			    .collect(Collectors.averagingInt(p -> p.age));

		System.out.println(averageAge);     // 19.0

		
		System.out.println("------------------------------------------------------------");

		
		IntSummaryStatistics ageSummary =
			    persons
			        .stream()
			        .collect(Collectors.summarizingInt(p -> p.age));

		System.out.println(ageSummary);
		// IntSummaryStatistics{count=4, sum=76, min=12, average=19.000000, max=23}
		
		
		System.out.println("------------------------------------------------------------");

		
		String phrase = persons
			    .stream()
			    .filter(p -> p.age >= 18)
			    .map(p -> p.name)
			    .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));

		System.out.println(phrase);
		// In Germany Max and Peter and Pamela are of legal age.
		
		
		System.out.println("------------------------------------------------------------");

		
		Map<Integer, String> map = persons
			    .stream()
			    .collect(Collectors.toMap(
			        p -> p.age,
			        p -> p.name,
			        (name1, name2) -> name1 + ";" + name2));

		System.out.println(map);
		// {18=Max, 23=Peter;Pamela, 12=David}
			
		
		System.out.println("------------------------------------------------------------");

		
		Collector<Person, StringJoiner, String> personNameCollector =
			    Collector.of(
			        () -> new StringJoiner(" | "),          // supplier
			        (j, p) -> j.add(p.name.toUpperCase()),  // accumulator
			        (j1, j2) -> j1.merge(j2),               // combiner
			        StringJoiner::toString);                // finisher

		String names = persons
			    .stream()
			    .collect(personNameCollector);

		
		System.out.println(names);  // MAX | PETER | PAMELA | DAVID
		
		
		//FlatMap ////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("--FlatMap----------------------------------------------------------");
		
		List<Foo> foos = new ArrayList<>();

		// create foos
		IntStream
		    .range(1, 4)
		    .forEach(i -> foos.add(new Foo("Foo" + i)));

		// create bars
		foos.forEach(f ->
		    IntStream
		        .range(1, 4)
		        .forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));
		
		foos.stream()
	    .flatMap(f -> f.bars.stream())
	    .forEach(b -> System.out.println(b.name));

			// Bar1 <- Foo1
			// Bar2 <- Foo1
			// Bar3 <- Foo1
			// Bar1 <- Foo2
			// Bar2 <- Foo2
			// Bar3 <- Foo2
			// Bar1 <- Foo3
			// Bar2 <- Foo3
			// Bar3 <- Foo3
		
		System.out.println("------------------------------------------------------------");

		
		IntStream.range(1, 4)
	    .mapToObj(i -> new Foo("Foo" + i))
	    .peek(f -> IntStream.range(1, 4)
	        .mapToObj(i -> new Bar("Bar" + i + " <- " + f.name))
	        .forEach(f.bars::add))
	    .flatMap(f -> f.bars.stream())
	    .forEach(b -> System.out.println(b.name));
		
		
		// Reduce ////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("--Reduce----------------------------------------------------------");
		
		persons
	    .stream()
	    .reduce((p1, p2) -> p1.age > p2.age ? p1 : p2)
	    .ifPresent(System.out::println);    // Pamela
		
		
		System.out.println("------------------------------------------------------------");

		
		Person result =
			    persons
			        .stream()
			        .reduce(new Person("", 0), (p1, p2) -> {
			            p1.age += p2.age;
			            p1.name += p2.name;
			            return p1;
			        });

		System.out.format("name=%s; age=%s", result.name, result.age);
		// name=MaxPeterPamelaDavid; age=76
			
		
		System.out.println("\n------------------------------------------------------------");

		
		Integer ageSum = persons
			    .stream()
			    .reduce(0, (sum, p) -> sum += p.age, (sum1, sum2) -> sum1 + sum2);

			System.out.println(ageSum);  // 76
		
		System.out.println("------------------------------------------------------------");

		
		ageSum = persons
			    .stream()
			    .reduce(0,
			        (sum, p) -> {
			            System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
			            return sum += p.age;
			        },
			        (sum1, sum2) -> {
			            System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
			            return sum1 + sum2;
			        });

			// accumulator: sum=0; person=Max
			// accumulator: sum=18; person=Peter
			// accumulator: sum=41; person=Pamela
			// accumulator: sum=64; person=David
		
		
		System.out.println("------------------------------------------------------------");
		
		
		ageSum = persons
			    .parallelStream()
			    .reduce(0,
			        (sum, p) -> {
			            System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
			            return sum += p.age;
			        },
			        (sum1, sum2) -> {
			            System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
			            return sum1 + sum2;
			        });

			// accumulator: sum=0; person=Pamela
			// accumulator: sum=0; person=David
			// accumulator: sum=0; person=Max
			// accumulator: sum=0; person=Peter
			// combiner: sum1=18; sum2=23
			// combiner: sum1=23; sum2=12
			// combiner: sum1=41; sum2=35
		

		// Parallel streams ////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("--Parallel streams----------------------------------------------------------");
		
		
		Arrays.asList("a1", "a2", "b1", "c2", "c1")
		    .parallelStream()
		    .filter(s -> {
		        System.out.format("filter: %s [%s]\n",
		            s, Thread.currentThread().getName());
		        return true;
		    })
		    .map(s -> {
		        System.out.format("map: %s [%s]\n",
		            s, Thread.currentThread().getName());
		        return s.toUpperCase();
		    })
		    .forEach(s -> System.out.format("forEach: %s [%s]\n",
		        s, Thread.currentThread().getName()));
		
		
		System.out.println("------------------------------------------------------------");

		
		Arrays.asList("a1", "a2", "b1", "c2", "c1")
		    .parallelStream()
		    .filter(s -> {
		        System.out.format("filter: %s [%s]\n",
		            s, Thread.currentThread().getName());
		        return true;
		    })
		    .map(s -> {
		        System.out.format("map: %s [%s]\n",
		            s, Thread.currentThread().getName());
		        return s.toUpperCase();
		    })
		    .sorted((s1, s2) -> {
		        System.out.format("sort: %s <> %s [%s]\n",
		            s1, s2, Thread.currentThread().getName());
		        return s1.compareTo(s2);
		    })
		    .forEach(s -> System.out.format("forEach: %s [%s]\n",
		        s, Thread.currentThread().getName()));
		
		
		System.out.println("------------------------------------------------------------");

		
		persons
		    .parallelStream()
		    .reduce(0,
		        (sum, p) -> {
		            System.out.format("accumulator: sum=%s; person=%s [%s]\n",
		                sum, p, Thread.currentThread().getName());
		            return sum += p.age;
		        },
		        (sum1, sum2) -> {
		            System.out.format("combiner: sum1=%s; sum2=%s [%s]\n",
		                sum1, sum2, Thread.currentThread().getName());
		            return sum1 + sum2;
		        });
		
		
		System.out.println("------------------------------------------------------------");

	}

}
