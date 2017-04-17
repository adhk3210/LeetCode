/*
 * Longest Palindromic Substring
 * Difficulty: Medium
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 */
public class LongestPalindrome {
	public String longestPalindrome(String s) {
		int start = 0, end = 0;
		
		for (int i = 0; i < s.length(); i++) {
			int len = Math.max(expandAroundCenter(s, i, i), expandAroundCenter(s, i, i + 1));
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2 + 1;
			}
		}
		
		return s.substring(start, end);
	}
	
	private int expandAroundCenter(String s, int l, int r) {
		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}
		return r - l - 1;
	}
}
