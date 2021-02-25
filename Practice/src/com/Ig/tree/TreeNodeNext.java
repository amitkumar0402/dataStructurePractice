package com.Ig.tree;

public class TreeNodeNext {
   int val;
   TreeNodeNext left;
   TreeNodeNext right;
   TreeNodeNext next;

   TreeNodeNext(int x) {
      val = x;
      left = right = next = null;
   }

   // tree traversal using 'next' pointer
   public void printTree() {
      TreeNodeNext current = this;
      System.out.print("Traversal using 'next' pointer: ");
      while (current != null) {
         System.out.print(current.val + " -> ");
         current = current.next;
      }
      System.out.print("null");
   }

   // level order traversal using 'next' pointer
   public void printLevelOrder() {
      TreeNodeNext nextLevelRoot = this;
      while (nextLevelRoot != null) {
         TreeNodeNext current = nextLevelRoot;
         nextLevelRoot = null;
         while (current != null) {
            System.out.print(current.val + " -> ");
            if (nextLevelRoot == null) {
               if (current.left != null)
                  nextLevelRoot = current.left;
               else if (current.right != null)
                  nextLevelRoot = current.right;
            }
            current = current.next;
         }
         System.out.print("null");
         System.out.println();
      }
   }
}
