package org.example.removeDuplicatesFromSortedListII;

public class Solution {

    public class ListNode {

      int val;

      ListNode next;

      ListNode() {}

      ListNode(int val) { this.val = val; }

      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode currentNode = head;

        ListNode prev = null;

        boolean deleteCurrentNode = false;

        while (currentNode != null){

            while(currentNode.next != null && currentNode.val == currentNode.next.val){
                deleteCurrentNode = true;
                currentNode.next = currentNode.next.next;
            }

            if(deleteCurrentNode){
                if(prev != null){
                    prev.next = currentNode.next;
                } else {
                    head = currentNode.next;
                }

                deleteCurrentNode = false;
            } else {
                prev = currentNode;
            }

            currentNode = currentNode.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = solution.new ListNode(1);
        head.next = solution.new ListNode(2);
        head.next.next = solution.new ListNode(3);
        head.next.next.next = solution.new ListNode(3);
        head.next.next.next.next = solution.new ListNode(4);
        head.next.next.next.next.next = solution.new ListNode(4);
        head.next.next.next.next.next.next = solution.new ListNode(5);

        ListNode result = solution.deleteDuplicates(head);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
