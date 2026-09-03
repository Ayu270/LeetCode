class Solution {
    public boolean uniformArray(int[] nums1) {
        int minOdd= Integer.MAX_VALUE;
        for(int i=0; i<nums1.length; i++){
            if((nums1[i]&1) == 1)
              minOdd = Math.min(minOdd,nums1[i]);
        }
        if(minOdd == Integer.MAX_VALUE)
          return true;
        for(int i= 0 ; i<nums1.length; i++){
            if((nums1[i]&1) == 0 && nums1[i]<= minOdd)
              return false;
        }
        return true;
    }
}