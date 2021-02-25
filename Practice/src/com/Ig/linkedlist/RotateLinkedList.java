package com.Ig.linkedlist;

public class RotateLinkedList {

   public static ListNode rotate(ListNode head, int rotations) {
      if(head == null ||head.next == null || rotations<=0){
         return head;
      }

      ListNode listNodeLinkedList = head;
      int listLength = 1;
      while(listNodeLinkedList!=null){
         listNodeLinkedList = listNodeLinkedList.next;
         listLength++;
      }

      listNodeLinkedList.next = head;
      rotations %= listLength;
      int skipLength = listLength - rotations;
      ListNode listNodeOfRotatedLinkedList = head;
      for(int i=0;i<skipLength;i++){
         listNodeOfRotatedLinkedList= listNodeOfRotatedLinkedList.next;
      }
      head = listNodeOfRotatedLinkedList.next;
      listNodeOfRotatedLinkedList.next = null;
      return head;


   }

   }
