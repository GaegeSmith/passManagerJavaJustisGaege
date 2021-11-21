import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;

public class Useful {

    public static String reverse(String reversee) {
        // init a result to add each letter to
        String result = "";
        // loop backwards through the string and concat the letter to result
        for (int i = reversee.length() - 1; i >= 0; i--) {
            result += reversee.substring(i, i+1);
        }
        // return result
        return result;
    }
    public static Scanner newScanner() {
        return new Scanner(System.in);
    }
    // public static int[] intputs() {
    //     Scanner ui = newScanner()
    //     String tmp = 
    // }

    public static int howMany(String s, char chr) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == chr) {
                count++;
            }
        }
        return count;
    }
    public static ArrayList<String> lets(char start, char end) {
        ArrayList<String> results = new ArrayList<String>();
        for (int i = (int) start; i <= (int) end; i++) {
            // https://stackoverflow.com/questions/8172420/how-to-convert-a-char-to-a-string
            results.add(String.valueOf((char) i));
        }
        return results;
    }
    public static class Point {
        double x;
        double y;
        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static class Line {
        Point pt0;
        Point pt1;
        Line(Point pt0, Point pt1) {
            this.pt0 = pt0;
            this.pt1 = pt1;
        }
        public double len() {
            return Math.sqrt(Math.pow((this.pt1.x - this.pt0.x), 2) + Math.pow((this.pt1.y - this.pt0.y), 2));
        }
        public Point midPnt() {
            return new Point(
                (this.pt0.x + this.pt1.x) / 2, (this.pt0.y + this.pt1.y) / 2
            );
        }

    }
}