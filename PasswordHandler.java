import java.util.Random;
import java.security.SecureRandom;
//https://www.geeksforgeeks.org/random-vs-secure-random-numbers-java/
import java.security.SecureRandom;
public class PasswordHandler {
    public static boolean checker(String password){
        String[] numbers ={"0", "1", "2", "3", "4", "5","6", "7", "8", "9" };
        String[] capLetter ={"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String[] lowLetter ={"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p","q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String[] specLetter = {"!", "@", "#", "$", "%", "^", "&", "(", ")"};
        generator();
        
        //Good Password return True
        //Bad Password return Bad 
        //length:8, 
        //contains atleast one :["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p","q", "r", "s", "t", "u", "v", "w", "x", "y", "z"]
        // ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"] 
        //["!", "@", "#", "$", "%", "^", "&", "(", ")"]
        //if password .length <8 then       !contain numbers                    !contains capLetter          !contains lowLetter               !contains SpecLetter return false
        if (password.length()<8 || !contains(password, numbers) || !contains(password, capLetter) || !contains(password, lowLetter) || !contains(password, specLetter)){
            return false;
        }
        //if it works then return true 
        return true;
        
    }   
    //Array                            //Pulling in password and arr
    public static boolean contains(String password, String[] arr){
        
        for(int i=0;i<arr.length;i++){
            //if the password contains arr then return true 
            if(password.contains(arr[i])){
                return true;
            }
        }
        //if it does not work then return false 
        return false;
            
    }
    // Method to generate a random alphanumeric password of a specific length

    public static String generator(){
        //String[] chars  = {"0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnoqrstuvwxy!@#$%^&()"};
        //src: https://stackoverflow.com/questions/19743124/java-password-generator/41891760 

        String password = new Random().ints(10, 33, 122).collect(StringBuilder::new,
        StringBuilder::appendCodePoint, StringBuilder::append).toString();

        // using secure random for a cryptographically strong random number generator.
        // SecureRandom random = new SecureRandom();
        // for (int i = 0; i < len; i++){
        //     //getting the random next Int inside of the chars list 
        //     int randomIndex = random.nextInt(chars.length);
        //     //charAt  returns a character at a specific index position in a string  
        //     sb.append(chars.charAt(randomIndex));
        // }
 
        //return sb.toString();
    }
 
    public static void main(String[] args)
    {
        int len = 10;
        System.out.println(generator(len));
    }

        
    }