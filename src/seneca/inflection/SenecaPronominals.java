package seneca.inflection;
/*
This class chooses the proper pronominals for the stem. The agent method returns
an array of strings consisting of each form of the agent paradigm. The patient
method returns an array of patien forms. The trans method will (not finished) 
return three arrays, the above two as well as an array of all the transitive forms.


As of 6/7/2015, the agent method has draft versions of 1s, 2s, ms, and fs. 
*/
public class SenecaPronominals{
    
    String[] firstSingAg = {"k", "ke", "kh"};
    String[] secondSingAg = {"(h)s", "(h)se", "j", "s"};
    String[] mascSingAg = {"ha", "hä", "hë", "h"};
    String[] femSingAg = {"ye", "yë", "yö", "y", "yak", "ya", "wa", "w", "kh"};
    String[] neutSingAg = {"ka", "kä", "kë", "w", "y"};
    String[] firstSingPat = {"(w)ak", "(w)ake", "(w)akh", "(y)ök", "(y)ök"};
    String[] secondSingPat = {"sa", "sä", "së", "s"};
    String[] mascSingPat = {"ho", "haw", "ha"};
    String[] femSingPat = {"(ya)ko", "(ya)kaw", "(ya)ka"};
    String[] neutSingPat = {"(y)o", "(y)aw", "(y)a"};
    String[] inc = {"h", "t"};
    String[] exc = {"(y)akh", "(y)ak"};
    String[] dual = {"ni", "n", "ny", "y", "š"};
    String[] plural = {"wa", "wë", "w", "y", "ti", "ën", "wä", "n"};
    String[] first2SecondSing = {"kö", "köy", "k"};
    String[] second2FirstSing = {"sk"};
    String[] firstSing2MascSing = {"he", "hey", "shak", "sheh", "shet"};
    String[] firstSing2FemSing = {"khe", "khey", "(y)akhi", "(y)akhiy","(y)ethi", "(y)ethiy"};
    String[] mascSing2FirstSing = {"hak", "hake", "shök"};
    String[] femSing2FirstSing = {"(y)ök", "(y)öke", "(y)ökhi", "(y)ökhiy"};
    String[] secondSing2MascSing = {"hehs", "hehse", "shes"};
    String[] secondSing2FemSing = {"she", "shey", "(y)etsi", "(y)etshiy"};
    String[] mascSing2SecondSing = {"ya", "yä", "yë", "y", "shes"};
    String[] femSing2SecondSing = {"(y)e", "(y)ëtsi", "(y)ëtsiy"};
    String[] plural2First = {"(h)ök", "(h)öke", "(y)ökhi", "(y)ökhiy"};
    String[] plural2Second = {"(h)ö", "(y)etsi", "(y)etsiy"};
    String[] masc2Fem = {"sha", "hakö", "hakö:", "hakoy", "hako:y"};
    String[] fem2masc = {"höwö", "howä", "höwë", "höwöy", "höw"};
    
