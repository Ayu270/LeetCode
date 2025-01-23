long long gridGame(int** grid, int gridSize, int* gridColSize) {
    int n = gridColSize[0];
    long long* prefixTop = (long long*)calloc(n, sizeof(long long));
    long long* suffixTop = (long long*)calloc(n, sizeof(long long));
    long long* prefixBottom = (long long*)calloc(n, sizeof(long long));
    long long* suffixBottom = (long long*)calloc(n, sizeof(long long));

    prefixTop[0] = grid[0][0];
    prefixBottom[0] = grid[1][0];
    for (int i = 1; i < n; i++) {
        prefixTop[i] = prefixTop[i - 1] + grid[0][i];
        prefixBottom[i] = prefixBottom[i - 1] + grid[1][i];
    }

    suffixTop[n - 1] = grid[0][n - 1];
    suffixBottom[n - 1] = grid[1][n - 1];
    for (int i = n - 2; i >= 0; i--) {
        suffixTop[i] = suffixTop[i + 1] + grid[0][i];
        suffixBottom[i] = suffixBottom[i + 1] + grid[1][i];
    }

    long long result = LLONG_MAX;
    for (int i = 0; i < n; i++) {
        long long scoreTop = (i + 1 < n) ? suffixTop[i + 1] : 0;
        long long scoreBottom = (i > 0) ? prefixBottom[i - 1] : 0;
        long long secondPlayerScore = (scoreTop > scoreBottom) ? scoreTop : scoreBottom;
        result = (secondPlayerScore < result) ? secondPlayerScore : result;
    }
    free(prefixTop);
    free(suffixTop);
    free(prefixBottom);
    free(suffixBottom);
    return result;
}