bool areAlmostEqual(char* s1, char* s2) {
    int n = strlen(s1);
    int first = -1, second = -1;
    for (int i = 0; i < n; i++) {
        if (s1[i] != s2[i]) {
            if (first == -1) {
                first = i;  
            } else if (second == -1) {
                second = i;  
            } else {
                return false;  
            }
        }
    }
    if (first == -1) return true; 
    if (second == -1) return false; 
    return s1[first] == s2[second] && s1[second] == s2[first];
}