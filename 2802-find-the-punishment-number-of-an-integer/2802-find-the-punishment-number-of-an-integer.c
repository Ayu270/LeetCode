bool canPartition(char* numStr, int start, int target) {
    if (start == strlen(numStr)) {
        return target == 0;
    }
    
    int currentNumber = 0;
    for (int j = start; j < strlen(numStr); ++j) {
        currentNumber = currentNumber * 10 + (numStr[j] - '0');
        if (currentNumber > target) break;
        if (canPartition(numStr, j + 1, target - currentNumber)) {
            return true;
        }
    }
    return false;
}

int punishmentNumber(int n) {
    int totalPunishment = 0;
    char squareStr[12]; 

    for (int i = 1; i <= n; ++i) {
        int square = i * i;
        sprintf(squareStr, "%d", square); 

        if (canPartition(squareStr, 0, i)) {
            totalPunishment += square;
        }
    }
    return totalPunishment;
}