package org.example.onlineStockSpan;

import java.util.Stack;

public class StockSpanner {

    private Stack<Pair> stack;

    public StockSpanner() {
        stack = new Stack<Pair>();
    }

    public int next(int price) {
        if (stack.isEmpty()) {
            stack.push(new Pair(price, 1));
            return 1;
        } else {
            Pair lastPair = stack.peek();

            int span = 1;

            while (price >= lastPair.price) {
                lastPair = stack.pop();

                span += lastPair.span;

                if (stack.isEmpty()) {
                    break;
                }

                lastPair = stack.peek();
            }

            stack.push(new Pair(price, span));

            return span;

        }
    }

    private class Pair {
        int price;
        int span;

        Pair(int price, int span) {
            this.price = price;
            this.span = span;
        }
    }
}
