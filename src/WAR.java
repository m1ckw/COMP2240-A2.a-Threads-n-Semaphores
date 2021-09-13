//*********************************************************************************************//
//  Class:  WAR                                                                                //
//  Author: Mick Wiedermann                                                                    //
//  Course: COMP2240 | Assignment 2.1                                                          //
//  Date  : 2021-09-16                                                                         //
//  Description: Warehouse Assitant Robot (WAR) Objects implemented as threads.                //
//***********************************************************************************************

import java.util.concurrent.Semaphore;

public class WAR implements Runnable {

    private static final String WAITING = "Waiting at the intersection.";
    private static final String CROSSING = "Crossing the intersection";
    private static final String S1 = "Heading towards Storage1";
    private static final String D1 = "Heading towards Dock1";
    private static final String S2 = "Heading towards Storage2";
    private static final String D2 = "Heading towards Dock2";
    
    private Semaphore intersection;
    private boolean loaded;
    private int id;
    private String status;
    private String destination;
    private String colour;


    public WAR(boolean loaded, int id, String destination) {
        this.loaded = loaded;
        this.id = id;
        this.destination = destination;
        this.status = WAITING;
    }

    public WAR(int id, String destination, Semaphore intersection) {
        this.destination = destination;
        this.id = id;
        this.intersection = intersection;
        if (destination.equals("N")) {
            this.destination = D2;
            this.loaded = true;
            this.status = WAITING;
            this.colour = ThreadColour.setColour(getId());
        } else if (destination.equals("E")) {
            this.destination = S1;
            this.loaded = false;
            this.status = WAITING;
            this.colour = ThreadColour.setColour(getId());
        } else if (destination.equals("S")) {
            this.destination = S2;
            this.loaded = false;
            this.status = WAITING;
            this.colour = ThreadColour.setColour(getId());
        } else if (destination.equals("W")) {
            this.destination = D1; 
            this.loaded = true;
            this.status = WAITING;
            this.colour = ThreadColour.setColour(getId());
        } else {
            this.loaded = false;
            this.status = WAITING;
        }
    }
    
    
    public void run() {
        printUpdate();
        while((CrossCount.getT1Crossings() < 150) && (CrossCount.getT2Crossings() < 150)) {
            printUpdate();
            try {
                // intersection = semaphore - Entering Critical Section.
                intersection.acquire(1);
                try {
                    setAsCrossing();
                    System.out.println(getColour() + "WAR-" + getId() + " " + isLoaded()
                    + " " + getStatus() + " Checkpoint 1...");
                    Thread.sleep(200);

                    System.out.println(getColour() + "WAR-" + getId() + " " + isLoaded()
                    + " " + getStatus() + " Checkpoint 2...");
                    Thread.sleep(200);

                    System.out.println(getColour() + "WAR-" + getId() + " " + isLoaded()
                    + " " + getStatus() + " Checkpoint 3...");
                    Thread.sleep(200);
                    System.out.println(ThreadColour.ANSI_RESET + "War-" + getId() + " " + isLoaded() + " Crossed the intersection.");

                    // Switch Statement updates the relavant Thread / WAR once they have crossed the intersection.
                    switch (getDestination()) {
                        case S1:
                            CrossCount.incT1Crossings();
                            load();
                            setDestination(D1);
                            break;
                        case D1:
                            CrossCount.incT1Crossings();
                            unload();
                            setDestination(S1);
                            break;
                        case S2:
                            CrossCount.incT2Crossings();
                            load();
                            setDestination(D2);
                            break;
                        case D2:
                            CrossCount.incT2Crossings();
                            unload();
                            setDestination(S2);
                            break;
                        default:
                            System.out.println("---- ROUGE WAR --- LOCATION UNKNOWN -- RUN!!");
                    }
                } finally {
                    System.out.println(ThreadColour.ANSI_RESET + " Total crossed on Track1: " + CrossCount.getT1Crossings() + " Track2: " + CrossCount.getT2Crossings());
                    setAsWaiting();
                    intersection.release(1);
                }
            } catch (InterruptedException e) {
                System.out.println("~ Interupt Exception Occured ~");
                e.printStackTrace();
            } 
        } 
    }

    public void printUpdate() {
        System.out.println(getColour() + "WAR-" + getId() + " " + isLoaded()
                + " " + getStatus() + " " + getDestination());
    }

    public String isLoaded() {
        if (this.loaded) {
            return "(Loaded):";
        } 
        return "(Unloaded):";
    }

    public void load() {
        this.loaded = true;
    }

    public void unload() {
        this.loaded = false;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStatus() {
        return this.status;
    }

    public void setAsWaiting() {
        this.status = WAITING;
    }

    public void setAsCrossing() {
        this.status = CROSSING;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getColour() {
        return this.colour;
    }

}
