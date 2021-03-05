import java.util.Arrays;

public class ArrayStringSort {

	public static void main(String[] args) {

		String[] strings = new String[] { "abc", "abcde", "abc", "kashk", "Saumil", "Java", "java", "JAav", "jAva",
				"JAavs", "Abc", "ABc", "abcd", "abcde", "aBcf", "ab", "Ac", "asA", "gc", "cb" };
		String[] words = new String[] { "abc", "abcde", "abc", "kashk", "Saumil", "Java", "java", "JAav", "jAva",
				"JAavs", "Abc", "ABc", "abcd", "abcde", "aBcf", "ab", "Ac", "asA", "gc", "cb" };

		// Arrays.sort is built in static method in Arrays class to sort elements of
		// array.
		Arrays.sort(strings);
		System.out.println("Arrays.sort  :" + Arrays.toString(strings));

		System.out.println("==============================================================================");

		// First Loop makes sure all elements in array are checked.
		// it runs n time(n = number of elements present in array)
		for (int i = 0; i < words.length; i++) {

			// Second loop will check stating from first element and compares it with
			// remaining element.
			// Second loop gets 1 less iteration every time as its initialization value
			// depends on i.

			for (int j = i + 1; j < words.length; j++) {

				// boolean is provides to check if values in third loop is swapped or not.
				// flag is set basically for comparing and swaping "abcd" and "abc" as third
				// inner loop does not take care for that scenario.

				boolean flag = false;

				// length of both words at i-th and j-th are stored in x and y place.
				int x = words[i].length();
				int y = words[j].length();
				int temp;

				// check if x is smaller or y and assigned temp to smaller value.
				if (x > y) {
					temp = y;
				} else {
					temp = x;

				}

				// temp is used as condition as it has smallest length to avoid null point
				// exception
				// Third loop runs for number char present in string (smaller string).
				// For ex) compairing "abc" and "abcde" third loop will for 3 times.
				for (int k = 0; k < temp; k++) {

					// Unicode value of char at k-th place is stored in value_i and value_j
					// variable.

					int value_i = (int) words[i].charAt(k);
					int value_j = (int) words[j].charAt(k);

					// compare value of char at k-th place for i-th string vs j-th string.
					// if value of i is higher than swap and break out of third loop.
					// if value of j is higer than elements are already sorted so break out of loop.
					// else chars are equal so continue loop.
					if (value_i > value_j) {
						String t = words[i];
						words[i] = words[j];
						words[j] = t;
						flag = true;
						break;
					} else if (value_i < value_j) {
						flag = true;
						break;
					} else {
						continue;
					}
				}

				// this checks if flag is false so elements are not sorted yet as flag should be
				// true
				// if elements are sorted as per third loop.
				// we also need to check if (x>y) "abcd (x=4)" is before "abc (y=3)" to perform
				// swap or elements are already sorted.
				if (!flag && x > y) {
					String t = words[i];
					words[i] = words[j];
					words[j] = t;

				}

			}

		}
		// print array
		System.out.println("My Algorithm :" + Arrays.toString(words));
	}

}
