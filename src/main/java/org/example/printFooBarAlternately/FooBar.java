package org.example.printFooBarAlternately;

public class FooBar {
    private int n;
    private int x;

    public FooBar(int n) {
        this.n = n;
        x = 0;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            if(x == 1)
                wait();

            if (x == 0) {
                printFoo.run();
                x = 1;
                notifyAll();
            }
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            if(x == 0){
                wait();
            }

            if (x == 1) {
                printBar.run();
                x = 0;
                notifyAll();
            }
        }
    }
}
