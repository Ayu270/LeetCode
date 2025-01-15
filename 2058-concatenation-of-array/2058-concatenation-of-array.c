/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* getConcatenation(int* nums, int numsSize, int* returnSize) {
    *returnSize = 2 * numsSize;
    int* result = (int*)malloc((*returnSize) * sizeof(int));
    for (int i = 0; i < numsSize; i++) {
        result[i] = nums[i];          
        result[i + numsSize] = nums[i]; 
    }
    return result;
}