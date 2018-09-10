package lintCode;

import java.util.TreeSet;

/**
 * 
 * @author CavieLee
 *
 */
public class IsUniqueSolution {
	public boolean isUnique(String str) {
		if (str == null) {
			return false;
		}

		boolean[] letters = new boolean[256];

		for (int i = 0; i < str.length(); i++) {
			if (letters[str.charAt(i)]) {
				return false;
			} else {
				letters[str.charAt(i)] = true;
			}
		}

		return true;
	}
	public boolean isUnique_1(String str) {
		if (str == null) {
			return false;
		}

		TreeSet<Character> tree = new TreeSet<>();

		for (int i = 0; i < str.length(); i++) {
			if (tree.contains(str.charAt(i))) {
				return false;
			} else {
				tree.add(str.charAt(i));
			}
		}

		return true;
	}
}
