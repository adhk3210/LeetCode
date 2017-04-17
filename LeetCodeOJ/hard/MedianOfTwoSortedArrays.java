/* Median of Two Sorted Arrays
 * Difficulty: Hard
 * Find the median of the two sorted arrays. The overall run time complexity should O(log(m + n)).
 */
public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length, n = nums2.length;
		
		if (m > n) return findMedianSortedArrays(nums2, nums1);
		
		int k = (m + n - 1) / 2;
		int l = 0, r = Math.min(k, m);
		while (l < r) {
			int i = (l + r) / 2;
			int j = k - l;
			if (nums1[i] < nums2[j]) {
				l = i + 1;
			} else {
				r = i;
			}
		}
		
		int a = Math.max((l > 0) ? nums1[l - 1] : Integer.MIN_VALUE, (k - l >= 0) ? nums2[k - l] : Integer.MIN_VALUE);
		if ((m + n) % 2 == 1) return (double) a;
		
		int b = Math.min((l < m) ? nums1[l] : Integer.MAX_VALUE, (k - l + 1) < n ? nums2[k - l + 1] : Integer.MAX_VALUE);
		return (a + b) / 2.0;
	}
}
