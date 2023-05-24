package Task_21;

public class Main {
    public static void main(String[] args) {
//        int[] list1 = {1, 2, 4};
//        int[] list2 = {1, 3, 4};
//        int[] list1 = {};
//        int[] list2 = {};
//        int[] list1 = {};
//        int[] list2 = {0};

        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));

//        ListNode listNode1 = arrayToNode(list1);
//        ListNode listNode2 = arrayToNode(list2);
        printNode(listNode1);
        System.out.println();
        printNode(listNode2);
        System.out.println();

        System.out.println();
        Solution solution = new Solution();
        ListNode res = solution.mergeTwoLists(listNode1, listNode2);
//        ListNode res = solution.mergeTwoLists(null, null);
        printNode(res);

    }


    static void printNode(ListNode listNode) {
        if (listNode == null) return;
        ListNode current = listNode;
        while (true) {
            System.out.println(current.val);
            current = current.next;
            if (current == null) break;
        }
    }


    //Перевод заданного массива в список
    static ListNode arrayToNode(int[] array) {
        ListNode res = new ListNode();
        //Устанавливаем указатель на текущий node
        ListNode pointer = res;
        for (int i = 0; i < array.length; i++) {
            pointer.val = array[i];
            //Если не достигли конца массива
            if (i != array.length - 1) {
                //Детаем следующий node
                pointer.next = new ListNode();
                //Устанавливаем указатель на следующий node
                pointer = pointer.next;
            }
        }
        return res;
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //Проверка на null списков
        if (list1 == null && list2 == null) return null;
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        //Если хотя-бы один из списков не пустой.
        //Создаем новый узел в итоговом листе и устанавливаем на него указатель
        ListNode result = new ListNode();
        ListNode resPointer = result;
        //Создаем указатели на каждый из исходных листов
        ListNode pointer1 = list1;
        ListNode pointer2 = list2;
        //Пока не закончатся оба списка
        while (true) {
            //Если закончился или не существует второй список или
            //если в обоих списках есть элементы
            if ((pointer1 != null && pointer2 == null) ||
                    ((pointer1 != null && pointer2 != null) && pointer1.val <= pointer2.val)) {
                //Записываем в итоговый список значение с первого списка
                resPointer.val = pointer1.val;
                //Переводим указатель первого списка на следующий элемент
                pointer1 = pointer1.next;
            }
            //Если закончился или не существует первый список или
            //если в обоих списках есть элементы
            else if ((pointer1 == null && pointer2 != null) ||
                    ((pointer1 != null && pointer2 != null) && pointer1.val > pointer2.val)) {
                //Записываем в итоговый список значение со второго списка
                resPointer.val = pointer2.val;
                //Переводим указатель второго списка на следующий элемент
                pointer2 = pointer2.next;
            }
            //Если еще не перебраны до конца оба списка
            if(pointer1 != null || pointer2 != null){
                //Создаем новый узел в итоговом листе
                resPointer.next = new ListNode();
                //Переводим указатель итогового списка на новый узел
                resPointer = resPointer.next;
            }
            else break;
        }
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


/**
 * 21. Merge Two Sorted Lists
 * You are given the heads of two sorted linked lists list1 and list2.
 * <p>
 * Merge the two lists in a one sorted list.
 * The list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Return the head of the merged linked list.
 * Example 1:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * <p>
 * Example 2:
 * Input: list1 = [], list2 = []
 * Output: []
 * <p>
 * Example 3:
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
