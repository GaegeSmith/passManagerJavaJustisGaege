import java.util.ArrayList;

public class Crypting {
    // vigenère cipher with username and password
    // sci show video https://youtu.be/-yFZGF8FHSg?t=180
    ArrayList<String> acceptable;
    ArrayList<ArrayList<String>> cipherTable;
    String key;
    Crypting(String key) {
        this.key = key;
        this.acceptable = genAcceptable();
        this.cipherTable = genCipherTable();
    }
    public static ArrayList<ArrayList<String>> genCipherTable() {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        
        


        return result;

    }

    public static ArrayList<String> genAcceptable() {
        ArrayList<String> results = new ArrayList<String>();
        for (String i : Useful.lets('a', 'z')) {results.add(i);}
        for (String i : Useful.lets('A', 'Z')) {results.add(i);}
        for (String i : Useful.lets('0', '9')) {results.add(i);}
        for (String i : Useful.specialChars()) {results.add(i);}
        return results;
    }
}
