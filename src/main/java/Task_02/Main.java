package Task_02;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        int[] l1 = new int[]{2,4,3};
//        int[] l2 = new int[]{5,6,4};
//        int[] l1 = new int[]{0};
//        int[] l2 = new int[]{0};
        int[] l1 = new int[]{9};
        int[] l2 = new int[]{1,9,9,9,9,9,9,9,9,9};

        ListNode listNode1 = arrayToNode(l1);
        ListNode listNode2 = arrayToNode(l2);
        printNode(listNode1);
        System.out.println();
        printNode(listNode2);
        System.out.println();

        Solution solution = new Solution();
        ListNode res = solution.addTwoNumbers(listNode1, listNode2);
        printNode(res);
    }

    public static void printNode(ListNode listNode) {
        ListNode current = listNode;
        while (true) {
            System.out.println(current.val);
            current = current.next;
            if (current == null) break;
        }
    }

    public static ListNode arrayToNode(int[] array) {
        ListNode res = new ListNode();
        ListNode pointer = res;
        int counter = 0;
        while (true) {
            pointer.val = array[counter];
            counter++;
            if (counter == array.length) break;
            pointer.next = new ListNode();
            pointer = pointer.next;
        }
        return res;
    }

}


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode pointerRes = result;
        ListNode pointer1 = l1;
        ListNode pointer2 = l2;
        int val1 = pointer1.val;
        int val2 = pointer2.val;
        int memory = 0;
        while (true) {
            pointerRes.val = (val1 + val2 + memory) % 10;
            memory = (val1 + val2 + memory) / 10;
            if (pointer1.next == null && pointer2.next == null) {
                if (memory != 0) {
                    pointerRes.next = new ListNode();
                    pointerRes = pointerRes.next;
                    pointerRes.val = memory;
                }
                break;
            }
            pointerRes.next = new ListNode();
            pointerRes = pointerRes.next;
            if (pointer1.next != null) {
                pointer1 = pointer1.next;
                val1 = pointer1.val;
            }
            else val1 = 0;
            if (pointer2.next != null) {
                pointer2 = pointer2.next;
                val2 = pointer2.val;
            }
            else val2 = 0;
        }
        return result;
    }
}


/**
 * 2. Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * <p>
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 * <p>
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * <p>
 * <p>
 * Constraints:
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 */



