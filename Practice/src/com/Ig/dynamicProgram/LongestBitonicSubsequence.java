package com.Ig.dynamicProgram;

public class LongestBitonicSubsequence {

   private int findLBSLength(int[] nums) {
      Integer[][] lds = new Integer[nums.length][nums.length+1];
      Integer[][] ldsRev = new Integer[nums.length][nums.length+1];
      int maxLength =0;
      for(int i=0;i<nums.length;i++){
         int c1= findlbsLengthRecu(lds,nums,i,-1);
         int c2 = findlbsLengthRecuRev(ldsRev,nums,i,-1);
         maxLength = Math.max(maxLength, c1+c2-1);

      }
      return maxLength;
   }

   private int findlbsLengthRecuRev(Integer[][] lds, int[] nums, int currentindex, int previousindex) {
      if(currentindex<0){
         return 0;
      }
      int c1=0;
      if(lds[currentindex][previousindex+1]== null){
         if(previousindex ==-1 || nums[currentindex]<nums[previousindex])
            c1 = 1 + findlbsLengthRecuRev(lds,nums,currentindex-1,currentindex);
         int c2= findlbsLengthRecuRev(lds,nums,currentindex-1,previousindex);
         lds[currentindex][previousindex+1] = Math.max(c1,c2);
         }
         return lds[currentindex][previousindex+1];

   }

   private int findlbsLengthRecu(Integer[][] lds, int[] nums, int currentindex, int previousindex) {
      if(currentindex == nums.length){
         return 0;
      }
      int c1=0;
      if(lds[currentindex][previousindex+1]== null){
         if(previousindex ==-1 || nums[currentindex]>nums[previousindex])
            c1 = 1 + findlbsLengthRecu(lds,nums,currentindex+1,currentindex);
         int c2= findlbsLengthRecu(lds,nums,currentindex+1,previousindex);
         lds[currentindex][previousindex+1] = Math.max(c1,c2);
      }
      return lds[currentindex][previousindex+1];

   }

   public static void main(String[] args) {
      LongestBitonicSubsequence lbs = new LongestBitonicSubsequence();
      int[] nums = {4,2,3,6,10,1,12};
      System.out.println(lbs.findLBSLength(nums));
      nums = new int[]{4,2,5,9,7,6,10,3,1};
      System.out.println(lbs.findLBSLength(nums));
   }
}


