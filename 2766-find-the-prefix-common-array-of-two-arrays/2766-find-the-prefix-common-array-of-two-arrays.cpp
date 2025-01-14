class Solution {
public:
    vector<int> findThePrefixCommonArray(vector<int>& A, vector<int>& B) {
        unordered_map<int , int>m;
        int n=A.size();
        vector<int>ans(n,0);
        for(int i=0;i<n;i++){
            if(i>0)ans[i]+=ans[i-1];
            m[A[i]]++;
            m[B[i]]++;
            
            if(m[A[i]]==2 && A[i] != B[i]) ans[i]++;
            if(m[B[i]]==2) ans[i]++;
        }

        return ans;

    }
};