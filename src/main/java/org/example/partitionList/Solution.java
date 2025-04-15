package org.example.partitionList;

public class Solution {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode partition(ListNode head, int x) {
        ListNode currentNode = head;

        ListNode currentMovedNode = null;

        ListNode prev = null;

        ListNode startNode = null;

        ListNode newHeadNode = null;

        while(currentNode != null){
            if(currentNode.val >= x){
                if(prev != null){
                    prev.next = currentNode.next;
                }

                if(currentMovedNode == null){
                    startNode = currentNode;
                    currentMovedNode = currentNode;
                } else {
                    currentMovedNode.next = currentNode;
                    currentMovedNode = currentNode;
                }

            } else {
                if(newHeadNode == null){
                    newHeadNode = currentNode;
                }
                prev = currentNode;
            }

            currentNode = currentNode.next;
        }

        if(currentMovedNode != null){
            currentMovedNode.next = null;
        }

        if(prev == null){
            return startNode;
        } else {
            prev.next = startNode;
            return newHeadNode;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = solution.new ListNode(1);
        head.next = solution.new ListNode(4);
        head.next.next = solution.new ListNode(3);
        head.next.next.next = solution.new ListNode(2);
        head.next.next.next.next = solution.new ListNode(5);
        head.next.next.next.next.next = solution.new ListNode(2);
        ListNode partitionedHead = solution.partition(head, 3);
        ListNode current = partitionedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
