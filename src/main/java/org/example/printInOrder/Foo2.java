package org.example.printInOrder;

public class Foo2 {
    private boolean oneDone;
    private boolean twoDone;
    Object o;

    public Foo2(){
        o = new Object();
        oneDone = false;
        twoDone = false;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized(o){
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            oneDone = true;
            o.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized(o){
            while(!oneDone){
                o.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            twoDone = true;
            o.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized(o){
            while(!twoDone){
                o.wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
