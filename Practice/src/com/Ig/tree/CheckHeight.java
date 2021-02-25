package com.Ig.tree;

public class CheckHeight {

   public static int findHeight(Node root){
       if(root == null)
          return -1;
       else{
          return 1 + Math.max(findHeight(root.getLeftChild()), findHeight(root.getRightChild()));
       }
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

      System.out.println(findHeight(bsT.getRoot()));

   }
}
