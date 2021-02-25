package com.Ig.string;

public class BackSpaceCompareStringsEquality {
   // Function to compare the two strings
   public static boolean compare(StringBuilder s,
                                 StringBuilder t) {
      int ps, pt, i;

      // The index of character in string
      // which would be removed when
      // backspace is encountered
      ps = -1;

      for(i = 0; i < s.length(); i++)
      {

         // Checks if a backspace is encountered
         // or not. In case the first character
         // is #, no change in string takes place
         if (s.charAt(i) == '#' && ps != -1)
            ps -= 1;

            // The character after the # is added
            // after the character at position rem_ind1
         else if (s.charAt(i) != '#')
         {
            s.setCharAt(ps + 1, s.charAt(i));
            ps += 1;
         }
      }

      pt = -1;

      for(i = 0; i < t.length(); i++)
      {

         // Checks if a backspace is
         // encountered or not
         if (t.charAt(i) == '#' && pt != -1)
            pt -= 1;

         else if (t.charAt(i) != '#')
         {
            t.setCharAt(pt + 1, t.charAt(i));

            pt += 1;
         }
      }

      // Check if the value of rem_ind1 and
      // rem_ind2 is same, if not then it
      // means they have different length
      if (pt != ps)
         return false;

         // Check if resultant strings are empty
      else if (ps == -1 && pt == -1)
         return true;

         // Check if each character in the
         // resultant string is same
      else
      {
         for(i = 0; i <= pt; i++)
         {
            if (s.charAt(i) != t.charAt(i))
               return false;
         }
         return true;
      }
   }

   // Driver code
   public static void main(String[] args)
   {

      // Initialise two strings
      StringBuilder s = new StringBuilder("geee#e#ks");
      StringBuilder t = new StringBuilder("gee##eeks");

      if (compare(s, t))
         System.out.print("True");
      else
         System.out.print("False");
   }
}