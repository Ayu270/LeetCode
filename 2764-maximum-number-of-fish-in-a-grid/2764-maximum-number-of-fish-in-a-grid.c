int directions[4][2] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
bool isValidCell(int x, int y, int rows, int cols, int** grid) {
    return x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] > 0;
}

int dfs(int x, int y, int rows, int cols, int** grid) {
    int totalFish = grid[x][y];
    grid[x][y] = 0; 
    for (int d = 0; d < 4; d++) {
        int newX = x + directions[d][0];
        int newY = y + directions[d][1];

        if (isValidCell(newX, newY, rows, cols, grid)) {
            totalFish += dfs(newX, newY, rows, cols, grid);
        }
    }

    return totalFish;
}

int findMaxFish(int** grid, int gridSize, int* gridColSize) {
    int maxFish = 0;
    for (int i = 0; i < gridSize; i++) {
        for (int j = 0; j < gridColSize[i]; j++) {
            if (grid[i][j] > 0) {
                int fishCaught = dfs(i, j, gridSize, gridColSize[i], grid);
                if (fishCaught > maxFish) {
                    maxFish = fishCaught;
                }
            }
        }
    }
    return maxFish;
}