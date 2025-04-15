package org.example.reverseNodesInKGroup;

public class Solution {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode reverseKGroup(ListNode head, int k) {

        if(head == null || head.next == null || k == 0 || k == 1){
            return head;
        }

        ListNode groupEnd = head;

        ListNode currentNode = head;

        ListNode prev = null;

        ListNode newHead = null;

        while(currentNode != null){

            groupEnd = currentNode;

            int n = 1;

            while(currentNode != null && n < k){
                currentNode = currentNode.next;
                n++;
            }

            if(n < k || currentNode == null){
                return newHead;
            } else {
                if(prev != null){
                    prev.next = currentNode;
                }

                if(newHead == null){
                    newHead = currentNode;
                }

                currentNode = groupEnd;

                for(int i = 1; i <= k; i++){
                    ListNode nextNode = currentNode.next;
                    currentNode.next = prev;
                    prev = currentNode;
                    currentNode = nextNode;
                }

                prev = groupEnd;
            }

            prev.next = currentNode;
        }

        return newHead;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = solution.new ListNode(1);
        head.next = solution.new ListNode(2);
        head.next.next = solution.new ListNode(3);
        head.next.next.next = solution.new ListNode(4);
//        head.next.next.next.next = solution.new ListNode(5);

        int k = 2;

        ListNode result = solution.reverseKGroup(head, k);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
