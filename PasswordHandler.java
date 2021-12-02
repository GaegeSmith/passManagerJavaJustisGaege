import java.security.SecureRandom;
//https://www.geeksforgeeks.org/random-vs-secure-random-numbers-java/

public class PasswordHandler {
    public static String pwPrompt() {
        String password = "";
        while (!checker(password)) {
            password = Useful.input("What do you want your password to be, must be 8 characters with at least one of each of these: UPPERCASE LETTER, lowercase letter, number 0-9, and special characters \"!\", \"@\", \"#\", \"$\", \"%\", \"^\", \"&\", \"(\", \")\", or type \"gen\" to generate one automagically(C): ");
            if (password.equals("gen")) {
                int len = 0;
                while (!(8 <= len && len <= 20)) {
                    len = Useful.intput("How long do you want your password, between 8 and 20 characters? ");
                }
                password = generator(len);
            }
        }
        return password;
    }
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
        //if password .length < 8 then       !contain numbers                    !contains capLetter          !contains lowLetter               !contains SpecLetter return false
        if (password.length() < 8 ||
        password.length() > 20 ||
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
        String password = "";
        System.out.println("In gen");
        boolean[] complete = new boolean[4];

        while (!checker(password)) {
            complete = Useful.boolArrSet(complete, false);
            password = "";

            for (int i = len; i > 0; i--) {
                // pick 0-3, 0 to grab random from numbers, 1 to grab random from caps, 2 grabs from low, 3 grabs from spec
                int randLst = 0;
                if (len - 5 < i) {
                    if (Useful.boolArrContains(complete, false)) {
                        randLst = Useful.boolArrFind(complete, false);
                    } else {
                        randLst = rand.nextInt(4);
                    }
                } else {
                    randLst = rand.nextInt(4);
                }

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
    }

}
