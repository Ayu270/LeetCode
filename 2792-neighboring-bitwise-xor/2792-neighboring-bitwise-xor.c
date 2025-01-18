bool doesValidArrayExist(int* derived, int derivedSize) {
    int sum = 0;
    int n = derivedSize;
    for (int i = 0; i < n; i++) {
        sum ^= derived[i];
    }
    return sum == 0;
}