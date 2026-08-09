class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int p=0;
        for(int i=1; i<prices.length; i++){
            min = Math.min(min, prices[i]);
            int p1= prices[i]-min;
            p = Math.max(p,p1);
        }
        return p;
    }
}