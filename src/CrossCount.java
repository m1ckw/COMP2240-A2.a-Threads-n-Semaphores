//*********************************************************************************************//
//  Class:  CrossCount                                                                         //
//  Author: Mick Wiedermann                                                                    //
//  Course: COMP2240 | Assignment 2.1                                                          //
//  Date  : 2021-09-16                                                                         //
//  Description: Object to track the number of intersection crossings on each track.           //
//***********************************************************************************************

public class CrossCount {
    
    private static int track1Cross = 0;
    private static int track2Cross = 0;

    public CrossCount() {
    }

    public static int getT1Crossings() {
        return track1Cross;
    }

    public static void incT1Crossings() {
        track1Cross++;
    }

    public static int getT2Crossings() {
        return track2Cross;
    }

    public static void incT2Crossings() {
        track2Cross++;
    }
    
}

