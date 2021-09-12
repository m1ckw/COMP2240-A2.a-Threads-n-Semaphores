//*********************************************************************************************//
//  Class:  A2 - Main                                                                          //
//  Author: Mick Wiedermann                                                                    //
//  Course: COMP2240 | Assignment 2.1                                                          //
//  Date  : 2021-09-16                                                                         //
//  Description: Main class to import, initialise, and run WAR Objects / threads.              //
//***********************************************************************************************

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;

public class A2 {
    public static final int CAPACITY = 20;
    public static ArrayBlockingQueue<WAR> waitingWars;
    private static Semaphore intersection = new Semaphore(1, true);

    public static void main(String[] args) {
        // Utilised Array Blocking Queue for built in longest waiting first served function.
        waitingWars = new ArrayBlockingQueue<WAR>(CAPACITY);
        
        File file = new File("P1-1in.txt");
        int warUnit = 0;
        try (Scanner scanner = new Scanner(new FileReader(file))) { // replace file with "args[0]" to allow the input to follow the run command.  
            while (scanner.hasNext()) {
                String bigChunk = scanner.next();
                String[] lilChunk = bigChunk.split("=");
                String direction = lilChunk[0];
                int number = Integer.parseInt(lilChunk[1]);
                for (int i=0; i<number; i++) {
                    warUnit++;
                    WAR war = new WAR(warUnit, direction, intersection);
                    waitingWars.add(war);
                }
            } 
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        printWarCrew(); // Prints initial positions.

        System.out.println(ThreadColour.ANSI_RESET + "\nStarting the threads..");
        for (int i=0; i<waitingWars.size(); i++) {
            Thread t = new Thread(waitingWars.peek()); // Thread WAR01 = new Thread( );
            t.start();
            waitingWars.add(waitingWars.remove());
        }  
    }

    // Prints initial positions to verify that the data was uploaded correctly.
    public static void printWarCrew() {
        int size = waitingWars.size();
        System.out.println(ThreadColour.ANSI_RESET +"\nWAR Crew before starting the process.");
        for (int i=0; i<size; i++) {
            System.out.println(waitingWars.peek().getColour() + "WAR-" + waitingWars.peek().getId()
            + " " + waitingWars.peek().isLoaded()
            + " " + waitingWars.peek().getStatus() 
            + " " + waitingWars.peek().getDestination());
            waitingWars.add(waitingWars.remove());
        }
    }

}
