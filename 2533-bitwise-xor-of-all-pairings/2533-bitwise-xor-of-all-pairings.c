int xorAllNums(int* nums1, int nums1Size, int* nums2, int nums2Size) {
    int xor1 = 0, xor2 = 0;
    for (int i = 0; i < nums1Size; i++) {
        xor1 ^= nums1[i];
    }
    for (int i = 0; i < nums2Size; i++) {
        xor2 ^= nums2[i];
    }
    if (nums1Size % 2 == 1 && nums2Size % 2 == 1) {
        return xor1 ^ xor2;
    }
    if (nums1Size % 2 == 1) {
        return xor2;
    }
    if (nums2Size % 2 == 1) {
        return xor1;
    }
    return 0;
}