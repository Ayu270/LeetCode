int prefixCount(char** words, int wordsSize, char* pref) {
    int len = strlen(pref), count = 0;
    for (int i = 0; i < wordsSize; i++) {
        if (strncmp(words[i], pref, len) == 0)
            count++;
    }
    return count;
}