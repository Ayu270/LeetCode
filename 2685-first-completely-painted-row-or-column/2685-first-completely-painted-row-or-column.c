int firstCompleteIndex(int* arr, int arrSize, int** mat, int matSize, int* matColSize) {
    int m = matSize, n = matColSize[0];
    int positions[m * n][2];
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            int num = mat[i][j];
            positions[num - 1][0] = i;
            positions[num - 1][1] = j;
        }
    }
    int rowCount[m];
    int colCount[n];
    memset(rowCount, 0, sizeof(rowCount));
    memset(colCount, 0, sizeof(colCount));
    for (int i = 0; i < arrSize; i++) {
        int num = arr[i] - 1;
        int row = positions[num][0];
        int col = positions[num][1];
        rowCount[row]++;
        colCount[col]++;
        if (rowCount[row] == n || colCount[col] == m) {
            return i;
        }
    }
    return -1;
}