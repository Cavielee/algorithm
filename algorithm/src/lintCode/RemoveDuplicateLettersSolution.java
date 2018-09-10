package lintCode;

import java.util.Collections;
import java.util.TreeSet;

public class RemoveDuplicateLettersSolution {
	public static void main(String[] args) {
		String s = new RemoveDuplicateLettersSolution().removeDuplicateLetters("abbc");
		System.out.println(s);
	}
	public String removeDuplicateLetters(String s) {
		if(s == null) {
			return null;
		}
		String result = "";
        StringBuilder sb = new StringBuilder();
        TreeSet<Character> tree = new TreeSet<>();
        
        // Ìí¼Ó
        for(int i = 0; i < s.length(); i++) {
        	tree.add(s.charAt(i));
        }
        while(!tree.isEmpty()){
        	sb.append(tree.pollFirst());
        }
        
        return sb.toString();
    }
}
