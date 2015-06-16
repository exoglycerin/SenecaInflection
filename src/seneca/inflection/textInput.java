/*
 * File: textInput.java
 * This file is to take the stem verb and save it as verbStem
 * and return it as output.
*/

import acm.program.*;

public class textInput extends ConsoleProgram {
    
    public void run() {
        println("Sgë:nö'.");
        println("This program will inflect a Seneca verb.");
        String verbStem = readLine("What is the verb stem? ");
        String meaning = readLine("What is the meaning of this verb? ");
        println("Your verb stem is " + verbStem);
        
        String a1sPro = "ge";
        String a2sPro = "se";
        String a3msPro = "ha";
        String a3fsPro = "ye";
        String a3nsPro = "ga";
        
        String a1s = (a1sPro + verbStem);
        String a2s = (a2sPro + verbStem);
        String a3ms = (a3msPro + verbStem);
        String a3fs = (a3fsPro + verbStem);
        String a3ns = (a3nsPro + verbStem);
        
        println("The inflected forms of " + verbStem + " are: ");
        println(a1s + " 'I " + meaning + " it.'");
        println(a2s + " 'You " + meaning + " it.'");
        println(a3ms + " 'He " + meaning + " it.'");
        println(a3fs + " 'She " + meaning + " it.'");
        println(a3ns + " 'It " + meaning + " it.'");
    }
}