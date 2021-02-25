package com.Ig.tree;

public class MaximumPathSum {

   public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
      System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));

      root.left.left = new TreeNode(1);
      root.left.right = new TreeNode(3);
      root.right.left = new TreeNode(5);
      root.right.right = new TreeNode(6);
      root.right.left.left = new TreeNode(7);
      root.right.left.right = new TreeNode(8);
      root.right.right.left = new TreeNode(9);
      System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));

      root = new TreeNode(-1);
      root.left = new TreeNode(-3);
      System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
   }

   private static int globalMaximum;

   public static int findMaximumPathSum(TreeNode root) {
      globalMaximum = Integer.MIN_VALUE;
      findMaximumPathSumRecursive(root);
      return globalMaximum;

   }

   public static int findMaximumPathSumRecursive(TreeNode root) {
      if (root == null)
         return 0;

      int maximumSumLeft = findMaximumPathSumRecursive(root.left);
      int maximumSumRight = findMaximumPathSumRecursive(root.right);
      maximumSumLeft = Math.max(maximumSumLeft, 0);
      maximumSumRight = Math.max(maximumSumRight, 0);

      int localMaximum = maximumSumLeft + maximumSumRight + root.val;

      globalMaximum = Math.max(globalMaximum, localMaximum);

      return Math.max(maximumSumLeft, maximumSumRight) + root.val;


   }

}