    public String[] agentPrefixes(String root, String stem, String init, 
            String init2, String init3, String init4) {
        String firstSingAgent = null;
        String secondSingAgent = null;
        String mascSingAgent = null;
        String femSingAgent = null;
        String neutSingAgent = null;
        String incDualAgent = null;
        String excDualAgent = null;
        String secondDualAgent = null;
        String mascDualAgent = null;
        String nonMascDualAgent = null;
        String incPluralAgent = null;
        String excPluralAgent = null;
        String secondPluralAgent = null;
        String mascPluralAgent = null;
        String nonMascPluralAgent = null;
        
        if ("VOW".equals(init3)) { //First Person Singular Agent algorithm
            firstSingAgent = firstSingAg[0] + "-" + stem;
        } else if ("RES".equals(init3) &! "RES".equals(init4)) {
            firstSingAgent = firstSingAg[0] + "-" + stem;
        } else if ("CON".equals(init3) & "CON".equals(init4)) { // this needs to take care of resonant combinations
            firstSingAgent = firstSingAg[1] + "-" + stem;
        } else if ("t".equals(stem)) {
            firstSingAgent = firstSingAg[1] + "-" + stem;
        } else if ("t".equals(init) & init4 != null) {
            firstSingAgent = firstSingAg[0] + "-" + stem;
        }
        switch (init) {
            case "h":
                firstSingAgent = firstSingAg[0] + "-" + stem;
                break;
            case "(h)":
            case "(y)":
                firstSingAgent = firstSingAg[0] + "-" + stem.substring(1,2) + "-" + stem.substring(3);
                break;
            case "(h/:)":
                firstSingAgent = firstSingAg[0] + "h" + "-" + stem.substring(5);
                break;
            case "(hy)":
                firstSingAgent = firstSingAg[0] + "hy" + "-" + stem.substring(4);
                break;
            case "(C)":
                firstSingAgent = firstSingAg[0] + "-" + stem.substring(3);
                break;
            case "g":
            case "k":
            case "s":
            case "'":
                firstSingAgent = firstSingAg[1] + "-" + stem;
        }
        
           
        if ("VOW".equals(init3)) { //Second Person Singular Agent algorithm
            secondSingAgent = secondSingAg[0] + "-" + stem;
        } else if ("RES".equals(init3) &! "RES".equals(init4)) {
            secondSingAgent = secondSingAg[0] + "-" + stem;
        } else if ("CON".equals(init3) && "CON".equals(init4)) {
            secondSingAgent = secondSingAg[1] + "-" + stem;
        } else if ("t".equals(stem)) {
            secondSingAgent = secondSingAg[1] + "-" + stem;
        } else if ("t".equals(init) && init4 != null) {
            secondSingAgent = secondSingAg[0] + "-" + stem;
        } else if ("(C)".equals(init)) {
            secondSingAgent = secondSingAg[0] + "-" + stem.substring(3);
        } else if ("(C)i".equals(init2)) {
            secondSingAgent = secondSingAg[2] + "-" + stem;
        }
        
        switch (init) {
            case "h":
                secondSingAgent = secondSingAg[0] + "-" + stem;
                break;
            case "(h)":
            case "(y)":
                secondSingAgent = secondSingAg[0] + "-" + stem.substring(1,2) + "-" + stem.substring(3);
                break;
            case "(h/:)":
                secondSingAgent = secondSingAg[0] + "h" + "-" + stem.substring(5);
                break;
            case "(hy)":
                secondSingAgent = secondSingAg[0] + "hy" + "-" + stem.substring(4);
                break;
            case "g":
            case "k":
            case "s":
            case "'":
                secondSingAgent = secondSingAg[1] + "-" + stem;
                break;
            case "i":
                secondSingAgent = secondSingAg[2] + "-" + stem;
                break;
            case "y":
                secondSingAgent = secondSingAg[2] + "-" + stem.substring(1);
                break;
        }
    
        if ("i".equals(init)) { //masc sing agent algorithm
            mascSingAgent = mascSingAg[2] + "-" + stem.substring(1);
        } else if ("VOW".equals(init3)) { 
            mascSingAgent = mascSingAg[3] + "-" + stem;
        }  else if ("(C)ä".equals(init2)) {
            mascSingAgent = mascSingAg[1] + "-" + stem.substring(3);
        } else if ("(C)".equals(init)) {
            mascSingAgent = mascSingAg[0] + "-" + stem.substring(3);
        } else if ("(y)ö".equals(init2)) {
            mascSingAgent = mascSingAg[2] + "-" + stem.substring(3);
        } else if ("CON".equals(init3)) {
            mascSingAgent = mascSingAg[0] + "-" + stem;
        } else if ("RES".equals(init3)) {
            mascSingAgent = mascSingAg[0] + "-" + stem;
        }
        
        switch (init) {
            case "(h)":
            case "(y)":
                mascSingAgent = mascSingAg[0] + "-" + stem.substring(3);
                break;
            case "(hy)":
                mascSingAgent = mascSingAg[0] + "-" + stem.substring(4);
                break;
            case "(h/:)":
                mascSingAgent = mascSingAg[0] + "-" + stem.substring(5) + ":";
                break;
        }
        
        if ("i".equals(init)) { // fem sing agent algorithm
            femSingAgent = femSingAg[0] + "-" + stem.substring(1);
        } else if ("a".equals(root)) {
            femSingAgent = femSingAg[4] + "-" + stem;
        } else if ("a'aa".equals(root)) {
            femSingAgent = femSingAg[4] + "-" + stem;
        } else if ("iey".equals(root)) { 
            femSingAgent = femSingAg[5] + "-" + stem;
        } else if ("CON".equals(init3)) {
            femSingAgent = femSingAg[0] + "-" + stem;
        } else if ("RES".equals(init3)) {
            femSingAgent = femSingAg[0] + "-" + stem;
        } else if ("e".equals(init)) {
            femSingAgent = femSingAg[1] + "-" + stem.substring(1);
        } else if ("a".equals(init)) {
            femSingAgent = femSingAg[2] + "-" + stem.substring(1);
        } else if ("ä".equals(init)) {
            femSingAgent = femSingAg[2] + "-" + stem.substring(1);
        } else if ("ë".equals(init)) {
            femSingAgent = femSingAg[3] + "-" + stem;
        } else if ("o".equals(init)) {
            femSingAgent = femSingAg[4] + "-" + stem;
        } else if ("ö".equals(init)) {
            femSingAgent = femSingAg[4] + "-" + stem;
        } 
        
        switch (init) {
            case "(C)":
            case "(h)":
            case "(y)":
                femSingAgent = femSingAg[0] + "-" + stem.substring(3);
                break;
            case "(hy)":
                femSingAgent = femSingAg[0] + "-" + stem.substring(4);
                break;
            case "(h/:)":
                femSingAgent = femSingAg[0] + ":" + "-" + stem.substring(5);
        }
        
        if ("(C)ä".equals(init2)) { // neut sing agent algorithm
            neutSingAgent = neutSingAg[1] + "-" + stem.substring(3);
        } else if ("(C)".equals(init)) {
            neutSingAgent = neutSingAg[0] + "-" + stem.substring(3);
        } else if ("(y)ö".equals(init2)) {
            neutSingAgent = neutSingAg[2] + "-" + stem.substring(3);
        } else if ("CON".equals(init3)) {
            neutSingAgent = neutSingAg[0] + "-" + stem;
        } else if ("RES".equals(init3)) {
            neutSingAgent = neutSingAg[0] + "-" + stem;
        } else if ("iyo".equals(root)) {
            neutSingAgent = neutSingAg[3] + "-" + stem;
        } else if ("i".equals(init)) {
            neutSingAgent = neutSingAg[2] + "-" + stem.substring(1);
        } 
        
        switch (init) {
            case "(h)":
            case "(y)":
                neutSingAgent = neutSingAg[0] + "-" + stem.substring(3);
                break;
            case "(h/:)":
                neutSingAgent = neutSingAg[0] + ":" + "-" + stem.substring(5);
                break;
            case "(hy)":
                neutSingAgent = neutSingAg[0] + "-" + stem.substring(4);
                break;
            case "a":
            case "e":
            case "ë":
                neutSingAgent = neutSingAg[3] + "-" + stem;
                break;
            case "o":
            case "ö":
                neutSingAgent = neutSingAg[4] + "-" + stem;
                break;
        }
        
        if ("CON".equals(init3)) { // dual agent forms
            incDualAgent = inc[0] + dual[0] + "-" + stem;
            excDualAgent = exc[0] + dual[0] + "-" + stem;
            secondDualAgent = secondSingAg[3] + dual[0] + "-" + stem;
            mascDualAgent = mascSingAg[3] + dual[0] + "-" + stem;
            nonMascDualAgent = femSingAg[8] + dual[0] + "-" + stem;
        } else if ("a".equals(init)) {
            incDualAgent = inc[0] + dual[2] + "-" + stem;
            excDualAgent = exc[0] + dual[2] + "-" + stem;
            secondDualAgent = secondSingAg[3] + dual[2] + "-" + stem;
            mascDualAgent = mascSingAg[3] + dual[2] + "-" + stem;
            nonMascDualAgent = femSingAg[8] + dual[2] + "-" + stem;
        } else if ("ë".equals(init)) {
            incDualAgent = inc[0] + dual[2] + "-" + stem;
            excDualAgent = exc[0] + dual[2] + "-" + stem;
            secondDualAgent = secondSingAg[3] + dual[2] + "-" + stem;
            mascDualAgent = mascSingAg[3] + dual[2] + "-" + stem;
            nonMascDualAgent = femSingAg[8] + dual[2] + "-" + stem;
        } else if ("VOW".equals(init3)) {
            incDualAgent = inc[0] + dual[1] + "-" + stem;
            excDualAgent = exc[0] + dual[1] + "-" + stem;
            secondDualAgent = secondSingAg[3] + dual[1] + "-" + stem;
            mascDualAgent = mascSingAg[3] + dual[1] + "-" + stem;
            nonMascDualAgent = femSingAg[8] + dual[1] + "-" + stem;
        } else if ("RES".equals(init3)) {
            incDualAgent = inc[0] + dual[0] + "-" + stem;
            excDualAgent = exc[0] + dual[0] + "-" + stem;
            secondDualAgent = secondSingAg[3] + dual[0] + "-" + stem;
            mascDualAgent = mascSingAg[3] + dual[0] + "-" + stem;
            nonMascDualAgent = femSingAg[8] + dual[0] + "-" + stem;
        }
        
        switch (init) {
            case "(C)":
            case "(h)":
            case "(y)":
                incDualAgent = inc[0] + dual[0] + "-" + stem.substring(3);
                excDualAgent = exc[0] + dual[0] + "-" + stem.substring(3);
                secondDualAgent = secondSingAg[3] + dual[0] + "-" + stem.substring(3);
                mascDualAgent = mascSingAg[3] + dual[0] + "-" + stem.substring(3);
                nonMascDualAgent = femSingAg[8] + dual[0] + "-" + stem.substring(3);
                break;
            case "(hy)":
                incDualAgent = inc[0] + dual[0] + "-" + stem.substring(4);
                excDualAgent = exc[0] + dual[0] + "-" + stem.substring(4);
                secondDualAgent = secondSingAg[3] + dual[0] + "-" + stem.substring(4);
                mascDualAgent = mascSingAg[3] + dual[0] + "-" + stem.substring(4);
                nonMascDualAgent = femSingAg[8] + dual[0] + "-" + stem.substring(4);
                break;
            case "(h/:)":
                incDualAgent = inc[0] + dual[0] + ":" + "-" + stem.substring(5);
                excDualAgent = exc[0] + dual[0] + ":" + "-" + stem.substring(5);
                secondDualAgent = secondSingAg[3] + dual[0] + ":" + "-" + stem.substring(5);
                mascDualAgent = mascSingAg[3] + dual[0] + ":" + "-" + stem.substring(5);
                nonMascDualAgent = femSingAg[8] + dual[0] + ":" + "-" + stem.substring(5);
                break;
            case "(ë)":
                incDualAgent = inc[0] + dual[2] + "ë" + "-" + stem.substring(3);
                excDualAgent = exc[0] + dual[2] + "ë" + "-" + stem.substring(3);
                secondDualAgent = secondSingAg[3] + dual[2] + "ë" + "-" + stem.substring(3);
                mascDualAgent = mascSingAg[3] + dual[2] + "ë" + "-" + stem.substring(3);
                nonMascDualAgent = femSingAg[8] + dual[2] + "ë" + "-" + stem.substring(3);
                break;
        }
        
        if ("i".equals(root)) { //plural agent forms
            incPluralAgent = inc[1] + plural[2] + "-" + stem;
            excPluralAgent = exc[1] + plural[2] + "-" + stem;
            secondPluralAgent = secondSingAg[3] + plural[2] + "-" + stem;
            mascPluralAgent = mascSingAg[3] + plural[5] + "-" + stem;
            nonMascPluralAgent = femSingAg[7] + plural[5] + "-" + stem;
        } else if ("(C)ä".equals(init2)) {
            incPluralAgent = inc[1] + plural[6] + "-" + stem.substring(3);
            excPluralAgent = exc[1] + plural[6] + "-" + stem.substring(3);
            secondPluralAgent = secondSingAg[3] + plural[6] + "-" + stem.substring(3);
            mascPluralAgent = mascSingAg[0] + plural[4] + "-" + stem.substring(3);
            nonMascPluralAgent = femSingAg[6] + plural[4] + "-" + stem.substring(3);
        } else if ("(y)ö".equals(init2)) {
            incPluralAgent = inc[1] + plural[1] + "-" + stem.substring(3);
            excPluralAgent = exc[1] + plural[1] + "-" + stem.substring(3);
            secondPluralAgent = secondSingAg[3] + plural[1] + "-" + stem.substring(3);
            mascPluralAgent = mascSingAg[0] + plural[4] + "-" + stem.substring(3);
            nonMascPluralAgent = femSingAg[6] + plural[4] + "-" + stem.substring(3);
        } else if ("CON".equals(init3)) {
            incPluralAgent = inc[1] + plural[0] + "-" + stem;
            excPluralAgent = exc[1] + plural[0] + "-" + stem;
            secondPluralAgent = secondSingAg[3] + plural[0] + "-" + stem;
            mascPluralAgent = mascSingAg[0] + plural[4] + "-" + stem;
            nonMascPluralAgent = femSingAg[6] + plural[4] + "-" + stem;
        } else if ("RES".equals(init3)) {
            incPluralAgent = inc[1] + plural[0] + "-" + stem;
            excPluralAgent = exc[1] + plural[0] + "-" + stem;
            secondPluralAgent = secondSingAg[3] + plural[0] + "-" + stem;
            mascPluralAgent = mascSingAg[0] + plural[4] + "-" + stem;
            nonMascPluralAgent = femSingAg[6] + plural[4] + "-" + stem;
        } 
        
        switch (init) { 
            case "i":
                incPluralAgent = inc[1] + plural[1] + "-" + stem.substring(1);
                excPluralAgent = exc[1] + plural[1] + "-" + stem.substring(1);
                secondPluralAgent = secondSingAg[3] + plural[1] + "-" + stem.substring(1);
                mascPluralAgent = mascSingAg[3] + plural[5] + "-" + stem;
                nonMascPluralAgent = femSingAg[7] + plural[5] + "-" + stem;
                break;
            case "a":
            case "e":
            case "ë":
            case "ä":
                incPluralAgent = inc[1] + plural[2] + "-" + stem.substring(1);
                excPluralAgent = exc[1] + plural[2] + "-" + stem.substring(1);
                secondPluralAgent = secondSingAg[3] + plural[2] + "-" + stem.substring(1);
                mascPluralAgent = mascSingAg[3] + plural[5] + "-" + stem;
                nonMascPluralAgent = femSingAg[7] + plural[5] + "-" + stem;
                break;
            case "o":
            case "ö":
                incPluralAgent = inc[1] + plural[3] + "-" + stem.substring(1);
                excPluralAgent = exc[1] + plural[3] + "-" + stem.substring(1);
                secondPluralAgent = secondSingAg[3] + plural[3] + "-" + stem.substring(1);
                mascPluralAgent = mascSingAg[3] + plural[5] + "-" + stem;
                nonMascPluralAgent = femSingAg[7] + plural[5] + "-" + stem;
                break;
        }
                
        String[] agentForms = {firstSingAgent, secondSingAgent, mascSingAgent, 
            femSingAgent, neutSingAgent, incDualAgent, excDualAgent, 
            secondDualAgent, mascDualAgent, nonMascDualAgent, incPluralAgent, 
            excPluralAgent, secondPluralAgent, mascPluralAgent, nonMascPluralAgent};
        return agentForms;
    }
     public String[] patientPrefixes(String root, String stem, String init, 
             String init2, String init3, String init4) {
        String firstSingPatient = null;
        String secondSingPatient = null;
        String mascSingPatient = null;
        String femSingPatient = null;
        String neutSingPatient = null;
        String incDualPatient = null;
        String excDualPatient = null;
        String secondDualPatient = null;
        String mascDualPatient = null;
        String nonMascDualPatient = null;
        String incPluralPatient = null;
        String excPluralPatient = null;
        String secondPluralPatient = null;
        String mascPluralPatient = null;
        String nonMascPluralPatient = null;
        
        
        if ("VOW".equals(init3)) { //First Person Singular Patient algorithm
            firstSingPatient = firstSingPat[0] + "-" + stem;
        } else if ("RES".equals(init3) &! "RES".equals(init4)) {
            firstSingPatient = firstSingPat[0] + "-" + stem;
        } else if ("CON".equals(init3) & "CON".equals(init4)) { // this needs to take care of resonant combinations
            firstSingPatient = firstSingPat[1] + "-" + stem;
        } else if ("t".equals(stem)) {
            firstSingPatient = firstSingPat[1] + "-" + stem;
        } else if ("t".equals(init) & init4 != null) {
            firstSingPatient = firstSingPat[0] + "-" + stem;
        }
        switch (init) {
            case "h":
                firstSingPatient = firstSingPat[0] + "-" + stem;
                break;
            case "(h)":
            case "(y)":
                firstSingPatient = firstSingPat[0] + "-" + stem.substring(1,2) + "-" + stem.substring(3);
                break;
            case "(h/:)":
                firstSingPatient = firstSingPat[0] + "h" + "-" + stem.substring(5);
                break;
            case "(hy)":
                firstSingPatient = firstSingPat[0] + "hy" + "-" + stem.substring(4);
                break;
            case "(C)":
                firstSingPatient = firstSingPat[0] + "-" + stem.substring(3);
                break;
            case "g":
            case "k":
            case "s":
            case "'":
                firstSingPatient = firstSingPat[1] + "-" + stem;
                break;
            case "(ë)":
                firstSingPatient = firstSingPat[0] + "ë" + "-" + stem.substring(3);
        }
        
        if ("(C)ä".equals(init2)) { // Second Person Patient algorithm
            secondSingPatient = secondSingPat[1] + "-" + stem.substring(3);
        } else if ("(y)ö".equals(init2)) {
            secondSingPatient = secondSingPat[2] + "-" + stem.substring(3);
        } else if ("CON".equals(init3)) {
            secondSingPatient = secondSingPat[0] + "-" + stem;
        } else if ("RES".equals(init3)) {
            secondSingPatient = secondSingPat[0] + "-" + stem;
        } 
        
        switch (init) {
            case "(C)":
                secondSingPatient = secondSingPat[0] + "-" + stem.substring(3);
                break;
            case "(h)":
                secondSingPatient = secondSingPat[0] + "h" + "-" + stem.substring(3);
                break;
            case "(y)":
                secondSingPatient = secondSingPat[0] + "y" + "-" + stem.substring(3);
                break;
            case "(hy)":
                secondSingPatient = secondSingPat[0] + "hy" + "-" + stem.substring(4);
                break;
            case "(h/:)":
                secondSingPatient = secondSingPat[0] + "h" + "-" + stem.substring(5);
            case "o":
            case "ö":
                secondSingPatient = secondSingPat[0] + "-" + stem;
                break;
            case "i":
                secondSingPatient = secondSingPat[2] + "-" + stem.substring(1);
                break;
            case "a":
            case "ä":
            case "e":
            case "ë":
                secondSingPatient = secondSingPat[3] + "-" + stem;
                break;
            case "(ë)":
                secondSingPatient = secondSingPat[3] + "ë" + "-" + stem.substring(3);
        }
        
        if ("CON".equals(init3)) {//masc/fem/neut sing patient algorithm
            mascSingPatient = mascSingPat[0] + "-" + stem;
            femSingPatient = femSingPat[0] + "-" + stem;
            neutSingPatient = neutSingPat[0] + "-" + stem;
        } else if ("RES".equals(init3)) {
            mascSingPatient = mascSingPat[0] + "-" + stem;
            femSingPatient = femSingPat[0] + "-" + stem;
            neutSingPatient = neutSingPat[0] + "-" + stem;
        }
        
        switch (init) {
            case "a":
            case "i":
                mascSingPatient = mascSingPat[0] + "-" + stem.substring(1);
                femSingPatient = femSingPat[0] + "-" + stem.substring(1);
                neutSingPatient = neutSingPat[0] + "-" + stem.substring(1);
                break;
            case "o":
            case "ö":
                mascSingPatient = mascSingPat[2] + "-" + stem;
                femSingPatient = femSingPat[2] + "-" + stem;
                neutSingPatient = neutSingPat[2] + "-" + stem;
                break;
            case "e":
            case "ë":
                mascSingPatient = mascSingPat[1] + "-" + stem;
                femSingPatient = femSingPat[1] + "-" + stem;
                neutSingPatient = neutSingPat[1] + "-" + stem;
                break;
            case "(ë)":
                mascSingPatient = mascSingPat[0] + "-" + stem;
                femSingPatient = femSingPat[0] + "-" + stem;
                neutSingPatient = neutSingPat[0] + "-" + stem;
                break;
            case "(C)":
            case "(h)":
            case "(y)":
                mascSingPatient = mascSingPat[0] + "-" + stem.substring(3);
                femSingPatient = femSingPat[0] + "-" + stem.substring(3);
                neutSingPatient = neutSingPat[0] + "-" + stem.substring(3);
                break;
            case "(hy)":
                mascSingPatient = mascSingPat[0] + "-" + stem.substring(4);
                femSingPatient = femSingPat[0] + "-" + stem.substring(4);
                neutSingPatient = neutSingPat[0] + "-" + stem.substring(4);
                break;
            case "(h/:)":
                mascSingPatient = mascSingPat[0] + ":" + "-" + stem.substring(5);
                femSingPatient = femSingPat[0] + ":" + "-" + stem.substring(5);
                neutSingPatient = neutSingPat[0] + ":" + "-" + stem.substring(5);
                break;
        }
        
        if ("CON".equals(init3)) { // dual forms
            incDualPatient = firstSingPat[4] + dual[0] + "-" + stem;
            excDualPatient = firstSingPat[4] + dual[0] + "-" + stem;
            secondDualPatient = secondSingAg[3] + dual[0] + "-" + stem;
            mascDualPatient = mascSingPat[0] + plural[4] + "-" + stem;
            nonMascDualPatient = neutSingPat[0] + plural[4] + "-" + stem;
        } else if ("a".equals(init)) {
            incDualPatient = firstSingPat[4] + dual[2] + "-" + stem;
            excDualPatient = firstSingPat[4] + dual[2] + "-" + stem;
            secondDualPatient = secondSingAg[3] + dual[2] + "-" + stem;
            mascDualPatient = mascSingPat[0] + plural[7] + "-" + stem;
            nonMascDualPatient = neutSingAg[0] + plural[7] + "-" + stem;
        } else if ("ë".equals(init)) {
            incDualPatient = firstSingPat[4] + dual[2] + "-" + stem;
            excDualPatient = firstSingPat[4] + dual[2] + "-" + stem;
            secondDualPatient = secondSingAg[3] + dual[2] + "-" + stem;
            mascDualPatient = mascSingPat[0] + plural[7] + "-" + stem;
            nonMascDualPatient = neutSingAg[0] + plural[7] + "-" + stem;
        } else if ("VOW".equals(init3)) {
            incDualPatient = firstSingPat[4] + dual[1] + "-" + stem;
            excDualPatient = firstSingPat[4] + dual[1] + "-" + stem;
            secondDualPatient = secondSingAg[3] + dual[1] + "-" + stem;
            mascDualPatient = mascSingPat[0] + plural[7] + "-" + stem;
            nonMascDualPatient = neutSingAg[0] + plural[7] + "-" + stem;
        } else if ("RES".equals(init3)) {
            incDualPatient = firstSingPat[4] + dual[0] + "-" + stem;
            excDualPatient = firstSingPat[4] + dual[0] + "-" + stem;
            secondDualPatient = secondSingAg[3] + dual[0] + "-" + stem;
            mascDualPatient = mascSingPat[0] + plural[4] + "-" + stem;
            nonMascDualPatient = neutSingPat[0] + plural[4] + "-" + stem;
        }
         
        switch (init) {
            case "(C)":
            case "(h)":
            case "(y)":
                incDualPatient = firstSingPat[4] + dual[0] + "-" + stem.substring(3);
                excDualPatient = firstSingPat[4] + dual[0] + "-" + stem.substring(3);
                secondDualPatient = secondSingAg[3] + dual[0] + "-" + stem.substring(3);
                mascDualPatient = mascSingPat[0] + plural[4] + "-" + stem.substring(3);
                nonMascDualPatient = neutSingPat[0] + plural[4] + "-" + stem.substring(3);
                break;
            case "(hy)":
                incDualPatient = firstSingPat[4] + dual[0] + "-" + stem.substring(4);
                excDualPatient = firstSingPat[4] + dual[0] + "-" + stem.substring(4);
                secondDualPatient = secondSingAg[3] + dual[0] + "-" + stem.substring(4);
                mascDualPatient = mascSingPat[0] + plural[4] + "-" + stem.substring(4);
                nonMascDualPatient = neutSingPat[0] + plural[4] + "-" + stem.substring(4);
                break;
            case "(h/:)":
                incDualPatient = firstSingPat[4] + dual[0] +  ":" + "-" + stem.substring(5);
                excDualPatient = firstSingPat[4] + dual[0] +  ":" + "-" + stem.substring(5);
                secondDualPatient = secondSingAg[3] + dual[0] +  ":" + "-" + stem.substring(5);
                mascDualPatient = mascSingPat[0] + plural[4] +  ":" + "-" + stem.substring(5);
                nonMascDualPatient = neutSingPat[0] + plural[4] +  ":" + "-" + stem.substring(5);
                break;
            case "(ë)":
                incDualPatient = firstSingPat[4] + dual[2] + "ë" + "-" + stem.substring(3);
                excDualPatient = firstSingPat[4] + dual[2] + "ë" + "-" + stem.substring(3);
                secondDualPatient = secondSingAg[3] + dual[2] + "ë" + "-" + stem.substring(3);
                mascDualPatient = mascSingPat[0] + plural[7] + "ë" + "-" + stem.substring(3);
                nonMascDualPatient = neutSingAg[0] + plural[7] + "ë" + "-" + stem.substring(3);
                break;
        }
        
        if ("i".equals(root)) { //plural forms
            incPluralPatient = firstSingPat[4] + plural[2] + "-" + stem;
            excPluralPatient = firstSingPat[4] + plural[2] + "-" + stem;
            secondPluralPatient = secondSingAg[3] + plural[2] + "-" + stem;
            mascPluralPatient = mascSingPat[0] + plural[7] + "-" + stem;
            nonMascPluralPatient = neutSingAg[0] + plural[7] + "-" + stem;
        } else if ("(C)ä".equals(init2)) {
            incPluralPatient = firstSingPat[4] + plural[6] + "-" + stem.substring(3);
            excPluralPatient = firstSingPat[4] + plural[6] + "-" + stem.substring(3);
            secondPluralPatient = secondSingAg[3] + plural[6] + "-" + stem.substring(3);
            mascPluralPatient = mascSingPat[0] + plural[4] + "-" + stem.substring(3);
            nonMascPluralPatient = neutSingPat[0] + plural[4] + "-" + stem.substring(3);
        } else if ("(y)ö".equals(init2)) {
            incPluralPatient = firstSingPat[4] + plural[1] + "-" + stem.substring(3);
            excPluralPatient = firstSingPat[4] + plural[1] + "-" + stem.substring(3);
            secondPluralPatient = secondSingAg[3] + plural[1] + "-" + stem.substring(3);
            mascPluralPatient = mascSingPat[0] + plural[4] + "-" + stem.substring(3);
            nonMascPluralPatient = neutSingPat[0] + plural[4] + "-" + stem.substring(3);
        } else if ("CON".equals(init3)) {
            incPluralPatient = firstSingPat[4] + plural[0] + "-" + stem;
            excPluralPatient = firstSingPat[4] + plural[0] + "-" + stem;
            secondPluralPatient = secondSingAg[3] + plural[0] + "-" + stem;
            mascPluralPatient = mascSingPat[0] + plural[4] + "-" + stem;
            nonMascPluralPatient = neutSingPat[0] + plural[4] + "-" + stem;
        } else if ("RES".equals(init3)) {
            incPluralPatient = firstSingPat[4] + plural[0] + "-" + stem;
            excPluralPatient = firstSingPat[4] + plural[0] + "-" + stem;
            secondPluralPatient = secondSingAg[3] + plural[0] + "-" + stem;
            mascPluralPatient = mascSingPat[0] + plural[4] + "-" + stem;
            nonMascPluralPatient = neutSingPat[0] + plural[4] + "-" + stem;
        } 
        
        switch (init) { 
            case "i":
                incPluralPatient = firstSingPat[4] + plural[1] + "-" + stem.substring(1);
                excPluralPatient = firstSingPat[4] + plural[1] + "-" + stem.substring(1);
                secondPluralPatient = secondSingAg[3] + plural[1] + "-" + stem.substring(1);
                mascPluralPatient = mascSingPat[0] + plural[7] + "-" + stem;
                nonMascPluralPatient = neutSingAg[0] + plural[7] + "-" + stem;
                break;
            case "a":
            case "e":
            case "ë":
            case "ä":
                incPluralPatient = firstSingPat[4] + plural[2] + "-" + stem.substring(1);
                excPluralPatient = firstSingPat[4] + plural[2] + "-" + stem.substring(1);
                secondPluralPatient = secondSingAg[3] + plural[2] + "-" + stem.substring(1);
                mascPluralPatient = mascSingPat[0] + plural[7] + "-" + stem;
                nonMascPluralPatient = neutSingAg[0] + plural[7] + "-" + stem;
                break;
            case "o":
            case "ö":
                incPluralPatient = firstSingPat[4] + plural[3] + "-" + stem.substring(1);
                excPluralPatient = firstSingPat[4] + plural[3] + "-" + stem.substring(1);
                secondPluralPatient = secondSingAg[3] + plural[3] + "-" + stem.substring(1);
                mascPluralPatient = mascSingPat[0] + plural[7] + "-" + stem;
                nonMascPluralPatient = neutSingAg[0] + plural[7] + "-" + stem;
                break;
            case "(C)":
            case "(h)":
            case "(y)":
                incPluralPatient = firstSingPat[4] + plural[0] + "-" + stem.substring(3);
                excPluralPatient = firstSingPat[4] + plural[0] + "-" + stem.substring(3);
                secondPluralPatient = secondSingAg[3] + plural[0] + "-" + stem.substring(3);
                mascPluralPatient = mascSingAg[0] + plural[4] + "-" + stem.substring(3);
                nonMascPluralPatient = femSingAg[6] + plural[4] + "-" + stem.substring(3);
                break;
            case "(hy)":
                incPluralPatient = firstSingPat[4] + plural[0] + "-" + stem.substring(4);
                excPluralPatient = firstSingPat[4] + plural[0] + "-" + stem.substring(4);
                secondPluralPatient = secondSingAg[3] + plural[0] + "-" + stem.substring(4);
                mascPluralPatient = mascSingAg[0] + plural[4] + "-" + stem.substring(4);
                nonMascPluralPatient = femSingAg[6] + plural[4] + "-" + stem.substring(4);
                break;
            case "(h/:)":
                incPluralPatient = firstSingPat[4] + plural[0] + ":" + "-" + stem.substring(5);
                excPluralPatient = firstSingPat[4] + plural[0] + ":" + "-" + stem.substring(5);
                secondPluralPatient = secondSingAg[3] + plural[0] + ":" + "-" + stem.substring(5);
                mascPluralPatient = mascSingAg[0] + plural[4] + ":" + "-" + stem.substring(5);
                nonMascPluralPatient = femSingAg[6] + plural[4] + ":" + "-" + stem.substring(5);
                break;
            case "(ë)":
                incPluralPatient = firstSingPat[4] + plural[2] + "-" + stem.substring(3);
                excPluralPatient = firstSingPat[4] + plural[2] + "-" + stem.substring(3);
                secondPluralPatient = secondSingAg[3] + plural[2] + "-" + stem.substring(3);
                mascPluralPatient = mascSingPat[0] + plural[7] + "ë" + "-" + stem.substring(3);
                nonMascPluralPatient = neutSingAg[0] + plural[7] + "ë" + "-" + stem.substring(3);
                break;
        }
                
        String[] PatientForms = {firstSingPatient, secondSingPatient, mascSingPatient, 
            femSingPatient, neutSingPatient, incDualPatient, excDualPatient, 
            secondDualPatient, mascDualPatient, nonMascDualPatient, incPluralPatient, 
            excPluralPatient, secondPluralPatient, mascPluralPatient, nonMascPluralPatient};
        return PatientForms;
     }
     
