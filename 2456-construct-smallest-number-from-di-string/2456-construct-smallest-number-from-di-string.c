char* smallestNumber(char* pattern) {
    int n = strlen(pattern);
    char* re = (char*)malloc((n + 2) * sizeof(char));
    int in = 0;
    int stack[n + 2];  
    int top = -1;       

    for (int i = 0; i <= n; i++) {
        stack[++top] = i + 1; 
        
        if (i == n || pattern[i] == 'I') {  
            while (top >= 0) {
                in += sprintf(re + in, "%d", stack[top--]);
            }
        }
    }

    re[in] = '\0';
    return re;
}