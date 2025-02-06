int tupleSameProduct(int* nums, int numsSize) {
    int ans = 0;
    int* count = (int*)calloc(100000001, sizeof(int));
    for (int i = 0; i < numsSize; ++i) {
        for (int j = i + 1; j < numsSize; ++j) {
            int product = nums[i] * nums[j];
            ans += count[product] * 8;
            count[product]++;
        }
    }
    free(count); 
    return ans;
}