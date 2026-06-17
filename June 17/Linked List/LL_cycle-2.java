public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
        return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: detect cycle
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        if(slow==fast){
            ListNode st=head;
            while(st!=slow){
                slow=slow.next;
                st=st.next;
            }
            return st;
        }
    }
        return null;
    }
}