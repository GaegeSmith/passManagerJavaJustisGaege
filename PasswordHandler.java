public class PasswordHandler {
    public static boolean checker(String password){
        String[] numbers ={"0", "1", "2", "3", "4", "5","6", "7", "8", "9" };
        String[] capLetter ={"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String[] lowLetter ={"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p","q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String[] specLetter = {"!", "@", "#", "$", "%", "^", "&", "(", ")"};
        
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
    public static boolean generator(){
        
        return true;
        

    }
    
    

    
}
