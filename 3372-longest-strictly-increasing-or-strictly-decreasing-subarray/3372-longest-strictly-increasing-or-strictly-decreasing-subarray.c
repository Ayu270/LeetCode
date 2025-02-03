int longestMonotonicSubarray(int* nums, int numsSize) {
     if (numsSize == 0) return 0;

    int maxLength = 1;
    int incLength = 1;
    int decLength = 1;

    for (int i = 1; i < numsSize; ++i) {
        if (nums[i] > nums[i - 1]) {
            incLength++;
            decLength = 1;
        } else if (nums[i] < nums[i - 1]) {
            decLength++;
            incLength = 1;
        } else {
            incLength = 1;
            decLength = 1;
        }
        if (incLength > maxLength) maxLength = incLength;
        if (decLength > maxLength) maxLength = decLength;
    }

    return maxLength;
}