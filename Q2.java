package test;

import java.util.HashSet;
import java.util.Scanner;

public class Q2 {

	public static interface StringReader {
		String readString();
	}
//Decorator
	public static class MyWordFilter implements StringReader { // Decorator
		StringReader reader;

		public MyWordFilter(StringReader reader) {
			this.reader = reader;
		}

		@Override
		public String readString() {
			String input = this.reader.readString();
			HashSet<String> seenWords = new HashSet<>();
			StringBuilder result = new StringBuilder();

			try (Scanner scanner = new Scanner(input)) {
				while (scanner.hasNext()) {
					String word = scanner.next();
					if (seenWords.add(word)) { // add() returns false if the word is already present
						result.append(word);
						result.append(";");
					}
				}
			}

			return result.toString();
		}
	}

	public static interface IntArrayReader {
		int[] readIntArray();
	}
//Adapter
	public static class MyIntArrayToStringReader implements StringReader { // Object Adapter
		IntArrayReader reader;

		public MyIntArrayToStringReader(IntArrayReader reader) {
			this.reader = reader;
		}

		@Override
		public String readString() {
			StringBuilder result = new StringBuilder();
			int[] array = reader.readIntArray();
			for (int i = 0; i < array.length; i++) {
				if (i > 0) {
					result.append(" ");
				}
				result.append(array[i]);
			}
			return result.toString();
		}
	}

	// ---------------------- test API ------------------------------

	public static class MyStringReader implements StringReader {
		@Override
		public String readString() {
			return "Hello Hello World World Q2";
		}
	}

	public static class MyIntArrayReader implements IntArrayReader {
		@Override
		public int[] readIntArray() {
			return new int[]{100, 100, 50, 50, 13, 14};
		}
	}

	public static void testAPI() {
		StringReader reader = new MyWordFilter(new MyStringReader());
		System.out.println(reader.readString()); // Hello;World;Q2;

		reader = new MyWordFilter(new MyIntArrayToStringReader(new MyIntArrayReader()));
		System.out.println(reader.readString()); // 100;50;13;14;
	}

	public static void main(String[] args) {
		testAPI();
	}
}
