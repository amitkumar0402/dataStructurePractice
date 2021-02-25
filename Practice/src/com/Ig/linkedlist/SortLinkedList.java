package com.Ig.linkedlist;

public class SortLinkedList {
   ListNode head = null;
   ListNode sortedMerge(ListNode first, ListNode second){
      ListNode result = null;
      if(first== null){
         return second;
      }
      if(second == null){
         return first;
      }
      if(first.value<= second.value){
         result = first;
         result.next = sortedMerge(first.next,second);
      }else{
         result = second;
         result.next = sortedMerge(first, second.next);
      }
     return result;
   }
   ListNode mergeSort(ListNode node){
      if(node == null || node.next == null){
         return node;
      }

      ListNode middle = findMiddle(node);

      ListNode middleNext = middle.next;
      middle.next = null;

      ListNode first = mergeSort(node);
      ListNode second = mergeSort(middleNext);

      return sortedMerge(first,second);

   }

   public static ListNode findMiddle(ListNode node) {
      if(node == null){
         return node;
      }
      ListNode slow = node,fast = node;
      while(fast.next!= null && fast.next.next!= null){
         slow = slow.next;
         fast = fast.next;
      }
      return slow;
   }

   // # insert new value to linked list using insert method
   void insert(int new_data)
   {  //Allocate new node
      ListNode new_node = new ListNode(new_data);

      new_node.next = head;
      //Append the new node at the end of the linked list
      head = new_node;
   }


   void printList(ListNode headref)
   {
      while (headref != null) {
         System.out.print(headref.value + " ");
         headref = headref.next;
      }
   }

   public static void main(String[] args)
   {

      SortLinkedList list = new SortLinkedList();
      list.insert(4);
      list.insert(2);
      list.insert(8);
      list.insert(1);
      list.insert(6);
      list.insert(3);
      list.insert(7);


      list.head = list.mergeSort(list.head);
      System.out.print("\n Sorted Linked List is: \n");
      list.printList(list.head);
   }
}

