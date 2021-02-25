package com.Ig.linkedlist;

public class PalindromicLinkedList {

   public static boolean isPalindrome(ListNode head) {
      if(head == null && head.next == null)
         return true;
      ListNode slow = head,fast=head;
      while(fast!=null && fast.next!=null){
         fast =fast.next.next;
         slow = slow.next;
      }

      ListNode headOfSecondHalf = reverse(slow);
      ListNode copyOfSecondHalf = headOfSecondHalf;

      while(head!= null && headOfSecondHalf!= null){
         if(head.value != headOfSecondHalf.value){
            break;
         }
         head = head.next;
         headOfSecondHalf = headOfSecondHalf.next;

      }

      reverse(copyOfSecondHalf);
      if(head == null || headOfSecondHalf == null)
         return true;
      return false;
   }

   private static ListNode reverse(ListNode slow) {
      ListNode current = slow;
      ListNode previous = null;
      ListNode next =null;
            while(current!=null){
               next =current.next;
               current.next = previous;
               previous = current;
               current = next;
            }
            return previous;
   }
   public static void main(String[] args) {
      ListNode head = new ListNode(2);
      head.next = new ListNode(4);
      head.next.next = new ListNode(6);
      head.next.next.next = new ListNode(4);
      head.next.next.next.next = new ListNode(2);
      System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

      head.next.next.next.next.next = new ListNode(2);
      System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
   }
}

