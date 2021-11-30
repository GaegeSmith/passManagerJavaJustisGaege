import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
            this.readString();
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
    public String readString() throws Exception {
        String urMom = null;
        if (this.in == null) {
            // try {
                this.in = new Scanner(new File(this.dataFile));
            // } catch (Exception e) {
            //     System.err.println("Cannot open file!");
            //     e.printStackTrace();
            // }
        }

        // try {
            // check if in hasNext line
            if (this.in.hasNext()) {
                String s = this.in.nextLine();
                return s; // grabing everything
            }
        // } catch (Exception e) {
        //     System.err.println("I cannot read!");
        //     e.printStackTrace();
        // }

        return urMom;
    }
}
