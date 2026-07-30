class Solution {
    public boolean isPalindrome(String s) {
        int st = 0;
        int l = s.length()-1;
        while(st <= l){
            char cf = s.charAt(st);
            char cl = s.charAt(l);
            if(!Character.isLetterOrDigit(cf)){
                st++;
            } else if(!Character.isLetterOrDigit(cl)){
                l--;
            } else {
                if(Character.toLowerCase(cf) != Character.toLowerCase(cl)){
                    return false;
                }
                st++;
                l--;
            }
        }
        return true;
    }
}