#define MAX_HAPPY_STRINGS 59049

char **happyStrings;
int c = 0;  

void generateHappyStrings(int n, char *x, int l) {
    if (l == n) {
        happyStrings[c] = (char *)malloc((n + 1) * sizeof(char));  
        strcpy(happyStrings[c], x);
        c++;
        return;
    }

    for (char ch = 'a'; ch <= 'c'; ch++) {
        if (l == 0 || x[l - 1] != ch) {
            x[l] = ch;
            x[l + 1] = '\0';
            generateHappyStrings(n, x, l + 1);
        }
    }
}

char *getHappyString(int n, int k) {
    c = 0;  
    happyStrings = (char **)malloc(MAX_HAPPY_STRINGS * sizeof(char *));

    char temp[11] = ""; 
    generateHappyStrings(n, temp, 0);

    char *result = (k <= c) ? strdup(happyStrings[k - 1]) : strdup("");     
    for (int i = 0; i < c; i++) {
        free(happyStrings[i]);
    }
    free(happyStrings);

    return result;
}