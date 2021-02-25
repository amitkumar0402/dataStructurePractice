package com.Ig.tree;

public class MaximumPathSumFromRootToLeaf {

   private static int maxNo;
   private static TreeNode targetLeaf = null;

   public static void main(String args[])
   {
      TreeNode tree = new TreeNode(10);
     // tree.root = new Node(10);
      tree.left = new TreeNode(-2);
      tree.right = new TreeNode(7);
      tree.left.left = new TreeNode(8);
      tree.left.right = new TreeNode(-4);
   //   maxNo = Integer.MIN_VALUE;
      System.out.println("Following are the nodes "
            + "on maximum sum path");
      int sum = MaximumPathSumFromRootToLeaf.maxSumPath(tree);
      System.out.println("");
      System.out.println("Sum of nodes is : " + sum);
   }

   public static int maxSumPath(TreeNode tree) {
      if(tree == null)
         return 0;

      maxNo = Integer.MIN_VALUE;
      getLeafNode(tree,0);
      buildMaxPath(tree, targetLeaf);
      return maxNo;
   }

   public static boolean buildMaxPath(TreeNode node, TreeNode targetLeaf) {
    if(node == null)
       return false;

    if(node == targetLeaf || buildMaxPath(node.left,targetLeaf)|| buildMaxPath(node.right, targetLeaf)){
       System.out.println(node.val + "");
       return true;

      }

      return false;



   }

   public static void getLeafNode(TreeNode node,  int currentSum) {
    if(node ==null)
       return;

      currentSum += node.val;

      if(node.left == null && node.right == null){
         if(currentSum> maxNo) {
            maxNo = currentSum;
            targetLeaf = node;
         }
   }

   getLeafNode(node.left,currentSum);
      getLeafNode(node.right, currentSum);
}


}
