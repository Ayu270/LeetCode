class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int a []= arr.clone();
        Arrays.sort(a);
        HashMap <Integer, Integer> rank = new HashMap <>();
        int r=1;
        for(int i=0; i<a.length; i++){
           if (!rank.containsKey(a[i])) {
                rank.put(a[i], r);
                r++;
            }
        }
        for(int i=0; i<a.length; i++){
            arr[i]=rank.get(arr[i]);
        }
        return arr;
    }
}