/*
 * Trapping Rain Water
 * Difficulty: Hard
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water
 * it is able to trap after raining.
 */
public class TrappingRainWater {
	public int trap(int[] height) {
		if (height.length < 3) return 0;
		
		int ans = 0;
		int l = 0, r = height.length - 1;
		
		while (l < r && height[l] <= height[l + 1]) l++;
		while (l < r && height[r] <= height[r - 1]) r--;
		
		while (l < r) {
			int left = height[l];
			int right = height[r];
			if (left <= right) {
				while (l < r && left >= height[++l]) ans += left - height[l];
			} else {
				while (l < r && right >= height[--r]) ans += right - height[r];
			}
		}
		
		return ans;
	}
}
