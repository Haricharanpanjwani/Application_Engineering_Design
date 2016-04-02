package com.intuit.quickbase;

/**
 * The main method of the executable JAR generated from this repository. This is to let you
 * execute something from the command-line or IDE for the purposes of demonstration, but you can choose
 * to demonstrate in a different way (e.g. if you're using a framework)
 */
public class Main {
    public static void main( String args[] ) {                                    
        
        MergeStatService merge = new MergeStatService();
                
        merge.retrieveCountryPopulationList();        
    }
}