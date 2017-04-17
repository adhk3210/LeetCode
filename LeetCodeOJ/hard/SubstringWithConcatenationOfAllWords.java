import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Difficulty: Hard
 * 
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of
 * substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 */
public class SubstringWithConcatenationOfAllWords {
	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> ans = new ArrayList<>();
		int len = words[0].length();
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String str : words) map.put(str, (map.containsKey(str)) ? map.get(str) + 1 : 1);
		
		for (int i = 0; i <= s.length() - len * words.length; i++) {
			Map<String, Integer> copy = new HashMap<>(map);
			for (int j = 0; j < words.length; j++) {
				String str = s.substring(i + j * len, i + j * len + len);
				if (copy.containsKey(str)) {
					int count = copy.get(str);
					if (count == 1) copy.remove(str);
					else copy.put(str, count - 1);
				} else break;
			}
			if (copy.isEmpty()) ans.add(i);
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		String[] words = {"foo", "bar"};
		System.out.println(findSubstring("barfoothefoobarman", words));
	}
}