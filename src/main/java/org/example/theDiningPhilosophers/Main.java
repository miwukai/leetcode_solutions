package org.example.theDiningPhilosophers;

public class Main {
    public static void main(String[] args) {
        DiningPhilosophers diningPhilosophers = new DiningPhilosophers();

        for (int i = 0; i < 5; i++) {
            Thread t1 = new Thread(() -> {
                try {
                    diningPhilosophers.wantsToEat(0,
                            () -> System.out.print("0,1,1, "),
                            () -> System.out.print("0,2,1, "),
                            () -> System.out.print("0,0,3, "),
                            () -> System.out.print("0,1,2, "),
                            () -> System.out.print("0,2,2, "));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            Thread t2 = new Thread(() -> {
                try {
                    diningPhilosophers.wantsToEat(1,
                            () -> System.out.print("1,1,1, "),
                            () -> System.out.print("1,2,1, "),
                            () -> System.out.print("1,0,3, "),
                            () -> System.out.print("1,1,2, "),
                            () -> System.out.print("1,2,2, "));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            Thread t3 = new Thread(() -> {
                try {
                    diningPhilosophers.wantsToEat(2,
                            () -> System.out.print("2,1,1, "),
                            () -> System.out.print("2,2,1, "),
                            () -> System.out.print("2,0,3, "),
                            () -> System.out.print("2,1,2, "),
                            () -> System.out.print("2,2,2, "));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            Thread t4 = new Thread(() -> {
                try {
                    diningPhilosophers.wantsToEat(3,
                            () -> System.out.print("3,1,1, "),
                            () -> System.out.print("3,2,1, "),
                            () -> System.out.print("3,0,3, "),
                            () -> System.out.print("3,1,2, "),
                            () -> System.out.print("3,2,2, "));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            Thread t5 = new Thread(() -> {
                try {
                    diningPhilosophers.wantsToEat(4,
                            () -> System.out.print("4,1,1, "),
                            () -> System.out.print("4,2,1, "),
                            () -> System.out.print("4,0,3, "),
                            () -> System.out.print("4,1,2, "),
                            () -> System.out.print("4,2,2, "));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            t1.start();
            t2.start();
            t3.start();
            t4.start();
            t5.start();
        }
    }
}
