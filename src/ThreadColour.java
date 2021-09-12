//*********************************************************************************************//
//  Class:  ThreadColour                                                                       //
//  Author: Mick Wiedermann                                                                    //
//  Course: COMP2240 | Assignment 2.1                                                          //
//  Date  : 2021-09-16                                                                         //
//  Description: Basic object to assign colours to different threads for better vsual display  //
//***********************************************************************************************

public class ThreadColour {
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001b[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001b[37m";
    
    public static String setColour(int id) {
        switch (id) {
            case 0:
                return "";
            case 1:
                return ANSI_GREEN;
            case 2:
                return ANSI_CYAN;
            case 3:
                return ANSI_PURPLE;
            case 4:
                return ANSI_YELLOW;
            case 5:
                return ANSI_RED;
            case 6:
                return ANSI_BLUE;
            default:
                return "";
        }
        
    }
}