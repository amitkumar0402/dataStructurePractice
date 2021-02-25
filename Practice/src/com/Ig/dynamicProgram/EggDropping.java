package com.Ig.dynamicProgram;

public class EggDropping {
   public static int eggDrop(int eggs, int floors){
      if(eggs<=0){
         return 0;
      }
      if(floors==1 || floors==0)
         return floors;

      if(eggs ==1)
         return floors;

      int min = Integer.MAX_VALUE;
      int res;

      for(int x=1;x<=floors;x++){
         res= Math.max(eggDrop(eggs-1,x-1), eggDrop(eggs,floors-x));
         if(res<min)
            min=res;
      }
      return min+1;
   }

   public static int eggDropRec(int eggs, int floors, int [][] lookupTable) {
      if(eggs<=0){
         return 0;
      }
      if(floors==1 || floors==0)
         return floors;

      if(eggs ==1)
         return floors;

      lookupTable[eggs][floors] = Integer.MAX_VALUE;
      int res;

      for(int x=1;x<=floors;x++){
         res =1+ Math.max(eggDropRec(eggs-1,x-1,lookupTable),eggDropRec(eggs,floors-x,lookupTable));
         if(res<lookupTable[eggs][floors])
            lookupTable[eggs][floors] = res;
      }
      return lookupTable[eggs][floors];

   }

   public static int eggDropRecursive(int eggs, int floors)
   {
      int [][] lookupTable;
      lookupTable = new int[eggs + 1][];
      for (int i = 0; i < eggs + 1; i++) {
         lookupTable[i] = new int[floors + 1];
         for (int j = 0; j < floors + 1; j++)
            lookupTable[i][j] = 0;
      }
      return eggDropRec(eggs, floors, lookupTable);
   }


   public static void main(String args[])
   {
      int eggs = 2, floors = 10;
      System.out.println("With " + eggs + " eggs and " + floors + " floors, the minimum number of trials in worst are: " + eggDrop(eggs, floors));
      System.out.println("With " + eggs + " eggs and " + floors + " floors, the minimum number of trials in worst are: " + eggDropRecursive(eggs, floors));
   }

}
