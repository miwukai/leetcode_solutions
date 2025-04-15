package org.example.theDiningPhilosophers;

public class DiningPhilosophers {
    private boolean[] forksBeenPicked;
    private boolean haveABite;

    public DiningPhilosophers() {
        forksBeenPicked = new boolean[]{false, false, false, false, false};
        haveABite = false;
    }

    // call the run() method of any runnable to execute its code
    public synchronized void wantsToEat(int philosopher,
                                        Runnable pickLeftFork,
                                        Runnable pickRightFork,
                                        Runnable eat,
                                        Runnable putLeftFork,
                                        Runnable putRightFork) throws InterruptedException {
        while (forksBeenPicked[philosopher] == true) {
            wait();
        }
        pickLeftFork.run();
        forksBeenPicked[philosopher] = true;

        while (forksBeenPicked[(philosopher + 4) % 5] == true) {
            wait();
        }
        pickRightFork.run();
        forksBeenPicked[(philosopher + 4) % 5] = true;

        eat.run();

        putLeftFork.run();
        forksBeenPicked[philosopher] = false;
        notifyAll();

        putRightFork.run();
        forksBeenPicked[(philosopher + 4) % 5] = false;
        notifyAll();
    }
}
