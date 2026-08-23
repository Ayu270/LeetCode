class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap <Integer, Integer> freq = new HashMap <>();
        for(int i: nums){
            freq.put(i, freq.getOrDefault(i,0)+1);
        }
        int max =0;
        for(Map.Entry<Integer, Integer> entry: freq.entrySet()){
            max=Math.max(max,entry.getValue());
        }
        int s = 0;
        for(Map.Entry<Integer, Integer> entry: freq.entrySet()){
            if(entry.getValue()==max)
              s=s+entry.getValue();
        }
        return s;
    }
}