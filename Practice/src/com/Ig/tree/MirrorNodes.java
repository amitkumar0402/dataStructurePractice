package com.Ig.tree;

public class MirrorNodes {
   public static void mirrorBinaryTree(Node root){
      if( root == null){
         return;
      }

      if(root.getLeftChild()!= null)
         mirrorBinaryTree(root.getLeftChild());
      if(root.getRightChild()!= null)
         mirrorBinaryTree(root.getRightChild());

      Node temp = root.getLeftChild();
      root.setLeftChild(root.getRightChild());
      root.setRightChild(temp);
   }

   public static void main(String[] args){
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
      bsT.printTree(bsT.getRoot());
      mirrorBinaryTree(bsT.getRoot());
      bsT.printTree(bsT.getRoot());
   }
}
