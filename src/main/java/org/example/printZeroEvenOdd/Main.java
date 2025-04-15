package org.example.printZeroEvenOdd;

public class Main {
    public static void main(String[] args){
        ZeroEvenOdd1 zeroEvenOdd1 = new ZeroEvenOdd1(5);
        Thread t1 = new Thread(() -> {
            try {
                zeroEvenOdd1.zero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                zeroEvenOdd1.even(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                zeroEvenOdd1.odd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
