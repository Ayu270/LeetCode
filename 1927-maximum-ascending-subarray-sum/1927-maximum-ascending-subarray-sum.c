int maxAscendingSum(int* nums, int numsSize) {
     int maxSum = nums[0];
    int currentSum = nums[0];

    for (int i = 1; i < numsSize; ++i) {
        if (nums[i] > nums[i - 1]) {
            currentSum += nums[i];
        } else {
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            currentSum = nums[i];
        }
    }

    if (currentSum > maxSum) {
        maxSum = currentSum;
    }

    return maxSum;
}