package org.example.printInOrder;

public class Printer {
    public void print(int[] nums) {
        Foo1 foo = new Foo1();
//        Foo2 foo = new Foo2();
//        Foo3 foo = new Foo3();
//        Foo4 foo = new Foo4();
        Thread t1 = new Thread((
        ) -> {
            try {
                foo.first(() -> System.out.println("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                foo.second(() -> System.out.println("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                foo.third(() -> System.out.println("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        for (int i : nums) {
            switch (i) {
                case 1:
                    t1.start();
                    break;
                case 2:
                    t2.start();
                    break;
                case 3:
                    t3.start();
                    break;
            }
        }
    }
}
