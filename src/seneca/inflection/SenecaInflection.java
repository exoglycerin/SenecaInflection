/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seneca.inflection;

/**
 *
 * @author Richard
 */
import java.util.Scanner;



public class SenecaInflection {

    /**
     * @param args the command line arguments
     */
    
    
    
    public static void main(String[] args) {
        //need to imput the verb root
        System.out.println("Input the verb root.");
        Scanner verb = new Scanner(System.in);
        String root = verb.next(); // This is the verb root accd to Chafe (1962)
        System.out.println("What type of verb is it' (Ag/Pat/Trans)");
        String verbType = verb.next();
        System.out.println("Input verb's aspect suffixes. (Use the /./ "
                + "symbol if it lacks this suffix and 0 if it is null.)");
        System.out.println("Stative:");
        String stativeSuffix = verb.next();
        System.out.println("Habitual:");
        String habitualSuffix = verb.next();
        System.out.println("Imperative:");
        String imperativeSuffix = verb.next();
        String init = root.substring(0,1);
        String init2;
        if (root.length() > 1) {
            init2 = root.substring(0,2);
        } else init2 = null;
        if ("(".equals(init)) {
            if (")".equals(root.substring(2,3))) {
                init = root.substring(0,3);
                init2 = root.substring(0,4);
            } else if (")".equals(root.substring(3,4))){
                init = root.substring(0,4);
                init2 = root.substring(0,5);
            } else if (")".equals(root.substring(4,5))){
                init = root.substring(0,5);
                init2= root.substring(0,6);
            }
        }
        String init3 = "";
        switch (init) {
            case "d":
            case "t":
            case "g":
            case "k":
            case "h":
            case "'":
            case "s":
            case "j":
            case "(C)":
            case "(h)":
            case "(hy)":
            case "(h/:)": 
                init3 = "CON";
                break;
            case "a":
            case "i":
            case "e":
            case "ë":
            case "ä":
            case "o":
            case "ö":
                init3 = "VOW";
                break;
            case "w":
            case "y":
            case "n":
            case "(y)":
                init3 = "RES";
                break;
        }
        
        String init4 = "";
        if (init2 != null) {
            switch(init2.substring(init2.length()-1)) {
            case "d":
            case "t":
            case "g":
            case "k":
            case "h":
            case "'":
            case "s":
            case "j":
            case "(C)":
            case "(h)":
            case "(hy)":
            case "(h/:)": 
                init4 = "CON";
                break;
            case "a":
            case "i":
            case "e":
            case "ë":
            case "ä":
            case "o":
            case "ö":
                init4 = "VOW";
                break;
            case "w":
            case "y":
            case "n":
            case "(y)":
                init4 = "RES";
                break;
            }
        }
        Modals modal = new Modals();
        SenecaPhonology phonology = new SenecaPhonology();
        
        System.out.println(init + " " + init2 + " " + init3 + " " + init4);
        String punctualSuffix = imperativeSuffix;
        if (imperativeSuffix.endsWith("h")) {
            punctualSuffix = imperativeSuffix.substring(0, imperativeSuffix.length() - 1);
            punctualSuffix = punctualSuffix + "'";
        } else {
            punctualSuffix = imperativeSuffix;
        }
        System.out.println("The verb root is " + root);
        System.out.println("The suffixes are (" + stativeSuffix + ", " 
                + habitualSuffix + ", " + imperativeSuffix + ", " + punctualSuffix + ")");
        String habitualStem = root + "-" + habitualSuffix;
        String stativeStem = root + "-" + stativeSuffix;
        String imperativeStem = root + "-" + imperativeSuffix;
        String punctualStem = root + "-" + punctualSuffix;
       
        System.out.println("The stems for this verb are: \n" + "habitual: " 
                + phonology.SenecaOrthography(habitualStem) + "\n" 
                + "stative: " + phonology.SenecaOrthography(stativeStem) + "\n" 
                + "imperative: " + phonology.SenecaOrthography(imperativeStem));
        System.out.println("The root begins with the letter: " + init);
        System.out.println("The root begins with the letters: "  + init2);
        SenecaPronominals agent = new SenecaPronominals(); 
        String[] habitualForms = agent.agentPrefixes(root, habitualStem, init, init2, init3, init4);
        String[] habitualPatForms = agent.patientPrefixes(root, habitualStem, init, init2, init3, init4);
        String[][] habitualTransForms = agent.transPrefixes(root, habitualStem, init, init2, init3, init4);
        String[] stativePatForms = agent.patientPrefixes(root, stativeStem, init, init2, init3, init4);
        String[][] stativeTransForms = agent.transPrefixes(root, stativeStem, init, init2, init3, init4);
        String[] punctualForms = agent.agentPrefixes(root, punctualStem, init, init2, init3, init4);
        String[] punctualPatForms = agent.patientPrefixes(root, punctualStem, init, init2, init3, init4);
        String[][] punctualTransForms = agent.transPrefixes(root, punctualStem, init, init2, init3, init4);
        
        String[][] futForms = modal.FutureForms(punctualForms, punctualPatForms);
        String[][] hypForms = modal.HypoForms(punctualForms, punctualPatForms);
        String[][] facForms = modal.FacForms(punctualForms, punctualPatForms);
      
        System.out.println("Habitual: \n");
        System.out.println("#Agent: #Patient: ");
        for (int i = 0; i < habitualForms.length; i++) {
            System.out.println(person[i] + "#" + phonology.SenecaOrthography(phonology.SenecaPhonology(habitualForms[i].replaceAll("-", ""))) 
                    + "#" + phonology.SenecaOrthography(phonology.SenecaPhonology(habitualPatForms[i].replaceAll("-", ""))));
            System.out.println("#" + phonology.SenecaPhonology(habitualForms[i]) 
                    + "#" + phonology.SenecaPhonology(habitualPatForms[i]));
            
        }
        System.out.println("Stative: \n");
        System.out.println("#Agent: #Patient: ");
        for (int i = 0; i < habitualForms.length; i++) {
            System.out.println(person[i] + "#" + "#" + phonology.SenecaOrthography(phonology.SenecaPhonology(stativePatForms[i].replaceAll("-", ""))));
            System.out.println("#" + "#" + phonology.SenecaPhonology(stativePatForms[i]));
        }
        System.out.println("Future: \n");
        System.out.println("#Agent: #Patient: ");
        for (int i = 0; i < habitualForms.length; i++) {
            System.out.println(person[i] + "#" + phonology.SenecaOrthography(phonology.SenecaPhonology(futForms[0][i].replaceAll("-", "")))
                    + "#" + phonology.SenecaOrthography(phonology.SenecaPhonology(futForms[1][i].replaceAll("-", ""))));
            System.out.println("#" + phonology.SenecaPhonology(futForms[0][i])
                    + "#" + phonology.SenecaPhonology(futForms[1][i]));
        }
        System.out.println("Hypothetical: \n");
        System.out.println("#Agent: #Patient: ");
        for (int i = 0; i < habitualForms.length; i++) {
            System.out.println(person[i] + "#" + phonology.SenecaOrthography(phonology.SenecaPhonology(hypForms[0][i].replaceAll("-", "")))
                    + "#" + phonology.SenecaOrthography(phonology.SenecaPhonology(hypForms[1][i].replaceAll("-", ""))));
            System.out.println("#" + phonology.SenecaPhonology(hypForms[0][i])
                    + "#" + phonology.SenecaPhonology(hypForms[1][i]));
        }
        System.out.println("Factual: \n");
        System.out.println("#Agent: #Patient: ");
        for (int i = 0; i < habitualForms.length; i++) {
            System.out.println(person[i] + "#" + phonology.SenecaOrthography(phonology.SenecaPhonology(facForms[0][i].replaceAll("-", "")))
                    + "#" + phonology.SenecaOrthography(phonology.SenecaPhonology(facForms[1][i].replaceAll("-", ""))));
            System.out.println("#" + phonology.SenecaPhonology(facForms[0][i])
                    + "#" + phonology.SenecaPhonology(facForms[1][i]));
        }
        
        System.out.println("Stative: \n");
        System.out.println("#Transitive: ");
        for (int i = 0; i < 20; i++) {
            System.out.println(phonology.SenecaOrthography(phonology.SenecaPhonology(stativeTransForms[2][i].replaceAll("-", ""))));
            System.out.println(phonology.SenecaOrthography(phonology.SenecaPhonology(stativeTransForms[2][i])));
        }
        
        System.out.println("Habitual: \n");
        System.out.println("#Transitive: ");
        for (int i = 0; i < 20; i++) {
            System.out.println(phonology.SenecaOrthography(phonology.SenecaPhonology(habitualTransForms[2][i].replaceAll("-", ""))));
            System.out.println(phonology.SenecaOrthography(phonology.SenecaPhonology(habitualTransForms[2][i])));
        }
    }
    static String[] person = {"1s", "2s", "3ms", "3fs", "3ns", "1di", "1de", 
        "2d", "3md", "3nmd", "1pi", "1pe", "2p", "3mp", "3nmp"};
    
    
}
