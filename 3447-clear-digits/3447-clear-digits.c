char* clearDigits(char* s) {
    int n = strlen(s);
    char* stack = (char*)malloc(n + 1); 
    int top = -1; 
    for (int i = 0; i < n; ++i) {
        if (isdigit(s[i])) {
            if (top >= 0) {
                top--; 
            }
        } else {
            stack[++top] = s[i];
        }
    }

    stack[++top] = '\0'; 
    return stack;
}