import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class BufferWriter {
    
    // global variables
    public String dataFile;
    private Scanner in;
    private BufferedWriter out;
    BufferWriter(String fileName) {
        this.dataFile = fileName;
    }
    // trys to read from the file, if the reading errors return false, file no existo, if it works return true, file does indeed exist
    public boolean exists() {
        try {
            Scanner tmp = new Scanner(new FileReader(this.dataFile));
            tmp.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    // writeString
    public void writeString(String s) {
        // check to see if out is assigned
        if (this.out == null) {
            try {
                this.out = new BufferedWriter(new FileWriter(this.dataFile));
            } catch (Exception e) {
                System.err.println("Cannot open file for output!");
                e.printStackTrace();
            }
        }

        try {
            this.out.write(s);
            this.out.newLine();
        } catch (Exception e) {
            System.err.println("Cannot write file!");
            e.printStackTrace();
        }
    }
    
    // saveAndClose
    public void saveAndClose() {
        // closes after the Scanner is done reading flie
        if (this.in != null) {
            try {
                this.in.close();
                this.in = null;
            } catch (Exception e) {
                System.err.println("Cannot close input file!");
                e.printStackTrace();
            }
        }

        // closes after the BufferedWriter is done writing to the file
        if (this.out != null) {
            try {
                this.out.close();
                this.out = null;
            } catch (Exception e) {
                System.err.println("Cannot close output file!");
                e.printStackTrace();
            }
        }
    }
    
    // readString
    public ArrayList<String> readString() throws FileNotFoundException {
        ArrayList<String> urMom = new ArrayList<String>();
        if (this.in == null) {
            this.in = new Scanner(new FileReader(this.dataFile));
        }
        // System.out.println(this.in.hasNext());
        // while there are lines left
        while (this.in.hasNext()) {
            // add the next line to the results
            urMom.add(this.in.nextLine());
        }
        return urMom;
    }
}
