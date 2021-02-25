package com.Ig.linkedlist;

import java.util.HashSet;

public class RemoveDuplicates {
   public static <V> void removeDuplicatesWithHashing(SinglyLinkedList<V> list) {
      SinglyLinkedList<V>.Node previous = list.getHeadNode();
      SinglyLinkedList<V>.Node current = list.getHeadNode();

      HashSet<V> visited = new HashSet<>();
      if (!list.isEmpty() && current.nextNode != null) {
         while (current != null) {
            if (visited.contains(current.data)) {
               visited.add(current.data);
               previous.nextNode = current.nextNode;
               current = current.nextNode;
            } else {
               visited.add(current.data);
               previous = current;
               current = current.nextNode;

            }
         }


      }
   }

   public static void main(String args[]) {
      SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>(); // created linked list

      for(int i = 1; i <= 8; i++) {
         list.insertAtHead(i);      // inserting data in list
      }
      //inserting duplicates
      list.insertAtHead(2);
      list.insertAtHead(4);
      list.insertAtHead(1);

      System.out.println("List before deleting duplicates from list :");
      list.printList();
      removeDuplicatesWithHashing(list); // calling removeDuplicatesWithHashing function
      System.out.println("List after deleting duplicates from list :");
      list.printList();
   }
}

