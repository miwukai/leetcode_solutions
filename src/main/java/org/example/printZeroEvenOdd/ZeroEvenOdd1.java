package org.example.printZeroEvenOdd;

public class ZeroEvenOdd1 {
    private int n;
    private String x;

    public ZeroEvenOdd1(int n) {
        this.n = n;
        x = "20";
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i <= n; i++) {
            while (!"20".equals(x) && !"10".equals(x)) {
                wait();
            }
            if(i < n){
                printNumber.accept(0);
            }
            switch (x) {
                case "20":
                    x = "1";
                    notifyAll();
                    break;
                case "10":
                    x = "2";
                    notifyAll();
                    break;
            }

        }
    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i++) {
            while (!"2".equals(x)) {
                wait();
            }
            if (i % 2 == 0) {
                printNumber.accept(i);
                x = "20";
                notifyAll();
            }

        }
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i <= n; i++) {
            while(!"1".equals(x)){
                wait();
            }
            if (i % 2 == 1) {
                printNumber.accept(i);
                x = "10";
                notifyAll();
            }
        }
    }

    public interface IntConsumer {
        void accept(int x);
    }
}
