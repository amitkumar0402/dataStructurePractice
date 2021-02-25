package com.Ig.tree;

public class VerticalSumOfBinaryTreeUsingDLL {

   public static void verticalSumDLL(Nodes root){

      ListNode lnode = new ListNode(0);

      verticalSumDllUtil(root, lnode);

      while(lnode.prev!= null){
         lnode = lnode.prev;
      }

      while(lnode!=null){
         System.out.println(lnode.val+"");
         lnode = lnode.next;
      }
   }

   public static void verticalSumDllUtil(Nodes root, ListNode lnode) {

      if(root == null){
         return;
      }

      lnode.val = lnode.val + root.data;

      if(root.left!=null){
         if(lnode.prev == null){
            lnode.prev = new ListNode(0);
            lnode.prev.next = lnode;
         }
         verticalSumDllUtil(root.left, lnode.prev);
      }

      if(root.right!=null){
         if(lnode.next == null){
            lnode.next = new ListNode(0);
            lnode.next.prev = lnode;
         }
         verticalSumDllUtil(root.right, lnode.next);
      }
   }

   public static void main(String[] args)
   {
      // Let us construct the tree shown above
      Nodes root = new Nodes(1);
      root.left = new Nodes(2);
      root.right = new Nodes(3);
      root.left.left = new Nodes(4);
      root.left.right = new Nodes(5);
      root.right.left = new Nodes(6);
      root.right.right = new Nodes(7);

      System.out.println("Vertical Sums are");
      verticalSumDLL(root);
   }


}
