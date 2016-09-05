import tree.Node;

import java.util.ArrayList;

/**
 * 链表操作
 * Created by MarsWang on 2016/9/3.
 */
public class MyList {

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(5);
        head2.next.next.next = new ListNode(6);
        printList(Merge(head, head2));


    }

    public static ListNode Merge(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null)
            return null;
        else if(list1 != null && list2 == null)
            return list2;
        else if(list2 != null && list1 == null)
            return list1;
        ListNode head;
        if(list1.value <= list2.value){
            head = list1;
            list1 =list1.next;
        }else {
            head = list2;
            list2 = list2.next;
        }
        ListNode temp = head;
        while(list1 != null && list2 != null){
            if(list1.value <= list2.value){
                temp.next = list1;
                list1 = list1.next;
            }else{
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if(list1 != null)
            temp.next = list1;
        if(list2 != null)
            temp.next = list2;
        return head;

    }

    /**
     * 打印链表
     * @param head
     */
    private static void printList(ListNode head) {
        if(head == null) {
            System.out.println("List is NULL!");
            return;
        }
        while (head != null){
            System.out.print(head.value);
            if(head.next != null)
                System.out.print("->");
            head = head.next;
        }
        System.out.println();
    }

    /**
     * 翻转单链表
     * @param head 链表头结点
     * @return 返回心头节点
     */
    public static ListNode reverseList( ListNode head){
        ListNode pre = null;
        ListNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 反转双向链表
     * @param head
     * @return
     */
    public static ListNode reverseDoubleList(ListNode head){
        ListNode pre = null;
        ListNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}
