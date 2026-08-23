class Solution {
    public int maxArea(int[] height) {
        int l =0;
        int r = height.length-1;
        int w = 0;
        while(l<r){
            int a = (r-l)*Math.min(height[l],height[r]);
            w = Math.max(w,a);
            if(height[l]<height[r])
              l++;
            else 
              r--;
        }
        return w;
    }
}

        // int maxArea =0;
        // int left =0;
        // int right =height.length-1;
        // while(left<right){
        //     int tempArea=(right-left)*Math.min(height[left], height[right]);
        //     maxArea=Math.max(maxArea, tempArea);
        //     if(height[left]<height[right])
        //       left++;
        //     else
        //       right--;
        // }
        // return maxArea;