/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
typedef struct pair{
    int value;
    int index;
} pair;

int comp1(const void *a, const void *b) {
    return (*(pair **)a)->value - (*(pair **)b)->value;
}

int comp2(const void *a, const void *b) {
    return (*(int *)a - *(int *)b);
}
int* lexicographicallySmallestArray(int* nums, int numsSize, int limit, int* returnSize) {
    *returnSize = numsSize;
    pair* initial_list[numsSize];

    for(int i = 0; i < numsSize; i++){
        initial_list[i] = (pair*)malloc(sizeof(pair));
        initial_list[i]->value = nums[i];
        initial_list[i]->index = i;
    }
    qsort(initial_list, numsSize, sizeof(pair*), comp1);

    int end_counter = 1;
    int start_counter = 0;
    for(int i = 0; i < numsSize - 1; i++){
        if(abs(initial_list[i+1]->value - initial_list[i]->value) <= limit){
            end_counter++;
        } else if((end_counter - start_counter) > 1){
            int* indexes = malloc((end_counter - start_counter) * sizeof(int));
            for(int j = start_counter; j < end_counter; j++){
                indexes[j - start_counter] = initial_list[j]->index;
            }
            qsort(indexes, end_counter - start_counter, sizeof(int), comp2);
            for(int j = start_counter; j < end_counter; j++){
                initial_list[j]->index = indexes[j - start_counter];
            }
            free(indexes);
            start_counter = end_counter;
            end_counter++;
        } else {
            start_counter = end_counter;
            end_counter++;
        }
    }
    int* indexes = malloc((end_counter - start_counter) * sizeof(int));
    for(int j = start_counter; j < end_counter; j++){
        indexes[j - start_counter] = initial_list[j]->index;
    }
    qsort(indexes, end_counter - start_counter, sizeof(int), comp2);
    for(int j = start_counter; j < end_counter; j++){
        initial_list[j]->index = indexes[j - start_counter];
    }
    free(indexes);

    int* result = malloc((*returnSize) * sizeof(int));
    for(int i = 0; i < numsSize; i++){
        result[initial_list[i]->index] = initial_list[i]->value; 
    }
    for(int i = 0; i < numsSize; i++){
        free(initial_list[i]);
    }   
    return result;
}