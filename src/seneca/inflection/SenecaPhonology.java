package seneca.inflection;

public class SenecaPhonology {
      
    public String SenecaOrthography(String word) {
        word = "#" + word + "#";
        int k = word.indexOf("k");
        while (k != -1) { //if there is a k
            if ("h".equals(word.substring(k+1,k+2))) {
                word = removeCharAt(word, k+1);
            } else {
                word = replaceCharAt(word, "g", k);
            }
            k = word.indexOf("k", k + 1);
        }
        int t = word.indexOf("t");
        while (t != -1) { //if there is a k
            if ("h".equals(word.substring(t+1,t+2))) {
                word = removeCharAt(word, t+1);
            } else {
                word = replaceCharAt(word, "d", t);
            }
            t = word.indexOf("t", t + 1);
        }
        
        word = word.replace("sy", "š");
        word = word.substring(1, word.length() - 1); // this removes the #s
        String first = word.substring(0,1); // this drops off any parenthesized segments
        if ("(".equals(first)) {
           if (")".equals(word.substring(2,3))) {
               word = word.substring(3);
           } else if (")".equals(word.substring(3,4))) {
               word = word.substring(4);
           } else if (")".equals(word.substring(4,5))) {
               word = word.substring(5);
           }
       }
        word = word.replace("0", "");
        return word;
    }
    
