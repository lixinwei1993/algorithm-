package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
Objective : Given an string and a dic­tio­nary of words, 
find out if the input string can be bro­ken into a space-separated 
sequence of one or more dictionary words.
Example:
dictionary = ["I" , "have", "Jain", "Sumit", "am", "this", "dog"]
String = "IamSumit"
Output: "I am Sumit"
String ="thisisadog"
Output : String can't be broken
 */
public class WordBreak {
	
	public static void main(String[] args) {
		String[] dictionary = {"I" , "have", "Jain", "Sumit", "am", "this", "dog"};
		String s = "this is dog";
		String s1 = "I";
		String s2 = "Idog";
		
		wordBreak(s, dictionary);
		wordBreak(s1, dictionary);
		wordBreak(s2, dictionary);
	}

	public static void wordBreak(String word, String[] dictionary) {
		List<String> path = new ArrayList<>();
		
		if(!wordBreak(word, 0, dictionary, path))
			System.out.println("String can't be broken");
			
	}
	
	public static boolean wordBreak(String word, int begin, String[] dictionary, List<String> path) {
		if(begin == word.length()) {
			for(String s : path)
				System.out.print(s + " ");
			System.out.println();
			
			return true;
		} else {
			for(String s : dictionary) {
				if(isMatched(s, word, begin)) {
					path.add(s);
					return wordBreak(word,  begin + s.length(), dictionary, path); 
				}
			}
			
			return false;
		}
		
	}
	
	public static boolean isMatched(String s, String word, int begin) {
		if(s.length() > word.length() - begin)
			return false;
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) != word.charAt(begin + i))
				return false;
		}
		
		return true;
	}
	
}
