package org.example.rotateList;

public class Solution {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode currentNode = head;

        int nodeCount = 1;

        while(currentNode.next != null){
            currentNode = currentNode.next;
            nodeCount++;
        }

        ListNode tailNode = currentNode;

        int i = nodeCount - k % nodeCount;

        currentNode = head;

        for(int j = 1; j < i; j++){
            currentNode = currentNode.next;
        }

        tailNode.next = head;

        head = currentNode.next;

        currentNode.next = null;

        return head;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = solution.new ListNode(1);
        head.next = solution.new ListNode(2);
        head.next.next = solution.new ListNode(3);
        head.next.next.next = solution.new ListNode(4);
        head.next.next.next.next = solution.new ListNode(5);

        ListNode result = solution.rotateRight(head, 2);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
