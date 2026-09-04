class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap <Character,Integer> map = new HashMap<>();
        HashMap <Character,Integer> map1 = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            char c1 = t.charAt(i);
            if(!map.containsKey(c))
                map.put(c,i);
            if(!map1.containsKey(c1))
                map1.put(c1,i);
            if(!map.get(c).equals(map1.get(c1)))
               return false;
        }
        return true;
    }
}