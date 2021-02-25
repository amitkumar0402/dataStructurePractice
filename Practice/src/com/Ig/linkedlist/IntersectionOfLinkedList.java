package com.Ig.linkedlist;

public class IntersectionOfLinkedList {
  static  ListNode head1, head2;

  int getIntersectionofList(ListNode head1, ListNode head2){
     int length1 = getCount(head1);
     int length2 = getCount(head2);

     if(length1>length2){
        int d = length1 -length2;
        return intersectionofList(d, head1, head2);
     }
     else{
        int d = length2 - length1;
        return intersectionofList(d,head2, head1);
     }

  }

   private int intersectionofList(int d, ListNode head1, ListNode head2) {
     ListNode node1 = head1;
     ListNode node2 = head2;
     for(int i=0;i<d;i++){
        if(node1==null){
           return -1;
        }
        node1 = node1.next;
     }
     while(node1!= null && node2!= null){
        if(node1.value == node2.value){
           return node1.getValue();
        }
        node1 = node1.next;
        node2 = node2.next;
     }
     return -1;

   }

   private int getCount(ListNode head1) {
     ListNode node = head1;
     int count =0;
     while(head1!= null){
        count++;
        head1 = head1.next;
     }
     return count;
   }


   public static void main(String[] args)
   {
      IntersectionOfLinkedList list = new IntersectionOfLinkedList();

      // creating first linked list
      list.head1 = new ListNode(3);
      list.head1.next = new ListNode(6);
      list.head1.next.next = new ListNode(9);
      list.head1.next.next.next = new ListNode(15);
      list.head1.next.next.next.next = new ListNode(30);

      // creating second linked list
      list.head2 = new ListNode(10);
      list.head2.next = new ListNode(15);
      list.head2.next.next = new ListNode(30);

      System.out.println("The node of intersection is " + list.getIntersectionofList(head1, head2));
   }
}


