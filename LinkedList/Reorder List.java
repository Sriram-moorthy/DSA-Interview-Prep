/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
       ListNode fast = head , slow = head;
       while(fast != null && fast.next != null && fast.next.next != null){
        fast = fast.next.next;
        slow = slow.next;
       }

       ListNode prev = null , curr = slow.next;
       slow.next = null;
       while(curr != null){
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
       }

       ListNode firstHalf = head , secondHalf = prev;
       while(secondHalf != null){
        ListNode temp1 = firstHalf.next;
        ListNode temp2 = secondHalf.next;

        firstHalf.next = secondHalf;
        secondHalf.next = temp1;

        firstHalf = temp1;
        secondHalf = temp2;
       }
    }
    
}
