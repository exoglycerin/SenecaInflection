package seneca.inflection;

class Modals {
    
    public String[][] FutureForms(String[] punctualAgents, String[] punctualPatients) {
        String[] futAgForms = new String[15];
        String[] futPatForms = new String[15];
        String[][] futForms = {futAgForms, futPatForms};
        for (int i = 0; i < punctualAgents.length; i++) {
            switch (i){
                case 1:
                    switch (punctualAgents[i].substring(0,1)) {
                        case "j":
                            futAgForms[i] = "ë-hs" + punctualAgents[i].substring(1);
                            break;
                        case "(":
                            futAgForms[i] = "ë-h" + punctualAgents[i].substring(3);
                            break;
                    }
                    break;
                case 2:
                case 8:
                case 13:
                    futAgForms[i] = "ë-" + punctualAgents[i].substring(1); // drops the h in masc
                    break;
                case 6:
                case 11:
                    futAgForms[i] = "ë-y" + punctualAgents[i].substring(3);
                    break;
                default:
                    futAgForms[i] = "ë-" + punctualAgents[i];
                    break;
            }
        }
        
        for (int i = 0; i < punctualPatients.length; i++) {
            switch (i){
                case 0:
                    futPatForms[i] = "ë-w" + punctualPatients[i].substring(3);
                    break;
                case 3:
                    futPatForms[i] = "ë-ya" + punctualPatients[i].substring(4);
                    break;
                case 4:
                case 5:
                case 6:
                case 9:
                case 10:
                case 11:
                case 14:
                    futPatForms[i] = "ë-y" + punctualPatients[i].substring(3);
                    break;
                case 2:
                case 8:
                case 13:
                    futPatForms[i] = "ë-" + punctualPatients[i].substring(1); // drops the h in masc
                    break;
                    
                default:
                    futPatForms[i] = "ë-" + punctualPatients[i];
                    break;
            }
        }
        return futForms;
    }
    
    public String[][] HypoForms(String[] punctualAgents, String[] punctualPatients) {
        String[] hypAgForms = new String[15];
        String[] hypPatForms = new String[15];
        String[][] hypForms = {hypAgForms, hypPatForms};
        for (int i = 0; i < punctualAgents.length; i++) {
            switch (i){
                case 1:
                    if ("j".equals(punctualAgents[i].substring(0,1))) {
                        hypAgForms[i] = "aa-hs" + punctualAgents[i].substring(1); // converts j... to ëhs...
                    } else {
                        hypAgForms[i] = "aa-h" + punctualAgents[i].substring(3); // drops the (h)
                    }
                    break;
                case 2:
                case 8:
                case 13:
                    hypAgForms[i] = "aa-" + punctualAgents[i].substring(1); // drops the h in masc
                    break;
                case 6:
                case 11:
                    hypAgForms[i] = "aa-y" + punctualAgents[i].substring(3);
                    break;
                case 7:
                case 12:
                    hypAgForms[i] = "ae-" + punctualAgents[i];
                    break;
                default:
                    hypAgForms[i] = "aa-" + punctualAgents[i];
                    break;
            }
        }
        
        for (int i = 0; i < punctualPatients.length; i++) {
            switch (i){
                case 0:
                    hypPatForms[i] = "aa-w" + punctualPatients[i].substring(3);
                    break;
                case 3:
                    hypPatForms[i] = "aa-ya" + punctualPatients[i].substring(4);
                    break;
                case 4:
                case 5:
                case 6:
                case 9:
                case 10:
                case 11:
                case 14:
                    hypPatForms[i] = "aa-y" + punctualPatients[i].substring(3);
                    break;
                case 2:
                case 8:
                case 13:
                    hypPatForms[i] = "aa-" + punctualPatients[i].substring(1); // drops the h in masc
                    break;
                case 1:
                case 7:
                case 12:
                    hypPatForms[i] = "ae-" + punctualPatients[i];
                default:
                    hypPatForms[i] = "aa-" + punctualPatients[i];
                    break;
            }
        }
        return hypForms;
    }
    
    public String[][] FacForms(String[] punctualAgents, String[] punctualPatients) {
        String[] facAgForms = new String[15];
        String[] facPatForms = new String[15];
        String[][] facForms = {facAgForms, facPatForms};
        for (int i = 0; i < punctualAgents.length; i++) {
            switch (i){
                case 5:
                case 7:
                case 10:
                case 12:
                    facAgForms[i] = "e-" + punctualAgents[i];
                    break;
                case 2:
                case 8:
                case 13:
                    facAgForms[i] = "wa-" + punctualAgents[i].substring(1); // drops the h in masc
                    break;
                case 3:
                case 6:
                case 11:
                    facAgForms[i] = "wa'-" + punctualAgents[i].substring(3);
                    break;
                case 1:
                    if ("(".equals(punctualAgents[i].substring(0,1))) {
                        facAgForms[i] = "o'-" + punctualAgents[i].substring(3);
                        break;
                    }
                default:
                    facAgForms[i] = "o'-" + punctualAgents[i];
                    break;
            }
        }
        
        for (int i = 0; i < punctualPatients.length; i++) {
            switch (i){
                case 0:
                    facPatForms[i] = "ö-" + punctualPatients[i].substring(4);
                    break;
                case 1:
                case 7:
                case 12:
                    facPatForms[i] = "e-" + punctualPatients[i];
                    break;
                case 3:
                    facPatForms[i] = "wa'-a" + punctualPatients[i].substring(4);
                    break;
                case 4:
                case 5:
                case 6:
                case 9:
                case 10:
                case 11:
                case 14:
                    facPatForms[i] = "wa'-" + punctualPatients[i].substring(3);
                    break;
                case 2:
                case 8:
                case 13:
                    facPatForms[i] = "wa-" + punctualPatients[i].substring(1); // drops the h in masc
                    break;
            }
        }
        return facForms;
    }
}