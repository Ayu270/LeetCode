char* removeOccurrences(char* s, char* part) {
    int len_s = strlen(s);
    int len_p = strlen(part);
    char* stack = (char*)malloc(len_s + 1);
    int top = 0;
    for (int i = 0; s[i] != '\0'; i++) {
        stack[top++] = s[i];
        if (top >= len_p && strncmp(stack + top - len_p, part, len_p) == 0) {
            top -= len_p; 
        }
    }
    stack[top] = '\0'; 
    return stack;
}