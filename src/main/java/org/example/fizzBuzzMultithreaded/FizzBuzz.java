package org.example.fizzBuzzMultithreaded;

public class FizzBuzz {
    private int n;
    private boolean isFizz;
    private boolean isBuzz;
    private boolean isFizzBuzz;

    public FizzBuzz(int n) {
        this.n = n;
        isFizz = false;
        isBuzz = false;
        isFizzBuzz = false;
    }

    // printFizz.run() outputs "fizz".
    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            while (!isFizz) {
                wait();
            }
            if (i % 3 == 0 && i % 5 != 0) {
                printFizz.run();
                isFizz = false;
                notifyAll();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            while (!isBuzz) {
                wait();
            }
            if (i % 3 != 0 && i % 5 == 0) {
                printBuzz.run();
                isBuzz = false;
                notifyAll();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            while (!isFizzBuzz) {
                wait();
            }
            if (i % 3 == 0 && i % 5 == 0) {
                printFizzBuzz.run();
                isFizzBuzz = false;
                notifyAll();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                isFizzBuzz = true;
                notifyAll();
            } else if (i % 3 == 0) {
                isFizz = true;
                notifyAll();
            } else if (i % 5 == 0) {
                isBuzz = true;
                notifyAll();
            }

            while (isFizz || isBuzz || isFizzBuzz) {
                wait();
            }

            if (i % 3 != 0 && i % 5 != 0) {
                printNumber.accept(i);
            }

            if(i == n){
                isFizz = true;
                isBuzz = true;
                isFizzBuzz = true;
                notifyAll();
            }
        }
    }

    public interface IntConsumer {
        void accept(int x) ;
    }
}
