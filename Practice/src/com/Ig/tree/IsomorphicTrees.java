package com.Ig.tree;

public class IsomorphicTrees {
   /* Given a binary tree, print its nodes in reverse level order */
  public static boolean isIsomorphic(Nodes n1, Nodes n2)
   {
      // Both roots are NULL, trees isomorphic by definition
      if (n1 == null && n2 == null)
         return true;

      // Exactly one of the n1 and n2 is NULL, trees not isomorphic
      if (n1 == null || n2 == null)
         return false;

      if (n1.data != n2.data)
         return false;

      // There are two possible cases for n1 and n2 to be isomorphic
      // Case 1: The subtrees rooted at these nodes have NOT been
      // "Flipped".
      // Both of these subtrees have to be isomorphic.
      // Case 2: The subtrees rooted at these nodes have been "Flipped"
      return ((isIsomorphic(n1.left, n2.left) &&
            isIsomorphic(n1.right, n2.right)))
            || ((isIsomorphic(n1.left, n2.right) &&
            isIsomorphic(n1.right, n2.left)));
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

      Nodes root2 = new Nodes(1);
      root2.left = new Nodes(3);
      root2.right = new Nodes(2);
      root2.right.left = new Nodes(4);
      root2.right.right = new Nodes(5);
      root2.left.right = new Nodes(6);
      root2.right.right.left = new Nodes(8);
      root2.right.right.right = new Nodes(7);

      if (isIsomorphic(root, root2) == true)
         System.out.println("Yes");
      else
         System.out.println("No");
   }
}


