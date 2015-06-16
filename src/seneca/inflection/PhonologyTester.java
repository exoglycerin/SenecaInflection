package seneca.inflection;

class PhonologyTester {
    
    public static void main(String[] args) {
        SenecaPhonology phonology = new SenecaPhonology();
        String test = "öo";
        test = phonology.SenecaOrthography(phonology.SenecaPhonology(test));
        System.out.println(test);
        String test1 = "kakhatathasya";
        test1 = phonology.SenecaOrthography(test1);
        System.out.println(test1);
    }
}