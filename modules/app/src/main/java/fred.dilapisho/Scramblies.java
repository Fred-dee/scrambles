package fred.dilapisho;

import java.util.ArrayList;
import java.util.List;

public class Scramblies {
	public static boolean scramble(String str1, String str2) {
		final List<Character> matches = new ArrayList<>();
		str1.chars().forEachOrdered(
				charInStr1 -> {
					if (str2.indexOf((char) charInStr1) != -1 && !matches.contains((char) charInStr1)) {
						matches.add((char) charInStr1);
					}
				}
		);
		return matches.size() == str2.length();
	}
}
