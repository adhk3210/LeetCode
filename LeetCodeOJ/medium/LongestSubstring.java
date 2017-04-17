import java.util.HashMap;
import java.util.Map;

/*
 * Longest Substring Without Repeating Characters
 * Difficulty: Medium
 * Given a string, find the length of the longest substring without repeating characters.
 */
public class LongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		int ans = 0;
		
		Map<Character, Integer> map = new HashMap<>();
		for (int j = 0, i = 0; j < s.length(); j++) {
			if (map.containsKey(s.charAt(j))) {i = Math.max(i, map.get(s.charAt(j)) + 1);}
			ans = Math.max(ans, j - i + 1);
			map.put(s.charAt(j), j);
		}
		
		return ans;
	}
}
