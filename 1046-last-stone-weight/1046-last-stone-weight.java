class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : stones){
            pq.offer(i);
        }
        while(pq.size() > 1){
            int i = pq.poll(); // 1st largest
            int j = pq.poll(); // 2nd largest

            if(i != j){
                pq.offer(i-j);
            }
        }
        return pq.size() == 0 ? 0 : pq.poll();
    }
}