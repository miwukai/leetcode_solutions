package org.example.huffmanEncoding;

import lombok.Data;

@Data
public class HuffmanNode {
    private int frequency;

    private char character;

    private HuffmanNode left;

    private HuffmanNode right;
}
