int minimizeXor(int num1, int num2) {
    int num2Bits = 0;
    while (num2 > 0) {
        num2Bits += (num2 & 1);
        num2 >>= 1;
    }

    int result = 0;
    for ( unsigned int i = 31; i < 32; i--) {
        if (num2Bits > 0 && (num1 & (1U << i))) { 
            result |= (1U << i);
            num2Bits--;
        }
    }

    for ( unsigned int i = 0; i < 32 && num2Bits > 0; i++) {
        if (!(result & (1U << i))) {
            result |= (1U << i);
            num2Bits--;
        }
    }

    return result;
}