    public String SenecaPhonology(String argument) {
        argument = "#" + argument + "#"; // this adds word boundary characters (need to be removed later)
        // rule 3.3 
        //d || g > 0 / _s(C|#)
        int dsCON = argument.indexOf("ts"); //the index will be of the d
        while (dsCON != -1) { // if it finds the sequence ds
            if ("#".equals(argument.substring(dsCON + 2, dsCON + 3))) { // if ds is followed by #
                argument = removeCharAt(argument, dsCON); // this will remove the d
            } else if (ifCON(argument.substring(dsCON + 2, dsCON + 3))) { //this will check whether a consonant follows the s 
                argument = removeCharAt(argument, dsCON); // this will remove the d
            }
            dsCON = argument.indexOf("ts", dsCON + 2); // this checks for more sequences of ds
        } 
        int gsCON = argument.indexOf("ks"); //the index of g
        while (gsCON != -1) { // if it finds the sequence gs
            if ("#".equals(argument.substring(gsCON + 2, gsCON + 3))) { // if ds is followed by #
                argument = removeCharAt(argument, gsCON); // this will remove the d
            } else if (ifCON(argument.substring(gsCON + 2, gsCON + 3))) { //this will check whether a consonant follows the s 
                argument = removeCharAt(argument, gsCON); // this will remove the d
            }
            gsCON = argument.indexOf("ks", gsCON + 2); // this checks for more sequences of ds
        }
        
        // rule 3.10 (must apply before rules 3.4 & 3.6
        // R > 0 / _C
        //       / _#
        for (int i = 0; i < (argument.length() - 1); i++) { //sets up a for loop the length of the argument
            if (ifRES(argument.substring(i,i+1))) { // checks char at i if RES
                if (ifOBS(argument.substring(i+1,i+2))) { // checks char following i if OBS
                    argument = removeCharAt(argument, i); // remove the RES
                } else if ("#".equals(argument.substring(i+1,i+2))) { // Checks to see if RES is word final
                    argument = removeCharAt(argument, i); // remove the RES
                    i = 0;
                }
            }
        } 
        
        // rule 3.4
        // d|g > 0 / (d|g|s)_#
        int dEND = argument.indexOf("t#"); 
        if (dEND != -1) { // if there is a sequence of d#
            switch (argument.substring(dEND-1, dEND)) { // if it is preceded by d, g, or s
            case "t":
            case "k":
            case "s":
                argument = removeCharAt(argument, dEND); // remove d
            }
        }
        int gEND = argument.indexOf("k#"); //as above
        if (gEND != -1) {
            switch (argument.substring(gEND-1, gEND)) {
            case "t":
            case "k":
            case "s":
                argument = removeCharAt(argument, gEND);
            }
        }
        
        //rule 3.5
        // d > h /  V_n
        int dn = argument.indexOf("tn");
        while (dn != -1) { // if there is a sequence of dn
            if (ifVOW(argument.substring(dn-1, dn))) { // if this is preceded by a vowel
                argument  = replaceCharAt(argument, "h", dn); //converts the d to h
            } 
            dn = argument.indexOf("tn", dn + 2);
        }
        
        //rule 3.6
        // h > 0 / _CC
        //       / _C#  the k and t are interpreted as gh and dh
        int h = argument.indexOf("h"); // this gives the first index of h
        while (h != -1) { //if there are any h's yet untried
            if (ifOBS(argument.substring(h+1,h+2))) {
                if (ifOBS(argument.substring(h+2,h+3))) { // if the h is followed by two obstruents
                    argument = removeCharAt(argument, h); // remove the h
                } else if ("#".equals(argument.substring(h+2,h+3))) { // if the h is followed by an obstruent and word boundary
                    argument = removeCharAt(argument, h); // remove the h
                } 
            } 
            h = argument.indexOf("h",h+1); 
        }
        
        //rule 3.7
        // h > 0 / O_O
        //       / _sn
        //       / #_y
        h = argument.indexOf("h");
        while (h != -1) {
            if (ifOBS(argument.substring(h-1,h))) { // if the h is preceded by an obstruent
                if (ifOBS(argument.substring(h+1,h+2))) { // if the h is followed by an obstruent
                    argument = removeCharAt(argument, h); // remove the h
                }
            } else if ("s".equals(argument.substring(h+1,h+2))) { // if the h is followed by an s
                if ("n".equals(argument.substring(h+2,h+3))) { // if the s is followed by an n
                    argument = removeCharAt(argument, h); // remove the h
                }
            } else if ("y".equals(argument.substring(h+1,h+2))) { // if the h is followed by a y
                if ("#".equals(argument.substring(h-1,h))) { // if the h is preceded by a word boundary
                    argument = removeCharAt(argument, h); // remove the h
                }
            }
            h = argument.indexOf("h", h+1);
        }
        
        //rule 3.8
        // (h|') > 0 / s_R
        h = argument.indexOf("h");
        while (h != -1) {
            if ("s".equals(argument.substring(h-1,h))) { // if the h is preceded by an s
                if (ifRES(argument.substring(h+1,h+2))) { // if the h is followed by a resonant
                    argument = removeCharAt(argument, h); // remove the h
                }
            }
            h = argument.indexOf("h",h+1);
        }
        int glottal = argument.indexOf("'");
        while (glottal != -1) {
            if ("s".equals(argument.substring(glottal -1, glottal))) { // if the h is preceded by an s
                if (ifRES(argument.substring(glottal +1, glottal +2))) { // if the h is followed by a resonant
                    argument = removeCharAt(argument, glottal); // remove the h
                }
            }
            glottal = argument.indexOf("'", glottal +1);
        }
        
        //rule 3.9
        // k > kh / _n
        argument = argument.replace("kn", "khn");
        
        //rule 3.11
        //y > 0 / C_i
        int y = argument.indexOf("y");
        while (y != -1) {
           if (ifCON(argument.substring(y-1,y))) {
                if ("i".equals(argument.substring(y+1,y+2))) {
                    argument = removeCharAt(argument,y);
                }
           }
           y = argument.indexOf("y", y+1);
        }
        
        
        //rule 3.12
        // w > 0 / C_(o|ö)
        for(int i = 0; i < argument.length(); i++) {
            if("w".equals(argument.substring(i,i+1))) {
                if (ifCON(argument.substring(i-1,i))) {
                    switch (argument.substring(i+1,i+2)) {
                        case "o":
                        case "ö":
                            argument = removeCharAt(argument, i);
                    }
                }
            }
        }
        
        
        //rule 3.13
        // w > y / V_(o|ö)
        for(int i = 0; i < argument.length(); i++) {
            if("w".equals(argument.substring(i,i+1))) {
                if (ifVOW(argument.substring(i-1,i))) {
                    switch (argument.substring(i+1,i+2)) {
                        case "o":
                        case "ö":
                            argument = replaceCharAt(argument, "y", i);
                    }
                }
            }
        }
                
        //rule 3.14
        // a > ö / (n|ë|ö|ëw|öw|ësw|ösw|ë'w|ö'w|ë'|ö'|ëh|öh)_
        //rule 3.15
        // skip rule 3.14 /_(o|'o|'a|:yo|:ya)
        
        for (int i = 0; i < argument.length(); i++) {
            if ("a".equals(argument.substring(i,i+1))) { // if i == a
                if (argument.length() > i+3) { // if a is followed by 3 char
                    if (":yo".equals(argument.substring(i+1,i+4))) { // cases for not converting
                    } else if (":ya".equals(argument.substring(i+1,i+4))) {
                    } else if ("'ö".equals(argument.substring(i+1,i+3))) {
                    } else if ("'a".equals(argument.substring(i+1,i+3))) {
                    } else if ("o".equals(argument.substring(i+1,i+2))) {
                    } else {
                        if (i>3) {
                            switch(argument.substring(i-3,i)) {
                                case "ësw":
                                case "ösw":
                                case "ë'w":
                                case "ö'w":
                                    argument = replaceCharAt(argument, "ö", i);
                                default:
                                    break;
                            }
                            switch(argument.substring(i-2,i)) {
                                case "ëw":
                                case "öw":
                                case "ë'":
                                case "ö'":
                                case "ëh":
                                case "öh":
                                    argument = replaceCharAt(argument, "ö", i);
                                default:
                                    break;
                            }
                            switch(argument.substring(i-1,i)) {
                                case "n":
                                case "ë":
                                case "ö":
                                    argument = replaceCharAt(argument, "ö", i);
                                default:
                                    break;
                            }
                        } else if (i>2) {
                            switch(argument.substring(i-2,i)) {
                                case "ëw":
                                case "öw":
                                case "ë'":
                                case "ö'":
                                case "ëh":
                                case "öh":
                                    argument = replaceCharAt(argument, "ö", i);
                                default:
                                    break;
                            }
                            switch(argument.substring(i-1,i)) {
                                case "n":
                                case "ë":
                                case "ö":
                                    argument = replaceCharAt(argument, "ö", i);
                                default:
                                    break;
                            }
                        } else if (i>1) {
                            switch(argument.substring(i-1,i)) {
                                case "n":
                                case "ë":
                                case "ö":
                                    argument = replaceCharAt(argument, "ö", i);
                                default:
                                    break;
                            }
                        }
                    }
                } else if (argument.length() > i+2) {
                    if ("'ö".equals(argument.substring(i+1,i+3))) { // cases for not converting
                    } else if ("'a".equals(argument.substring(i+1,i+3))) {
                    } else if ("o".equals(argument.substring(i+1,i+2))) {
                    } else {
                        if (i>3) {
                            switch(argument.substring(i-3,i)) {
                                case "ësw":
                                case "ösw":
                                case "ë'w":
                                case "ö'w":
                                    argument = replaceCharAt(argument, "ö", i);
                                default:
                                    break;
                            }
                            switch(argument.substring(i-2,i)) {
                                case "ëw":
                                case "öw":
                                case "ë'":
                                case "ö'":
                                case "ëh":
                                case "öh":
                                    argument = replaceCharAt(argument, "ö", i);
                                default:
                                    break;
                            }
                            switch(argument.substring(i-1,i)) {
                                case "n":
                                case "ë":
                                case "ö":
                                    argument = replaceCharAt(argument, "ö", i);
                                default:
                                    break;
                            }
                        } else if (i>2) {
                            switch(argument.substring(i-2,i)) {
                                case "ëw":
                                case "öw":
                                case "ë'":
                                case "ö'":
                                case "ëh":
                                case "öh":
                                    argument = replaceCharAt(argument, "ö", i);
                                default:
                                    break;
                            }
                            switch(argument.substring(i-1,i)) {
                                case "n":
                                case "ë":
                                case "ö":
                                    argument = replaceCharAt(argument, "ö", i);
                                default:
                                    break;
                            }
                        } else if (i>1) {
                            switch(argument.substring(i-1,i)) {
                                case "n":
                                case "ë":
                                case "ö":
                                    argument = replaceCharAt(argument, "ö", i);
                                default:
                                    break;
                            }
                        }
                    }
                } else if (argument.length() > i+1) { // cases for not converting
                    if ("o".equals(argument.substring(i+1,i+2))) {
                    } else {
                        if (i>3) {
                            switch(argument.substring(i-3,i)) {
                                case "ësw":
                                case "ösw":
                                case "ë'w":
                                case "ö'w":
                                    argument = replaceCharAt(argument, "ö", i);
                                    break;
                                default:
                                    break;
                            }
                            switch(argument.substring(i-2,i)) {
                                case "ëw":
                                case "öw":
                                case "ë'":
                                case "ö'":
                                case "ëh":
                                case "öh":
                                    argument = replaceCharAt(argument, "ö", i);
                                    break;
                                default:
                                    break;
                            }
                            switch(argument.substring(i-1,i)) {
                                case "n":
                                case "ë":
                                case "ö":
                                    argument = replaceCharAt(argument, "ö", i);
                                    break;
                                default:
                                    break;
                            }
                        } else if (i>2) {
                            switch(argument.substring(i-2,i)) {
                                case "ëw":
                                case "öw":
                                case "ë'":
                                case "ö'":
                                case "ëh":
                                case "öh":
                                    argument = replaceCharAt(argument, "ö", i);
                                    break;
                                default:
                                    break;
                            }
                            switch(argument.substring(i-1,i)) {
                                case "n":
                                case "ë":
                                case "ö":
                                    argument = replaceCharAt(argument, "ö", i);
                                    break;
                                default:
                                    break;
                            }
                        } else if (i>1) {
                            switch(argument.substring(i-1,i)) {
                                case "n":
                                case "ë":
                                case "ö":
                                    argument = replaceCharAt(argument, "ö", i);
                                break;
                                default:
                                    break;
                            }
                        }
                    }
                } else if (i>3) {
                    switch(argument.substring(i-3,i)) {
                        case "ësw":
                        case "ösw":
                        case "ë'w":
                        case "ö'w":
                            argument = replaceCharAt(argument, "ö", i);
                            break;
                        default:
                            break;
                    }
                    switch(argument.substring(i-2,i)) {
                        case "ëw":
                        case "öw":
                        case "ë'":
                        case "ö'":
                        case "ëh":
                        case "öh":
                            argument = replaceCharAt(argument, "ö", i);
                            break;
                        default:
                            break;
                    }
                    switch(argument.substring(i-1,i)) {
                        case "n":
                        case "ë":
                        case "ö":
                            argument = replaceCharAt(argument, "ö", i);
                            break;
                        default:
                            break;
                        }
                } else if (i>2) {
                    switch(argument.substring(i-2,i)) {
                        case "ëw":
                        case "öw":
                        case "ë'":
                        case "ö'":
                        case "ëh":
                        case "öh":
                            argument = replaceCharAt(argument, "ö", i);
                            break;
                        default:
                            break;
                        }
                    switch(argument.substring(i-1,i)) {
                        case "n":
                        case "ë":
                        case "ö":
                            argument = replaceCharAt(argument, "ö", i);
                            break;
                        default:
                            break;
                    }
                } else if (i>1) {
                    switch(argument.substring(i-1,i)) {
                        case "n":
                        case "ë":
                        case "ö":
                            argument = replaceCharAt(argument, "ö", i);
                            break;
                        default:
                            break;
                            }
                        }
            }
        }
               
        
        //rule 3.16 & 3.18
        // ë > e / _(o|e|:e)
        // ë > i / _(i|:i)
        for (int i = 0; i < argument.length(); i++) {
            if("ë".equals(argument.substring(i,i+1))) {
                if(argument.length() > i +3) {
                    switch (argument.substring(i+1,i+3)) {
                        case ":e":
                            argument = replaceCharAt(argument, "e", i);
                            break;
                        case ":i":
                            argument = replaceCharAt(argument, "i", i);
                            break;
                        default:
                            break;
                    }
                    switch (argument.substring(i+1,i+2)) {
                        case "o":
                        case "e":
                            argument = replaceCharAt(argument, "e", i);
                            break;
                        case "i":
                            argument = replaceCharAt(argument, "i", i);
                            break;
                        default:
                            break;
                    }
                } else if (argument.length() > i + 2) {
                    switch (argument.substring(i+1,i+2)) {
                        case "o":
                        case "e":
                            argument = replaceCharAt(argument, "e", i);
                            break;
                        case "i":
                            argument = replaceCharAt(argument, "i", i);
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        
        //rule 3.17
        // ö > o / _o
        for(int i = 0; i < argument.length(); i++) {
            if("ö".equals(argument.substring(i,i+1))) {
                if(argument.length() > i +2) {
                    if("o".equals(argument.substring(i+1,i+2))) {
                        argument = replaceCharAt(argument, "o", i);
                    }
                }
            }
        }
        
        //rule 3.19
        // V > V: / V(same)_
        for(int i = 0; i < argument.length(); i++) {
            if(ifVOW(argument.substring(i,i+1))) {
                if(argument.substring(i-1,i).equals(argument.substring(i,i+1))) {
                    argument = replaceCharAt(argument, ":", i);
                } 
            }
        }
        //rule 3.20
        // V: > :V / V_
        
        //rule 3.21
        // : > 0 / VV_(C)V(C)V(C)
        //       / V_V(C)V(C)V(C)
        
        //rule 3.22
        // : > 0 / :-V_
        
        //rule 3.23
        // V'V > 'VV but not VV'V > V'VV
        
        argument = argument.substring(1, argument.length() - 1); // this removes the #s
        return argument;
    }
    
    public static String removeCharAt(String s, int pos) {
        return s.substring(0,pos) + s.substring(pos + 1);
    }
    public static String replaceCharAt(String s, String insert, int pos) {
        return s.substring(0,pos) + insert + s.substring(pos+1);
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
    
    public static boolean ifVOW (String character) {
        switch (character) {
            case "i":
            case "e":
            case "ë":
            case "ä":
            case "o":
            case "ö":
            case "a":
            case ":":
                return true;
            default:
                return false;
        }
    }
    
    public static boolean ifOBS (String character) {
        switch (character) {
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
    
    public static boolean ifRES (String character) {
        switch (character) {
            case "y":
            case "w":
            case "n":
                return true;
            default: 
                return false;
                
        }
    }
    
    
}