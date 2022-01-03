package LinkedList;

public class OddEvenList {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
     public ListNode oddEvenList(ListNode head) {
          if(head == null) return null;
          ListNode newHead = new ListNode();

          ListNode oddHead = head;

          newHead.next = oddHead;

          ListNode evenHead = head.next;

          ListNode connectPlace = evenHead;

          while(evenHead != null && evenHead.next != null){
               oddHead.next = evenHead.next;
               oddHead = oddHead.next;
               evenHead.next = oddHead.next;
               evenHead = evenHead.next;
          }
          oddHead.next = connectPlace;
          return newHead.next;
     }
}
