import java.util.ArrayList;
import java.util.Scanner;
public class PassManagerJavaJustisGaege {

    public static void main(String[] args) {
        /* TODO:
            Account
                whereIsUsed & username & password

                class Hat {
                    int size;
                    String color;
                    Hat(int size, String color){
                        this.size = size;
                        this.color = color;
                    }
                }

            PasswordHandler
                Done-> passwordChecker
                Needs to be checked sike not done -> passwordGenerator

            logIn/acctCreation
                check for pre-existing profile
                if none exists, create new
                    first & last name, username, password, make a hint for your login
                    login
                if exists, login
                    username & password
                    3 tries
                    hint happens
                    2 tries
                    close app

                //Started this portion of the code :) still working on the save portion of ("c")
            internal commands
                add
                    add an account/category
                remove
                    remove an account, if a catagory is empty, it will delete at the next save
                save
                    save current state
                close
                    save and end the program
                delete profile
                    delete entire profile
                
        */

        Scanner in = new Scanner(System.in);
        String input = "";
        int pos;
        //need to add in a new List for the animal one <-- Done     
        ArrayList<String> accounts = new ArrayList<String>();
        ArrayList<String> cateorgy = new ArrayList<String>();
        
        while (! input.equals("c")){
            //System.out.println(account);
            System.out.println("Would you like to do (a)dd, (r)emove ,(c)lose or (d)elete");
            input = in.nextLine();
            
            if(input.equals("a")){
                //ask for the account name then add it to the list 
                System.out.println("What is your Account Name?");    
                input = in.nextLine();
                accounts.add(input);
                System.out.println("Your account name is: " + accounts); //test remove when gaege gets it done 
            
            } else if (input.equals("r")){ 
                System.out.println("Your Accounts are:" + accounts); //test to see if works
                System.out.println("What account would you like to remove?");
                input =in.nextLine();
                accounts.remove(input);
                System.out.println("Your Accounts are:" + accounts);
            } else if(input.equals("d")){
                input = in.nextLine();
                accounts.clear();
                //src: https://howtodoinjava.com/java/collections/arraylist/empty-clear-arraylist/
            } else if(input.equals("c")){
                input = in.nextLine();
                //.join is going to join the listArray with , 
                //src: https://stackoverflow.com/questions/599161/best-way-to-convert-an-arraylist-to-a-string
                //String accountsList = String.join(",",accounts);
                //https://stackoverflow.com/questions/942326/calling-static-method-on-a-class and bander 
                System.out.println("Are you sure?");
                input = in.nextLine();
                if(input.equals("yes")){ 
                    String accountsList = String.join(",",accounts);
                    String cateorgyList = String.join(",",cateorgy);

                    //variable to format the write string named output d
                    String output= ("Acccount:"+accountsList+"\n"+"Cateorgys:"+cateorgyList);
                    // BufferWriter.writeString(output);
                    // BufferWriter.saveAndClose(); 
                    System.exit(0);
                }
                else if (input.equals("no")){

                }
                //still needs the save portion 
            }
        }
    }
}