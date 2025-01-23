int countServers(int** grid, int gridSize, int* gridColSize) {
    int m = gridSize, n = gridColSize[0];
    int* rowCount = (int*)calloc(m, sizeof(int));
    int* colCount = (int*)calloc(n, sizeof(int));

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == 1) {
                rowCount[i]++;
                colCount[j]++;
            }
        }
    }
    int totalServers = 0;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) {
                totalServers++;
            }
        }
    }
    free(rowCount);
    free(colCount);

    return totalServers;
}