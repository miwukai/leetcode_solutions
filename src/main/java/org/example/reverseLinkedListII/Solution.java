package org.example.reverseLinkedListII;

public class Solution {

    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode currentNode = head;

        ListNode prev = null;

        ListNode preStartNode = null;

        ListNode startNode = null;

        int count = 1;

        while(currentNode != null){

            if(count < left){
                preStartNode = currentNode;
                currentNode = currentNode.next;
            } else if (count == left){
                startNode = currentNode;
                prev = currentNode;
                currentNode = currentNode.next;
            } else if (count > left && count <= right){
                ListNode nextNode = currentNode.next;
                currentNode.next = prev;
                prev = currentNode;
                currentNode = nextNode;

                if(count == right && preStartNode != null){
                    preStartNode.next = prev;
                }
            } else {
                break;
            }

            count++;
        }

        startNode.next = currentNode;

        return preStartNode == null ? prev : head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = solution.new ListNode(1);
        head.next = solution.new ListNode(2);
        head.next.next = solution.new ListNode(3);
//        head.next.next.next = solution.new ListNode(4);
//        head.next.next.next.next = solution.new ListNode(5);

        int left = 2;
        int right = 3;

        ListNode result = solution.reverseBetween(head, left, right);

        // Print the reversed linked list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
