import java.util.ArrayList;

public class Convert {
    public static ArrayList<String> readFile(BufferWriter file) {
        ArrayList<String> result = new ArrayList<String>();
        try {
            result = file.readString();
        } catch (Exception e) {
            System.out.println("How did you find this Easter Egg, this should never print");
        }
        
        


        return result;
    }
}