     public String[][] transPrefixes(String root, String stem, String init, 
             String init2, String init3, String init4) {
         
         String firstS_to_SecondS = null;
         String first_to_SecondD = null;
         String first_to_SecondP = null;
         String second_to_FirstS = null;
         String second_to_FirstD = null;
         String second_to_FirstP = null;
         String first_to_MascS = null;
         String incD_to_MascS = null;
         String incP_to_MascS = null;
         String excD_to_MascS = null;
         String excP_to_MascS = null;
         String second_to_MascS = null;
         String secondD_to_MascS = null;
         String secondP_to_MascS = null;
         String mascS_to_FirstS = null;
         String mascS_to_FirstD = null;
         String mascS_to_FirstP = null;
         String mascS_to_SecondS = null;
         String mascS_to_SecondD = null;
         String mascS_to_SecondP = null;
         
        if (ifCON(init)) { //I > you (sing)
            firstS_to_SecondS = first2SecondSing[0] + "-" + stem;
        } else if ("i".equals(init)) {
            firstS_to_SecondS = first2SecondSing[0] + "-" + stem.substring(1);
        } else {
            firstS_to_SecondS = first2SecondSing[1] + "-" + stem;
        }
        switch (init) {
            case "(h)":
            case "(y)":
                firstS_to_SecondS = first2SecondSing[0] + "-" + stem.substring(3);
                break;
            case "(hy)":
                firstS_to_SecondS = first2SecondSing[0] + "-" + stem.substring(4);
                break;
            case "(h/:)":
                firstS_to_SecondS = first2SecondSing[0] + ":" + "-" + stem.substring(5);
                break;
        }
        
        if ("VOW".equals(init3)) { //You (sing) > me
            second_to_FirstS = "s" + firstSingAg[0] + "-" + stem;
        } else if ("RES".equals(init3) &! "RES".equals(init4)) {
            second_to_FirstS = "s" + firstSingAg[0] + "-" + stem;
        } else if ("CON".equals(init3) & "CON".equals(init4)) { // this needs to take care of resonant combinations
            second_to_FirstS = "s" + firstSingAg[1] + "-" + stem;
        } else if ("t".equals(stem)) {
            second_to_FirstS = "s" + firstSingAg[1] + "-" + stem;
        } else if ("t".equals(init) & init4 != null) {
            second_to_FirstS = "s" + firstSingAg[0] + "-" + stem;
        }
        switch (init) {
            case "h":
                second_to_FirstS = "s" + firstSingAg[0] + "-" + stem;
                break;
            case "(h)":
            case "(y)":
                second_to_FirstS = "s" + firstSingAg[0] + "-" + stem.substring(1,2) + "-" + stem.substring(3);
                break;
            case "(h/:)":
                second_to_FirstS = "s" + firstSingAg[0] + "h" + "-" + stem.substring(5);
                break;
            case "(hy)":
                second_to_FirstS = "s" + firstSingAg[0] + "hy" + "-" + stem.substring(4);
                break;
            case "(C)":
                second_to_FirstS = "s" + firstSingAg[0] + "-" + stem.substring(3);
                break;
            case "g":
            case "k":
            case "s":
            case "'":
                second_to_FirstS = "s" + firstSingAg[1] + "-" + stem;
        }
        
        if (ifCON(init)) { //I > him
            first_to_MascS = firstSing2MascSing[0] + "-" + stem;
        } else if ("i".equals(init)) {
            first_to_MascS = firstSing2MascSing[0] + "-" + stem.substring(1);
        } else {
            first_to_MascS = firstSing2MascSing[1] + "-" + stem;
        }
        
        switch (init) {
            case "(h)":
            case "(y)":
                first_to_MascS = firstSing2MascSing[0] + "-" + stem.substring(3);
                break;
            case "(hy)":
                first_to_MascS = firstSing2MascSing[0] + "-" + stem.substring(4);
                break;
            case "(h/:)":
                first_to_MascS = firstSing2MascSing[0] + "-:" + stem.substring(5);
                break;
        }
        
        if ("VOW".equals(init3)) { //You(sing) > him
            second_to_MascS = secondSing2MascSing[0] + "-" + stem;
        } else if ("RES".equals(init3) &! "RES".equals(init4)) {
            second_to_MascS = secondSing2MascSing[0] + "-" + stem;
        } else if ("CON".equals(init3) && "CON".equals(init4)) {
            second_to_MascS = secondSing2MascSing[1] + "-" + stem;
        } else if ("t".equals(stem)) {
            second_to_MascS = secondSing2MascSing[1] + "-" + stem;
        } else if ("t".equals(init) && init4 != null) {
            second_to_MascS = secondSing2MascSing[0] + "-" + stem;
        } else if ("(C)".equals(init)) {
            second_to_MascS = secondSing2MascSing[0] + "-" + stem.substring(3);
        } else if ("(C)i".equals(init2)) {
            second_to_MascS = secondSing2MascSing[0] + "-" + stem;
        }
        
        switch (init) {
            case "h":
                second_to_MascS = secondSing2MascSing[0] + "-" + stem;
                break;
            case "(h)":
            case "(y)":
                second_to_MascS = secondSing2MascSing[0] + "-" + stem.substring(1,2) + "-" + stem.substring(3);
                break;
            case "(h/:)":
                second_to_MascS = secondSing2MascSing[0] + "h" + "-" + stem.substring(5);
                break;
            case "(hy)":
                second_to_MascS = secondSing2MascSing[0] + "hy" + "-" + stem.substring(4);
                break;
            case "g":
            case "k":
            case "s":
            case "'":
                second_to_MascS = secondSing2MascSing[1] + "-" + stem;
                break;
            case "i":
                second_to_MascS = secondSing2MascSing[0] + "-" + stem;
                break;
            case "y":
                second_to_MascS = secondSing2MascSing[0] + "-" + stem.substring(1);
                break;
        }
        
        if ("VOW".equals(init3)) { //He > me
            mascS_to_FirstS = "ha" + firstSingAg[0] + "-" + stem;
        } else if ("RES".equals(init3) &! "RES".equals(init4)) {
            mascS_to_FirstS = "ha" + firstSingAg[0] + "-" + stem;
        } else if ("CON".equals(init3) & "CON".equals(init4)) { // this needs to take care of resonant combinations
            mascS_to_FirstS = "ha" + firstSingAg[1] + "-" + stem;
        } else if ("t".equals(stem)) {
            mascS_to_FirstS = "ha" + firstSingAg[1] + "-" + stem;
        } else if ("t".equals(init) & init4 != null) {
            mascS_to_FirstS = "ha" + firstSingAg[0] + "-" + stem;
        }
        switch (init) {
            case "h":
                mascS_to_FirstS = "ha" + firstSingAg[0] + "-" + stem;
                break;
            case "(h)":
            case "(y)":
                mascS_to_FirstS = "ha" + firstSingAg[0] + "-" + stem.substring(1,2) + "-" + stem.substring(3);
                break;
            case "(h/:)":
                mascS_to_FirstS = "ha" + firstSingAg[0] + "h" + "-" + stem.substring(5);
                break;
            case "(hy)":
                mascS_to_FirstS = "ha" + firstSingAg[0] + "hy" + "-" + stem.substring(4);
                break;
            case "(C)":
                mascS_to_FirstS = "ha" + firstSingAg[0] + "-" + stem.substring(3);
                break;
            case "g":
            case "k":
            case "s":
            case "'":
                mascS_to_FirstS = "ha" + firstSingAg[1] + "-" + stem;
        }
        
        if ("(C)ä".equals(init2)) { // He > you (sing)
            mascS_to_SecondS = mascSing2SecondSing[1] + "-" + stem.substring(3);
        } else if ("(y)ö".equals(init2)) {
            mascS_to_SecondS = mascSing2SecondSing[2] + "-" + stem.substring(3);
        } else if ("CON".equals(init3)) {
            mascS_to_SecondS = mascSing2SecondSing[0] + "-" + stem;
        } else if ("RES".equals(init3)) {
            mascS_to_SecondS = mascSing2SecondSing[0] + "-" + stem;
        } 
        
        switch (init) {
            case "(C)":
                mascS_to_SecondS = mascSing2SecondSing[0] + "-" + stem.substring(3);
                break;
            case "(h)":
                mascS_to_SecondS = mascSing2SecondSing[0] + "h" + "-" + stem.substring(3);
                break;
            case "(y)":
                mascS_to_SecondS = mascSing2SecondSing[0] + "y" + "-" + stem.substring(3);
                break;
            case "(hy)":
                mascS_to_SecondS = mascSing2SecondSing[0] + "hy" + "-" + stem.substring(4);
                break;
            case "(h/:)":
                mascS_to_SecondS = mascSing2SecondSing[0] + "h" + "-" + stem.substring(5);
            case "o":
            case "ö":
                mascS_to_SecondS = mascSing2SecondSing[0] + "-" + stem;
                break;
            case "i":
                mascS_to_SecondS = mascSing2SecondSing[2] + "-" + stem.substring(1);
                break;
            case "a":
            case "ä":
            case "e":
            case "ë":
                mascS_to_SecondS = mascSing2SecondSing[3] + "-" + stem;
                break;
            case "(ë)":
                mascS_to_SecondS = mascSing2SecondSing[3] + "ë" + "-" + stem.substring(3);
        }
        
        if (ifCON(init)) { // dual trans forms
            first_to_SecondD = first2SecondSing[2] + dual[0] + "-" + stem;
            second_to_FirstD = second2FirstSing[0] + dual[0] + "-" + stem;
            incD_to_MascS = firstSing2MascSing[3] + dual[0] + "-" + stem;
            excD_to_MascS = firstSing2MascSing[2] + dual[0] + "-" + stem;
            secondD_to_MascS = secondSing2MascSing[2] + dual[0] + "-" + stem;
            mascS_to_FirstD = mascSing2FirstSing[2] + dual[0] + "-" + stem;
            mascS_to_SecondD = mascSing2SecondSing[4] + dual[0] + "-" + stem;
            incD_to_MascS = firstSing2MascSing[3] + dual[0] + "-" + stem;
            excD_to_MascS = firstSing2MascSing[2] + dual[0] + "-" + stem;
            secondD_to_MascS = secondSing2MascSing[2] + dual[0] + "-" + stem;
        } else if ("a".equals(init)) {
            first_to_SecondD = first2SecondSing[2] + dual[2] + "-" + stem;
            second_to_FirstD = second2FirstSing[0] + dual[2] + "-" + stem;
            incD_to_MascS = firstSing2MascSing[3] + dual[2] + "-" + stem;
            excD_to_MascS = firstSing2MascSing[2] + dual[2] + "-" + stem;
            secondD_to_MascS = secondSing2MascSing[2] + dual[2] + "-" + stem;
            mascS_to_FirstD = mascSing2FirstSing[2] + dual[2] + "-" + stem;
            mascS_to_SecondD = mascSing2SecondSing[4] + dual[2] + "-" + stem;
            incD_to_MascS = firstSing2MascSing[3] + dual[2] + "-" + stem;
            excD_to_MascS = firstSing2MascSing[2] + dual[2] + "-" + stem;
            secondD_to_MascS = secondSing2MascSing[2] + dual[2] + "-" + stem;
        } else if ("ë".equals(init)) {
            first_to_SecondD = first2SecondSing[2] + dual[2] + "-" + stem;
            second_to_FirstD = second2FirstSing[0] + dual[2] + "-" + stem;
            incD_to_MascS = firstSing2MascSing[3] + dual[2] + "-" + stem;
            excD_to_MascS = firstSing2MascSing[2] + dual[2] + "-" + stem;
            secondD_to_MascS  = secondSing2MascSing[2] + dual[2] + "-" + stem;
            mascS_to_FirstD = mascSing2FirstSing[2] + dual[2] + "-" + stem;
            mascS_to_SecondD = mascSing2SecondSing[4] + dual[2] + "-" + stem;
            incD_to_MascS = firstSing2MascSing[3] + dual[2] + "-" + stem;
            excD_to_MascS = firstSing2MascSing[2] + dual[2] + "-" + stem;
            secondD_to_MascS  = secondSing2MascSing[2] + dual[2] + "-" + stem;
        } else if ("VOW".equals(init3)) {
            first_to_SecondD = first2SecondSing[2] + dual[1] + "-" + stem;
            second_to_FirstD = second2FirstSing[0] + dual[1] + "-" + stem;
            incD_to_MascS = firstSing2MascSing[3] + dual[1] + "-" + stem;
            excD_to_MascS = firstSing2MascSing[2] + dual[1] + "-" + stem;
            secondD_to_MascS = secondSing2MascSing[2] + dual[1] + "-" + stem;
            mascS_to_FirstD = mascSing2FirstSing[2] + dual[1] + "-" + stem;
            mascS_to_SecondD = mascSing2SecondSing[4] + dual[1] + "-" + stem;
            incD_to_MascS = firstSing2MascSing[3] + dual[1] + "-" + stem;
            excD_to_MascS = firstSing2MascSing[2] + dual[1] + "-" + stem;
            secondD_to_MascS = secondSing2MascSing[2] + dual[1] + "-" + stem;
        } else if ("RES".equals(init3)) {
            first_to_SecondD = first2SecondSing[2] + dual[0] + "-" + stem;
            second_to_FirstD = second2FirstSing[0] + dual[0] + "-" + stem;
            incD_to_MascS = firstSing2MascSing[3] + dual[0] + "-" + stem;
            excD_to_MascS = firstSing2MascSing[2] + dual[0] + "-" + stem;
            secondD_to_MascS = secondSing2MascSing[2] + dual[0] + "-" + stem;
            mascS_to_FirstD = mascSing2FirstSing[2] + dual[0] + "-" + stem;
            mascS_to_SecondD = mascSing2SecondSing[4] + dual[0] + "-" + stem;
            incD_to_MascS = firstSing2MascSing[3] + dual[0] + "-" + stem;
            excD_to_MascS = firstSing2MascSing[2] + dual[0] + "-" + stem;
            secondD_to_MascS = secondSing2MascSing[2] + dual[0] + "-" + stem;
        }
        
        switch (init) {
            case "(h)":
            case "(y)":
                first_to_SecondD = first2SecondSing[2] + dual[0] + "-" + stem.substring(3);
                second_to_FirstD = second2FirstSing[0] + dual[0] + "-" + stem.substring(3);
                incD_to_MascS = firstSing2MascSing[3] + dual[0] + "-" + stem.substring(3);
                excD_to_MascS = firstSing2MascSing[2] + dual[0] + "-" + stem.substring(3);
                secondD_to_MascS = secondSing2MascSing[2] + dual[0] + "-" + stem.substring(3);
                mascS_to_FirstD = mascSing2FirstSing[2] + dual[0] + "-" + stem.substring(3);
                mascS_to_SecondD = mascSing2SecondSing[4] + dual[0] + "-" + stem.substring(3);
                incD_to_MascS = firstSing2MascSing[3] + dual[0] + "-" + stem.substring(3);
                excD_to_MascS = firstSing2MascSing[2] + dual[0] + "-" + stem.substring(3);
                secondD_to_MascS = secondSing2MascSing[2] + dual[0] + "-" + stem.substring(3);
                break;
            case "(hy)":
                first_to_SecondD = first2SecondSing[2] + dual[0] + "-" + stem.substring(4);
                second_to_FirstD = second2FirstSing[0] + dual[0] + "-" + stem.substring(4);
                incD_to_MascS = firstSing2MascSing[3] + dual[0] + "-" + stem.substring(4);
                excD_to_MascS = firstSing2MascSing[2] + dual[0] + "-" + stem.substring(4);
                secondD_to_MascS = secondSing2MascSing[2] + dual[0] + "-" + stem.substring(4);
                mascS_to_FirstD = mascSing2FirstSing[2] + dual[0] + "-" + stem.substring(4);
                mascS_to_SecondD = mascSing2SecondSing[4] + dual[0] + "-" + stem.substring(4);
                incD_to_MascS = firstSing2MascSing[3] + dual[0] + "-" + stem.substring(4);
                excD_to_MascS = firstSing2MascSing[2] + dual[0] + "-" + stem.substring(4);
                secondD_to_MascS = secondSing2MascSing[2] + dual[0] + "-" + stem.substring(4);
                break;
            case "(h/:)":
                first_to_SecondD = first2SecondSing[2] + dual[0] + "-:" + stem.substring(5);
                second_to_FirstD = second2FirstSing[0] + dual[0] + "-:" + stem.substring(5);
                incD_to_MascS = firstSing2MascSing[3] + dual[0] + "-:" + stem.substring(5);
                excD_to_MascS = firstSing2MascSing[2] + dual[0] + "-:" + stem.substring(5);
                secondD_to_MascS = secondSing2MascSing[2] + dual[0] + "-:" + stem.substring(5);
                mascS_to_FirstD = mascSing2FirstSing[2] + dual[0] + "-:" + stem.substring(5);
                mascS_to_SecondD = mascSing2SecondSing[4] + dual[0] + "-:" + stem.substring(5);
                incD_to_MascS = firstSing2MascSing[3] + dual[0] + "-:" + stem.substring(5);
                excD_to_MascS = firstSing2MascSing[2] + dual[0] + "-:" + stem.substring(5);
                secondD_to_MascS = secondSing2MascSing[2] + dual[0] + "-:" + stem.substring(5);
                break;
        }
        
        if ("i".equals(root)) { //plural trans forms
            first_to_SecondP = first2SecondSing[2] + plural[2] + "-" + stem;
            second_to_FirstP = second2FirstSing[0] + plural[2] + "-" + stem;
            incP_to_MascS = firstSing2MascSing[4] + plural[2] + "-" + stem;
            excP_to_MascS = firstSing2MascSing[2] + plural[2] + "-" + stem;
            secondP_to_MascS = secondSing2MascSing[2] + plural[2] + "-" + stem;
            mascS_to_FirstP = mascSing2FirstSing[2] + plural[2] + "-" + stem;
            mascS_to_SecondP = mascSing2SecondSing[4] + plural[2] + "-" + stem;
            incP_to_MascS = firstSing2MascSing[4] + plural[2] + "-" + stem;
            excP_to_MascS = firstSing2MascSing[2] + plural[2] + "-" + stem;
            secondP_to_MascS = secondSing2MascSing[2] + plural[2] + "-" + stem;
        } else if ("(C)ä".equals(init2)) {
            first_to_SecondP = first2SecondSing[2] + plural[6] + "-" + stem.substring(3);
            second_to_FirstP = second2FirstSing[0] + plural[6] + "-" + stem.substring(3);
            incP_to_MascS = firstSing2MascSing[4] + plural[6] + "-" + stem.substring(3);
            excP_to_MascS = firstSing2MascSing[2] + plural[6] + "-" + stem.substring(3);
            secondP_to_MascS = secondSing2MascSing[2] + plural[6] + "-" + stem.substring(3);
            mascS_to_FirstP = mascSing2FirstSing[2] + plural[6] + "-" + stem.substring(3);
            mascS_to_SecondP = mascSing2SecondSing[4] + plural[6] + "-" + stem.substring(3);
            incP_to_MascS = firstSing2MascSing[4] + plural[6] + "-" + stem.substring(3);
            excP_to_MascS = firstSing2MascSing[2] + plural[6] + "-" + stem.substring(3);
            secondP_to_MascS = secondSing2MascSing[2] + plural[6] + "-" + stem.substring(3);
        } else if ("(y)ö".equals(init2)) {
            first_to_SecondP = first2SecondSing[2] + plural[1] + "-" + stem.substring(3);
            second_to_FirstP = second2FirstSing[0] + plural[1] + "-" + stem.substring(3);
            incP_to_MascS = firstSing2MascSing[4] + plural[1] + "-" + stem.substring(3);
            excP_to_MascS = firstSing2MascSing[2] + plural[1] + "-" + stem.substring(3);
            secondP_to_MascS = secondSing2MascSing[2] + plural[1] + "-" + stem.substring(3);
            mascS_to_FirstP = mascSing2FirstSing[2] + plural[1] + "-" + stem.substring(3);
            mascS_to_SecondP = mascSing2SecondSing[4] + plural[1] + "-" + stem.substring(3);
            incP_to_MascS = firstSing2MascSing[4] + plural[1] + "-" + stem.substring(3);
            excP_to_MascS = firstSing2MascSing[2] + plural[1] + "-" + stem.substring(3);
            secondP_to_MascS = secondSing2MascSing[2] + plural[1] + "-" + stem.substring(3);
        } else if ("CON".equals(init3)) {
            first_to_SecondP = first2SecondSing[2] + plural[0] + "-" + stem;
            second_to_FirstP = second2FirstSing[0] + plural[0] + "-" + stem;
            incP_to_MascS = firstSing2MascSing[4] + plural[0] + "-" + stem;
            excP_to_MascS = firstSing2MascSing[2] + plural[0] + "-" + stem;
            secondP_to_MascS = secondSing2MascSing[2] + plural[0] + "-" + stem;
            mascS_to_FirstP = mascSing2FirstSing[2] + plural[0] + "-" + stem;
            mascS_to_SecondP = mascSing2SecondSing[4] + plural[0] + "-" + stem;
            incP_to_MascS = firstSing2MascSing[4] + plural[0] + "-" + stem;
            excP_to_MascS = firstSing2MascSing[2] + plural[0] + "-" + stem;
            secondP_to_MascS = secondSing2MascSing[2] + plural[0] + "-" + stem;
        } else if ("RES".equals(init3)) {
            first_to_SecondP = first2SecondSing[2] + plural[0] + "-" + stem;
            second_to_FirstP = second2FirstSing[0] + plural[0] + "-" + stem;
            incP_to_MascS = firstSing2MascSing[4] + plural[0] + "-" + stem;
            excP_to_MascS = firstSing2MascSing[2] + plural[0] + "-" + stem;
            secondP_to_MascS = secondSing2MascSing[2] + plural[0] + "-" + stem;
            mascS_to_FirstP = mascSing2FirstSing[2] + plural[0] + "-" + stem;
            mascS_to_SecondP = mascSing2SecondSing[4] + plural[0] + "-" + stem;
            incP_to_MascS = firstSing2MascSing[4] + plural[0] + "-" + stem;
            excP_to_MascS = firstSing2MascSing[2] + plural[0] + "-" + stem;
            secondP_to_MascS = secondSing2MascSing[2] + plural[0] + "-" + stem;
        } 
        
        switch (init) { 
            case "i":
                first_to_SecondP = first2SecondSing[2] + plural[1] + "-" + stem.substring(1);
                second_to_FirstP = second2FirstSing[0] + plural[1] + "-" + stem.substring(1);
                incP_to_MascS = firstSing2MascSing[4] + plural[1] + "-" + stem.substring(1);
                excP_to_MascS = firstSing2MascSing[2] + plural[1] + "-" + stem;
                secondP_to_MascS = secondSing2MascSing[2] + plural[1] + "-" + stem;
                mascS_to_FirstP = mascSing2FirstSing[2] + plural[1] + "-" + stem.substring(1);
                mascS_to_SecondP = mascSing2SecondSing[4] + plural[1] + "-" + stem.substring(1);
                incP_to_MascS = firstSing2MascSing[4] + plural[1] + "-" + stem.substring(1);
                excP_to_MascS = firstSing2MascSing[2] + plural[1] + "-" + stem;
                secondP_to_MascS = secondSing2MascSing[2] + plural[1] + "-" + stem;
                break;
            case "a":
            case "e":
            case "ë":
            case "ä":
                first_to_SecondP = first2SecondSing[2] + plural[2] + "-" + stem.substring(1);
                second_to_FirstP = second2FirstSing[0] + plural[2] + "-" + stem.substring(1);
                incP_to_MascS = firstSing2MascSing[4] + plural[2] + "-" + stem.substring(1);
                excP_to_MascS = firstSing2MascSing[2] + plural[2] + "-" + stem;
                secondP_to_MascS = secondSing2MascSing[2] + plural[2] + "-" + stem;
                mascS_to_FirstP = mascSing2FirstSing[2] + plural[2] + "-" + stem.substring(1);
                mascS_to_SecondP = mascSing2SecondSing[4] + plural[2] + "-" + stem.substring(1);
                incP_to_MascS = firstSing2MascSing[4] + plural[2] + "-" + stem.substring(1);
                excP_to_MascS = firstSing2MascSing[2] + plural[2] + "-" + stem;
                secondP_to_MascS = secondSing2MascSing[2] + plural[2] + "-" + stem;
                break;
            case "o":
            case "ö":
                first_to_SecondP = first2SecondSing[2] + plural[3] + "-" + stem.substring(1);
                second_to_FirstP = second2FirstSing[0] + plural[3] + "-" + stem.substring(1);
                incP_to_MascS = firstSing2MascSing[4] + plural[3] + "-" + stem.substring(1);
                excP_to_MascS = firstSing2MascSing[2] + plural[3] + "-" + stem;
                secondP_to_MascS = secondSing2MascSing[2] + plural[3] + "-" + stem;
                mascS_to_FirstP = mascSing2FirstSing[2] + plural[3] + "-" + stem.substring(1);
                mascS_to_SecondP = mascSing2SecondSing[4] + plural[3] + "-" + stem.substring(1);
                incP_to_MascS = firstSing2MascSing[4] + plural[3] + "-" + stem.substring(1);
                excP_to_MascS = firstSing2MascSing[2] + plural[3] + "-" + stem;
                secondP_to_MascS = secondSing2MascSing[2] + plural[3] + "-" + stem;
                break;
            case "(h)":
            case "(y)":
                first_to_SecondP = first2SecondSing[2] + plural[0] + "-" + stem.substring(3);
                second_to_FirstP = second2FirstSing[0] + plural[0] + "-" + stem.substring(3);
                incP_to_MascS = firstSing2MascSing[4] + plural[0] + "-" + stem.substring(3);
                excP_to_MascS = firstSing2MascSing[2] + plural[0] + "-" + stem.substring(3);
                secondP_to_MascS = secondSing2MascSing[2] + plural[0] + "-" + stem.substring(3);
                mascS_to_FirstP = mascSing2FirstSing[2] + plural[0] + "-" + stem.substring(3);
                mascS_to_SecondP = mascSing2SecondSing[4] + plural[0] + "-" + stem.substring(3);
                incP_to_MascS = firstSing2MascSing[4] + plural[0] + "-" + stem.substring(3);
                excP_to_MascS = firstSing2MascSing[2] + plural[0] + "-" + stem.substring(3);
                secondP_to_MascS = secondSing2MascSing[2] + plural[0] + "-" + stem.substring(3);
                break;
            case "(hy)":
                first_to_SecondP = first2SecondSing[2] + plural[0] + "-" + stem.substring(4);
                second_to_FirstP = second2FirstSing[0] + plural[0] + "-" + stem.substring(4);
                incP_to_MascS = firstSing2MascSing[4] + plural[0] + "-" + stem.substring(4);
                excP_to_MascS = firstSing2MascSing[2] + plural[0] + "-" + stem.substring(4);
                secondP_to_MascS = secondSing2MascSing[2] + plural[0] + "-" + stem.substring(4);
                mascS_to_FirstP = mascSing2FirstSing[2] + plural[0] + "-" + stem.substring(4);
                mascS_to_SecondP = mascSing2SecondSing[4] + plural[0] + "-" + stem.substring(4);
                incP_to_MascS = firstSing2MascSing[4] + plural[0] + "-" + stem.substring(4);
                excP_to_MascS = firstSing2MascSing[2] + plural[0] + "-" + stem.substring(4);
                secondP_to_MascS = secondSing2MascSing[2] + plural[0] + "-" + stem.substring(4);
                break;
            case "(h/:)":
                first_to_SecondP = first2SecondSing[2] + plural[0] + "-:" + stem.substring(5);
                second_to_FirstP = second2FirstSing[0] + plural[0] + "-:" + stem.substring(5);
                incP_to_MascS = firstSing2MascSing[4] + plural[0] + "-:" + stem.substring(5);
                excP_to_MascS = firstSing2MascSing[2] + plural[0] + "-:" + stem.substring(5);
                secondP_to_MascS = secondSing2MascSing[2] + plural[0] + "-:" + stem.substring(5);
                mascS_to_FirstP = mascSing2FirstSing[2] + plural[0] + "-:" + stem.substring(5);
                mascS_to_SecondP = mascSing2SecondSing[4] + plural[0] + "-:" + stem.substring(5);
                incP_to_MascS = firstSing2MascSing[4] + plural[0] + "-:" + stem.substring(5);
                excP_to_MascS = firstSing2MascSing[2] + plural[0] + "-:" + stem.substring(5);
                secondP_to_MascS = secondSing2MascSing[2] + plural[0] + "-:" + stem.substring(5);
                break;
        }
        
        String[] PatientForms = patientPrefixes(root, stem, init, init2, init3, init4);
        String[] AgentForms = agentPrefixes(root, stem, init, init2, init3, init4);
        String[] Trans = {firstS_to_SecondS, first_to_SecondD, first_to_SecondP, 
                            second_to_FirstS, second_to_FirstD, second_to_FirstP,
                            first_to_MascS, incD_to_MascS, incP_to_MascS, excD_to_MascS,
                            excP_to_MascS, second_to_MascS, secondD_to_MascS,
                            secondP_to_MascS, mascS_to_FirstS, mascS_to_FirstD,
                            mascS_to_FirstP, mascS_to_SecondS, mascS_to_SecondD,
                            mascS_to_SecondP} ;
        String[][] TransForms = {AgentForms, PatientForms, Trans};
         return TransForms;
     }
     
     public static boolean ifCON (String character) {
        switch (character) {
            case "y":
            case "w":
            case "n":
            case "d":
            case "t":
            case "g":
            case "k":
            case "s":
            case "j":
            case "h":
            case "'":
                return true;
            default: 
                return false;
                
        }
    }
}