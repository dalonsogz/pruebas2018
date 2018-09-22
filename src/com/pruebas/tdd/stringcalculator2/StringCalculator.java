package com.pruebas.tdd.stringcalculator2;

import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * String Calculator
 *
 * - This string calculator only accept the delimiters defined (if they are defined, default delimiters doesn't apply).
 * - Numbers bigger than 1000 aren't discarded, they add n%1000 to the sum.
 *
 * @see <a href="http://osherove.com/tdd-kata-1/">String Calculator (not exactly same instructions, so 'StringCalculatorTestsOldAdapted' it's modfied from first StringCalculator)</a>
 * @see <a href="https://github.com/letsdeveloper/Lets-Develop-Code-Kata/tree/master/src/main/java/com/letsdeveloper">GitHub - Lets-Develop-Code-Kata</a>
 * @see <a href="https://www.youtube.com/watch?v=QGmdAWgKqhU">[LD] String Calculator Kata 01 - IntStream (Java 8) | Let's Develop</a>
 * @see <a href="https://www.youtube.com/watch?v=gh4wDm4Nj0E">[LD] String Calculator Kata 02 - Specify Delimiters | Let's Develop</a>
 * @see <a href="https://www.youtube.com/watch?v=ODbzIAWxK0I">[LD] String Calculator Kata 03 - Testing Exceptions (JUnit) &amp; Streams (Java8) | Let's Develop</a>
 * @see <a href="https://www.youtube.com/watch?v=dDfTtVZUS1g">[LD] String Calculator Kata 04 - More Delimiters w Java 8 Streams | Let's Develop</a>
 * @author dalonso
 *
 */
public class StringCalculator {

	private String delimiter;
	private String numbers;

	private StringCalculator(String delimiter, String numbers) {
		this.delimiter = delimiter;
		this.numbers = numbers;
	}

	private int sum() {
		ensureNoNegativeNumbers();
		return getNumbers().sum();
	}

	private void ensureNoNegativeNumbers() {
		String negativeNumberSequence = getNumbers().filter(n -> n < 0)
				.mapToObj(Integer::toString)
				.collect(Collectors.joining(","));
		if (!negativeNumberSequence.isEmpty()) {
			throw new IllegalArgumentException("negative number: " + negativeNumberSequence);
		}
	}

	private IntStream getNumbers() {
		if (numbers.isEmpty()) {
			return IntStream.empty();
		} else {
			return Stream.of(numbers.split(delimiter))
					.mapToInt(Integer::parseInt)
					.map(n -> n % 1000);
		}
	}

	public static int sum(String input) {
		return parseInput(input).sum();
	}

	private static StringCalculator parseInput(String input) {
		if (input.startsWith("//")) {
			String[] headerAndNumberSequence = input.split("\n", 2);
			String delimiter = parseDelimiter(headerAndNumberSequence[0]);
			return new StringCalculator(delimiter, headerAndNumberSequence[1]);
		} else {
			return new StringCalculator(",|\n", input);
		}
	}

	private static String parseDelimiter(String header) {
		String delimiter = header.substring(2);
		if (delimiter.startsWith("[")) {
			delimiter = delimiter.substring(1, delimiter.length() - 1);
		}
		return Stream.of(delimiter.split(Pattern.quote("][")))
				.map(Pattern::quote)
				.collect(Collectors.joining("|"));
	}

}