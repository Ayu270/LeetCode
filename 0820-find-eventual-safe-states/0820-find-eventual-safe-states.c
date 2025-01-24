/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int isSafe(int node, int** graph, int* graphColSize, int* state) {
    if (state[node] != 0) {
        return state[node] == 2;
    }

    state[node] = 1;
    for (int i = 0; i < graphColSize[node]; i++) {
        int neighbor = graph[node][i];
        if (!isSafe(neighbor, graph, graphColSize, state)) {
            return 0; 
        }
    }

    state[node] = 2;
    return 1;
}

int* eventualSafeNodes(int** graph, int graphSize, int* graphColSize, int* returnSize) {
    int* state = (int*)calloc(graphSize, sizeof(int)); // Track node states
    int* result = (int*)malloc(graphSize * sizeof(int)); // Store safe nodes
    int count = 0;

    for (int i = 0; i < graphSize; i++) {
        if (isSafe(i, graph, graphColSize, state)) {
            result[count++] = i;
        }
    }

    *returnSize = count;
    free(state); 
    return result;
}