package com.Ig.linkedlist;

import java.util.HashSet;

public class UnionAndIntersectionOfList {

   public static <T> SinglyLinkedList<T> unionWithHashing(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
      SinglyLinkedList<T> result = new SinglyLinkedList<T>();
      SinglyLinkedList<T>.Node current = list1.getHeadNode();

      HashSet<T> visited = new HashSet<>();

      while(current != null){
         if(!visited.contains(current.data)){
            result.insertAtHead(current.data);
            visited.add(current.data);
         }
         current = current.nextNode;
      }
      current = list2.getHeadNode();

      while(current != null){
         if(!visited.contains(current.data)){
            result.insertAtHead(current.data);
            visited.add(current.data);
         }
         current = current.nextNode;
      }

      return result;

   }

   public static <T> SinglyLinkedList<T> intersectionWithHashing(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
      SinglyLinkedList<T> result = new SinglyLinkedList<T>();
      SinglyLinkedList<T>.Node current = list1.getHeadNode();

      HashSet<T> visited = new HashSet<>();

      while(current != null){
         if(!visited.contains(current.data)){
            visited.add(current.data);
         }
         current = current.nextNode;
      }
      current = list2.getHeadNode();

      while(current != null){
         if(visited.contains(current.data)){
            result.insertAtHead(current.data);
            visited.remove(current.data);
         }
         current = current.nextNode;
      }
      return result;
      }


   public static void main(String args[]) {
      SinglyLinkedList<Integer> list1 = new SinglyLinkedList<Integer>();
      for (int i = 7; i > 3; i--) {
         list1.insertAtHead(i);
      }
      System.out.print("1st ");
      list1.printList();
      SinglyLinkedList<Integer> list2 = new SinglyLinkedList<Integer>();
      for (int i = 0; i < 5; i++) {
         list2.insertAtHead(i);
      }
      System.out.print("2nd ");
      list2.printList();
      System.out.print("After Intersection ");
      intersectionWithHashing(list1, list2).printList();
      System.out.print("After Union ");
      unionWithHashing(list1, list2).printList();
   }

}
