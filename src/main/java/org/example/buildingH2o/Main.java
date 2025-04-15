package org.example.buildingH2o;

public class Main {
    public static void main(String[] args) {
        H2O h2o = new H2O();

        for (char c : "HHHOHO".toCharArray()) {
            switch (c) {
                case 'H':
                    Thread t1 = new Thread(() -> {
                        try {
                            h2o.hydrogen(() -> System.out.print("H"));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
                    t1.start();
                    break;
                case 'O':
                    Thread t2 = new Thread(() -> {
                        try {
                            h2o.oxygen(() -> System.out.print("O"));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
                    t2.start();
                    break;
            }
        }
    }
}
