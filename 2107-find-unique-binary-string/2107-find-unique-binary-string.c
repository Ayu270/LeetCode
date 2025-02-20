char *findDifferentBinaryString(char **nums, int numsSize) {
    char *result = (char *)malloc((numsSize + 1) * sizeof(char));
    result[numsSize] = '\0';

    for (int i = 0; i < numsSize; i++) {
        result[i] = (nums[i][i] == '0') ? '1' : '0';  
    }

    return result;
}