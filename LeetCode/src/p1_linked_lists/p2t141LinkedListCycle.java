package p1_linked_lists;

import java.util.HashSet;

public class p2t141LinkedListCycle {
    public static void main(String[] args) {

    }
    public boolean hasCycle(ListNode head) {
        if (head==null) return false;
        ListNode node=head;
        HashSet<ListNode> set=new HashSet<>();
        while (node.next!=null){
            if(set.contains(node)){
                return true;
            }else set.add(node);
            node=node.next;
        }
        return false;

    }
}
