
/*
 * Difficulty: Hard
 * 
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list. K is a positive
 * integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k,
 * then left-out nodes in the end should remain as is. You may not alter the values in the nodes, only nodes themselves
 * may be changed. Only constant memory is allowed.
 */
public class ReverseNodesInKGroup {
	class ListNode {
		int val;
		ListNode next;
		ListNode (int x) {val = x;}
	}
	
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode curr = head;
		int count = 0;
		while (curr != null && count < k) {
			curr = curr.next;
			count++;
		}
		if (count == k) {
			curr = reverseKGroup(curr, k);
			while (count-- > 0) {
				ListNode tmp = head.next;
				head.next = curr;
				curr = head;
				head = tmp;
			}
			head = curr;
		}
		return head;
	}
}