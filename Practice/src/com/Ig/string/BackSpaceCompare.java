package com.Ig.string;

public class BackSpaceCompare {
   public static void main(String[] args) {
      System.out.println(BackSpaceCompare.compare("xy#z", "xzz#"));
      System.out.println(BackSpaceCompare.compare("xy#z", "xyz#"));
      System.out.println(BackSpaceCompare.compare("xp#", "xyz##"));
      System.out.println(BackSpaceCompare.compare("xywrrmp", "xywrrmu#p"));
   }

   private static boolean compare(String s1, String s2) {

      int index1 = s1.length() -1;
      int index2= s2.length() -1;
      while(index1>=0 && index2>=0){
         int i1= getNextValidCharacter(s1,index1);
         int i2 = getNextValidCharacter(s2,index2);

         if(i1<0 && i2<0){
            return true;
         }
         if(i1<0 || i2<0){
            return false;
         }
         if(s1.charAt(i1) != s2.charAt(i2)){
            return false;
         }
          index1 = i1-1;
          index2 = i2-1;
          }
      return true;
   }

   public static int getNextValidCharacter(String s1, int index1) {
      int backspaceCount =0;
      while(index1>=0){
         if(s1.charAt(index1) == '#'){
            backspaceCount++;
            }
            else if(backspaceCount>0){
            backspaceCount--;
         }
         else{
            break;
         }
         index1--;
      }
      return index1;
   }
}
