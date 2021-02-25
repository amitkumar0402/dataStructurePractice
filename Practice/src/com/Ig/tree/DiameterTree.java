package com.Ig.tree;

public class DiameterTree {
   private static int treeDiameter =0;

   public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
      root.left.left = new TreeNode(4);
      root.right.left = new TreeNode(5);
      root.right.right = new TreeNode(6);
      System.out.println("Tree Diameter: " + DiameterTree.findDiameter(root));
      root.left.left = null;
      root.right.left.left = new TreeNode(7);
      root.right.left.right = new TreeNode(8);
      root.right.right.left = new TreeNode(9);
      root.right.left.right.left = new TreeNode(10);
      root.right.right.left.left = new TreeNode(11);
      System.out.println("Tree Diameter: " + DiameterTree.findDiameter(root));
   }

   public static int findDiameter(TreeNode root) {

      calculateHeight(root);
      return treeDiameter;

   }

   public static int calculateHeight(TreeNode root) {
      if(root == null)
         return 0;

      int leftTreeHeight = calculateHeight(root.left);
      int rightTreeHeight = calculateHeight(root.right);
      int maxHeight = leftTreeHeight + rightTreeHeight +1;

      treeDiameter = Math.max(treeDiameter, maxHeight);

      return Math.max(leftTreeHeight, rightTreeHeight) +1;


   }
}

