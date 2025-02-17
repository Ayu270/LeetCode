int dfs(int freq[26]) {
    int sum = 0;
    
    for (int i = 0; i < 26; i++) {
        if (freq[i] > 0) {
            sum++;  
            
            freq[i]--;  
            sum += dfs(freq);  
            freq[i]++;
        }
    }
    return sum;
}

int numTilePossibilities(char* tiles) {
    int freq[26] = {0}; 
    
    for (int i = 0; tiles[i] != '\0'; i++) {
        freq[tiles[i] - 'A']++;
    }
    
    return dfs(freq); 
}
