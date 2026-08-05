class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Set<Integer>> adj = new ArrayList<>();
        List<Integer> elseres = new ArrayList<>();
        for(int i=0;i<n;i++){
            elseres.add(i);
        }
        HashSet<Integer> sus = new HashSet<>();
        for(int i=0;i<n;i++){
            adj.add(new HashSet<>());
        }
        for(int[] num:invocations){
            adj.get(num[0]).add(num[1]);
        }
        int[] vis = new int[n];
        Arrays.fill(vis,-1);
        Queue<Integer> q = new LinkedList<>();
        sus.add(k);
        q.offer(k);
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int nb:adj.get(cur)){
                if(vis[nb]==-1){
                    sus.add(nb);
                    q.offer(nb);
                    vis[nb] = 1;
                }
            }
        }
        HashSet<Integer> nonsus = new HashSet<>();
        for(int i=0;i<n;i++){
            if(!sus.contains(i)) nonsus.add(i);
        }
        System.out.println(nonsus);
        boolean flag = false;
        Set<Integer> res = new HashSet<>();
        Set<Integer> badTargets = new HashSet<>();
        for (int j:nonsus) {
            badTargets.addAll(adj.get(j)); 
        }
        for (int i:sus) {
            if (!badTargets.contains(i)) {
                res.add(i);
            }
        }
        if(res.size()!=sus.size()) return elseres;
        List<Integer> ans = new ArrayList<>();
        System.out.println(res);
        for(int i=0;i<n;i++){
            if(!res.contains(i)){
                ans.add(i);
            }
        }
        return ans;
    }
}