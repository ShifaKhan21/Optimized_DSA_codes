import java.util.*;

class ListNode {
    int val;
    ListNode next;
    
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LL_cycle_2 {
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
            if (slow == fast) {
                ListNode st = head;
                while (st != slow) {
                    slow = slow.next;
                    st = st.next;
                }
                return st;
            }
        }
        return null;
    }

    // Build linked list from array and create cycle at given position (-1 means no cycle)
    public ListNode buildList(int[] arr, int cyclePos) {
        if (arr.length == 0) return null;
        
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        ListNode cycleNode = null;
        
        if (cyclePos == 0) cycleNode = head;
        
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
            if (i == cyclePos) cycleNode = current;
        }
        
        // Create cycle
        if (cyclePos != -1) {
            current.next = cycleNode;
        }
        
        return head;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LL_cycle_2 solution = new LL_cycle_2();

        // Input number of nodes
        System.out.print("Enter number of nodes: ");
        int n = scanner.nextInt();

        // Input node values
        int[] values = new int[n];
        System.out.println("Enter " + n + " node values:");
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }

        // Input cycle position
        System.out.print("Enter cycle position (-1 for no cycle, 0-indexed): ");
        int cyclePos = scanner.nextInt();

        // Build linked list
        ListNode head = solution.buildList(values, cyclePos);

        // Detect cycle
        ListNode cycleStart = solution.detectCycle(head);

        // Display result
        if (cycleStart != null) {
            System.out.println("\nCycle detected at node with value: " + cycleStart.val);
        } else {
            System.out.println("\nNo cycle detected");
        }

        scanner.close();
    }
}
