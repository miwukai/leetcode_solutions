package org.example.buildingH2o;

public class H2O {

    private int hCount;
    private int oCount;

    public H2O() {
        hCount = 0;
        oCount = 0;
    }

    public synchronized void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        while(hCount == 2){
            wait();
        }

        releaseHydrogen.run();
        hCount++;
        if(hCount == 2 && oCount == 1){
            hCount = 0;
            oCount = 0;
        }
        notifyAll();
    }

    public synchronized void oxygen(Runnable releaseOxygen) throws InterruptedException {
        while(oCount == 1){
            wait();
        }

        releaseOxygen.run();
        oCount++;
        if(hCount == 2 && oCount == 1){
            hCount = 0;
            oCount = 0;
        }
        notifyAll();
    }
}
