package p1_linked_lists;

import java.util.Stack;

public class p1t206ReverseLinkedList {
    public static void main(String[] args) {

    }
    public ListNode reverseList(ListNode head) {
        if (head==null) return null;
        Stack<ListNode> stack =new Stack<>();
        ListNode node=head;
        ListNode result;
        while (node.next!=null){
            stack.add(node);//previous node
            node=node.next;
        }
        result=node;
       while (!stack.empty()){
           node.next=stack.pop();
           node=node.next;
       }
       node.next=null;
       return result;

    }
}
