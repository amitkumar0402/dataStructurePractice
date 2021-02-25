package com.Ig.linkedlist;

public class ListNode {
   int value;

   public int getValue() {
      return value;
   }

   public void setValue(int value) {
      this.value = value;
   }

   public ListNode getNext() {
      return next;
   }

   public void setNext(ListNode next) {
      this.next = next;
   }

   ListNode next;

   ListNode(int value) {
      this.value = value;
   }
}
