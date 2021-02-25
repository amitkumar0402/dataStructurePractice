package com.Ig.tree;

import java.util.ArrayList;
import java.util.List;

public class AllPathsForSum {
   public static void main(String[] args) {
      TreeNode root = new TreeNode(12);
      root.left = new TreeNode(7);
      root.right = new TreeNode(1);
      root.left.left = new TreeNode(4);
      root.right.left = new TreeNode(10);
      root.right.right = new TreeNode(5);
      int sum = 23;
      List<List<Integer>> result = AllPathsForSum.findPaths(root, sum);
      System.out.println("Tree paths with sum " + sum + ": " + result);
   }

   public static List<List<Integer>> findPaths(TreeNode root, int sum) {
      List<List<Integer>> allPath = new ArrayList<>();
      List<Integer> currentPath = new ArrayList<>();
      findPathRecursive(root, sum, allPath,currentPath);
      return allPath;
      }

   public static void findPathRecursive(TreeNode root, int sum, List<List<Integer>> allPath, List<Integer> currentPath) {
      if(root == null)
         return;

      currentPath.add(root.val);

      if(root.val== sum && root.left == null && root.right ==null) {
         allPath.add(new ArrayList<Integer>(currentPath));
      }
      else{
         findPathRecursive(root.left, sum- root.val, allPath, currentPath);

         findPathRecursive(root.right, sum -root.val,allPath, currentPath);
   }

   currentPath.remove(currentPath.size()-1);
}

}
