package LinkedList;

import java.util.HashSet;

public class LinkedListCycle {

      class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }
     public boolean hasCycle(ListNode head) {

          if(head == null || head.next == null)
          {
               return false;
          }

          HashSet<ListNode> explorer = new HashSet();
          ListNode curr = head;
          while(curr != null){
               if (explorer.contains(curr)){
                    return true;
               }
               explorer.add(curr);
               curr = curr.next;
          }
          return false;

     }

}
