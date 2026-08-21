class Solution {
    public boolean isHappy(int n) {
        if(n==1)
          return true;
        // if(n<10)
        //   return false;
        while(n!=1 && n!=4){
            int n1 =n;
            n=0;
            while(n1!=0){
                int l = n1%10;
                n1 = n1/10;
                n=n+(l*l);
            }
            if(n==1)
              return true;
        }
        return false;
    }
}