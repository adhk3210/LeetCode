/*
 * ZigZag Conversion
 * Difficulty: Easy
 * The String "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * 
 * P A H N
 * APLSIIG
 * Y I R
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows.
 */
public class ZigZagConversion {
	public String convert(String s, int numRows) {
		StringBuilder[] sb = new StringBuilder[numRows];
		for (int i = 0; i < sb.length; i++) sb[i] = new StringBuilder();
		
		int i = 0;
		while (i < s.length()) {
			for (int j = 0; j < sb.length && i < s.length(); j++) sb[j].append(s.charAt(i++));
			for (int j = sb.length - 2; j > 0 && i < s.length(); j--) sb[j].append(s.charAt(i++));
		}
		
		for (i = 1; i < sb.length; i++) sb[0].append(sb[i]);
		
		return sb[0].toString();
	}
}
