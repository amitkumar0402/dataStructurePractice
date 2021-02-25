package com.Ig.tree;

public class IdenticalBinaryTrees {

   public static boolean areIdentical(Node root1, Node root2){
      if(root1 == null && root2 == null){
         return true;
      }
      return root1.getData() == root2.getData()
            && areIdentical(root1.getLeftChild(), root2.getLeftChild())
            && areIdentical(root1.getRightChild(), root2.getRightChild());
   }

   public static void main(String[] args)
   {
      BinarySearchTree tree = new BinarySearchTree();
      tree.add(6);
      tree.add(3);
      tree.add(9);
      tree.add(2);
      tree.add(5);
      tree.add(8);
      tree.add(8);
      tree.add(12);
      tree.add(10);
      tree.add(14);

      BinarySearchTree tree2 = new BinarySearchTree();
      tree2.add(6);
      tree2.add(4);
      tree2.add(9);
      tree2.add(2);
      tree2.add(5);
      tree2.add(8);
      tree2.add(8);
      tree2.add(12);
      tree2.add(10);
      tree2.add(14);

      boolean identical = areIdentical(tree.getRoot(), tree2.getRoot());
      System.out.println("Identical Binary Trees ="+identical);
   }
}



