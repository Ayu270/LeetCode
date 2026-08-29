class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int v [][] = new int [n][2];
        for(int i=0; i<n; i++){
            v[i][0]=nums[i];
            v[i][1]=i;
        }
        Arrays.sort(v ,(a,b)-> Integer.compare(a[0], b[0]));
        int i=0;
        int j=0;
        while(i<n){
            List<Integer> temp = new ArrayList<>();
            temp.add(v[i][1]);
            j=j+1;
            while(j<n && v[j][0] <= v[j-1][0]+ limit){
                temp.add(v[j][1]);
                j++;
            }
            Collections.sort(temp);
            int k=i;
            for(int in :temp){
                nums[in]=v[k][0];
                k++;
            }
            i=j;
        }
        return nums;
        // int s =0;
        // int i=1;
        // while(i<nums.length){
        //     if(nums[s]>nums[i] ){
        //         if( nums[s]-nums[i] <= limit){
        //         int t= nums[s];
        //         nums[s]=nums[i];
        //         nums[i]=t;
        //         }          
        //     }
        //     s++;
        //     i++;
        // }
        // return nums;
    }
}