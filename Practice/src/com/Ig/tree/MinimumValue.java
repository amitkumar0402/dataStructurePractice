package com.Ig.tree;

public class MinimumValue {

   public static int findMin(Node root) {

      if(root == null)
         return -1;

      while(root.getLeftChild() != null){
         root = root.getLeftChild();
      }
      return root.getData();

   }

   public static void main(String args[]) {

      BinarySearchTree bsT = new BinarySearchTree();
      bsT.add(6);
      bsT.add(4);
      bsT.add(9);
      bsT.add(5);
      bsT.add(2);
      bsT.add(8);
      bsT.add(12);
      bsT.add(10);
      bsT.add(14);

      System.out.println(findMin(bsT.getRoot()));

   }
}

