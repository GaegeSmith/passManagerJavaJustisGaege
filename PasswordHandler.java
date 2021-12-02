import java.security.SecureRandom;
//https://www.geeksforgeeks.org/random-vs-secure-random-numbers-java/

public class PasswordHandler {
    public static boolean checker(String password){

        String[] numbers = Useful.letsArr('0', '9');
        String[] capLetter = Useful.letsArr('A', 'Z');
        String[] lowLetter = Useful.letsArr('a', 'z');
        String[] specChars = Useful.specialCharsArr();

        
        //Good Password return True
        //Bad Password return Bad 
        //length:8, 
        //contains atleast one :["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p","q", "r", "s", "t", "u", "v", "w", "x", "y", "z"]
        // ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"] 
        //["!", "@", "#", "$", "%", "^", "&", "(", ")"]
        //if password .length <= 8 then       !contain numbers                    !contains capLetter          !contains lowLetter               !contains SpecLetter return false
        if (password.length() <= 8 ||
        !contains(password, numbers) ||
        !contains(password, capLetter) ||
        !contains(password, lowLetter) ||
        !contains(password, specChars)){
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

    public static String generator(int len){
        SecureRandom rand = new SecureRandom();
        String[] numbers = Useful.letsArr('0', '9');
        String[] capLetter = Useful.letsArr('A', 'Z');
        String[] lowLetter = Useful.letsArr('a', 'z');
        String[] specChars = Useful.specialCharsArr();    
        boolean[] complete = new boolean[4];
        String password = "";
        System.out.println("In gen");
        while (Useful.boolArrContains(complete, false)) {
            complete = Useful.boolArrSet(complete, false);
            System.out.println("pass " + password);
            password = "";
            for (int i = 0; i < len; i++) {
                System.out.println(complete.toString());
                // pick 0-3, 0 to grab random from numbers, 1 to grab random from caps, 2 grabs from low, 3 grabs from spec
                int randLst = rand.nextInt(4);
                switch (randLst) {
                    case 0:
                        password += numbers[rand.nextInt(numbers.length)];
                        complete[0] = true;
                        break;
                    case 1:
                        password += capLetter[rand.nextInt(capLetter.length)];
                        complete[1] = true;
                        break;
                    case 2:
                        password += lowLetter[rand.nextInt(lowLetter.length)];
                        complete[2] = true;
                        break;
                    case 3:
                        password += specChars[rand.nextInt(specChars.length)];
                        complete[3] = true;
                        break;
                }
                


            }

        }







        return password;
        
    

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


}

