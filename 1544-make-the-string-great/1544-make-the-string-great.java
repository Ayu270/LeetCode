class Solution {
    public String makeGood(String s) {
        Stack <Character> s1 =new Stack <>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if (!s1.isEmpty() && Math.abs(s1.peek() - c) == 32) {
                s1.pop();
            } else {
                s1.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!s1.isEmpty()) {
            sb.append(s1.pop());
        }        
        return sb.reverse().toString();
    }
}