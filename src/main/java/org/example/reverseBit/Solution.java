package org.example.reverseBit;

public class Solution {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1; // Shift result to the left by 1
            result |= (n & 1); // Add the last bit of n to result
            n >>= 1; // Shift n to the right by 1
        }
        return result;

    }
}
