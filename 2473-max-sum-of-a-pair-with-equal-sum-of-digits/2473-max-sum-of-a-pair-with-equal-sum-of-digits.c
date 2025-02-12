#define MAX_DIGIT_SUM 82  // Max sum of digits (99999 → 9+9+9+9+9 = 45)

int digitSum(int num) {
    int sum = 0;
    while (num > 0) {
        sum += num % 10;
        num /= 10;
    }
    return sum;
}

int maximumSum(int* nums, int numsSize) {
    int map[MAX_DIGIT_SUM] = {0};
    int maxPairSum = -1;

    for (int i = 0; i < numsSize; i++) {
        int sum = digitSum(nums[i]);

        if (map[sum] > 0) { 
            int pairSum = map[sum] + nums[i];
            if (pairSum > maxPairSum) {
                maxPairSum = pairSum;
            }
        }

        if (nums[i] > map[sum]) {
            map[sum] = nums[i];
        }
    }

    return maxPairSum;
}