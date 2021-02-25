package com.Ig.tree;


import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewOfBinaryTree {
   // Recursive function to do a pre-order traversal of the tree and fill the map
   // Here node has 'dist' horizontal distance from the root of the
   // tree and level represent level of the node
   public static void printTop(Nodes root, int dist, int level,
                               Map<Integer, NodeLevel<Integer, Integer>> map)
   {
      // base case: empty tree
      if (root == null) {
         return;
      }

      // if current level is less than maximum level seen so far
      // for the same horizontal distance or horizontal distance
      // is seen for the first time, update the map
      if (!map.containsKey(dist) || level < map.get(dist).second) {
         // update value and level for current distance
         map.put(dist, NodeLevel.of(root.data, level));
      }

      // recur for left subtree by decreasing horizontal distance and
      // increasing level by 1
      printTop(root.left, dist - 1, level + 1, map);

      // recur for right subtree by increasing both level and
      // horizontal distance by 1
      printTop(root.right, dist + 1, level + 1, map);
   }

   // Function to print the top view of given binary tree
   public static void printTop(Nodes root)
   {
      // create a TreeMap where
      // key -> relative horizontal distance of the node from root node and
      // value -> pair containing node's value and its level
      Map<Integer, NodeLevel<Integer, Integer>> map = new TreeMap<>();

      // do pre-order traversal of the tree and fill the map
      printTop(root, 0, 0, map);

      // traverse the TreeMap and print top view
      for (NodeLevel<Integer, Integer> it: map.values()) {
         System.out.print(it.first + " ");
      }
   }

   public static void main(String[] args)
   {
      Nodes root = new Nodes(1);
      root.left = new Nodes(2);
      root.right = new Nodes(3);
      root.left.right = new Nodes(4);
      root.right.left = new Nodes(5);
      root.right.right = new Nodes(6);
      root.right.left.left = new Nodes(7);
      root.right.left.right = new Nodes(8);

      printTop(root);
   }
}