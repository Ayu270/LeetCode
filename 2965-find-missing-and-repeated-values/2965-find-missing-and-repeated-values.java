class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        HashSet <Integer> freq = new HashSet<>();
        int n [] = new int [2];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(!freq.contains(grid[i][j])){
                    freq.add(grid[i][j]);
                } else {
                    n[0]=grid[i][j];
                }
            }
        }
        int s = grid.length*grid.length;
        for(int i=1; i<=s; i++){
            if(!freq.contains(i))
               n[1]=i;
        }        
        return n;
    }
}