class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int a1 [] = new int [n];
        int a2 [] = new int [n];
        a1[0]=nums[0];
        a2[0]=nums[1];
        int c1 = 0;
        int c2 = 0;
        for(int i=2; i<n; i++){
            if(a1[c1]>a2[c2]){
                c1++;
                a1[c1]=nums[i];
            } else {
                c2++;
                a2[c2]=nums[i];
            }
        }
        int c=0;
        for(int i=c1+1; i<n; i++){
            a1[i]=a2[c];
            c++;
        }
        return a1;
    }
}