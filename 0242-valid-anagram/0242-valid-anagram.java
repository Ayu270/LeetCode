class Solution {
    public boolean isAnagram(String s, String t) {
        int fs [] = new int [26];
        for(char c: s.toCharArray()){
            fs[c-'a']++;
        }
        for(char c: t.toCharArray()){
            fs[c-'a']--;
        }
        for(int i=0; i<26; i++){
            if(fs[i]!=0)
              return false;
        }
        return true;
    }
}