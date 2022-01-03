package LinkedList;

import java.util.ArrayList;
import java.util.Collections;

public class MergeKLists {


      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

     public ListNode mergeKLists(ListNode[] lists) {
          //create a list of node vals, sort it, then create a new list and add the values;
          //return the list;
          ArrayList<Integer> list = new ArrayList<>();
          int i = 0;
          while (i < lists.length) {
               if (lists[i] == null) {
                    i++;
               } else {

                    list.add(lists[i].val);
                    if (lists[i].next == null) {
                         i++;
                    } else {

                         lists[i] = lists[i].next;

                    }
               }

          }

          Collections.sort(list);
          System.out.print(list);

          ListNode dummyHead = new ListNode();
          ListNode head = new ListNode();
          head.next = dummyHead;
          Collections.sort(list);
          if(lists.length == 0)return null;
          if(list.isEmpty())return null;
          for(int j = 0; j < list.size(); j++){
               dummyHead.val = list.get(j);
               if(j == list.size() - 1)break;
               dummyHead.next = new ListNode();
               dummyHead = dummyHead.next;
          }
          return head.next;
     }

}
