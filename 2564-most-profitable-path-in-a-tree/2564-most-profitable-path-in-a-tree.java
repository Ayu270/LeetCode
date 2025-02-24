class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        List<Integer>[] tree = new ArrayList[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();
        
        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }
        
        int[] bobTime = new int[n];
        Arrays.fill(bobTime, Integer.MAX_VALUE);
        
        dfsBob(bob, -1, 0, bobTime, tree);
        
        return dfsAlice(0, -1, 0, 0, bobTime, amount, tree);
    }
    
    private boolean dfsBob(int node, int parent, int time, int[] bobTime, List<Integer>[] tree) {
        bobTime[node] = time;
        if (node == 0) return true;
        
        for (int neighbor : tree[node]) {
            if (neighbor != parent && dfsBob(neighbor, node, time + 1, bobTime, tree)) {
                return true;
            }
        }
        
        bobTime[node] = Integer.MAX_VALUE;
        return false;
    }
    
    private int dfsAlice(int node, int parent, int time, int income, int[] bobTime, int[] amount, List<Integer>[] tree) {
        if (time < bobTime[node]) {
            income += amount[node];
        } else if (time == bobTime[node]) {
            income += amount[node] / 2;
        }
        
        int maxProfit = Integer.MIN_VALUE;
        boolean isLeaf = true;
        
        for (int neighbor : tree[node]) {
            if (neighbor != parent) {
                isLeaf = false;
                maxProfit = Math.max(maxProfit, dfsAlice(neighbor, node, time + 1, income, bobTime, amount, tree));
            }
        }
        
        return isLeaf ? income : maxProfit;
    }
} 