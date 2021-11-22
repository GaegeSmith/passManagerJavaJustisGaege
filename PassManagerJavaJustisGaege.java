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
                Needs to be checked-> passwordGenerator

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
        while (! input.equals("q")){
            //System.out.println(account);
            System.out.println("Would you like to (a)dd, (r)emove , (s)ave, ,(c)lose ,(d)elete or (q)uit");
            input = in.nextLine();
            
            if(input.equals("a")){
                System.out.println("Add an account/cateorgy");
                input = in.nextLine();
                accounts.add(input);
            }
            
            else if (input.equals("r")){ 
                System.out.println("Enter account/cateorgy you want to remove (Exact Account/Cateorgy Name):");
                input = in.nextLine();
                //ask the ui the account they want removed has to be exact string

                accounts.remove(input);
            }
    
            else if (input.equals("c")){
                System.out.println("Are you sure?");
                input = in.nextLine();
                if(input.equals("yes")){
                    accounts.clear();
                }
            }
            
            else if(input.equals("d")){
                input = in.nextLine();
                accounts.clear();
                //src: https://howtodoinjava.com/java/collections/arraylist/empty-clear-arraylist/
            }
            else if(input.equals("c")){
                input = in.nextLine();
                //.join is going to join the listArray with , 
                //src: https://stackoverflow.com/questions/599161/best-way-to-convert-an-arraylist-to-a-string
                String accountsList = String.join(",",accounts);
                BufferWriter.writeString(accountsList); 
                System.exit(0);
                //still needs the save portion 
            }
            //Insert Portion 
            // else if (input.equals("i")){
            //     System.out.println("Enter an anmial:");
            //     input = in.nextLine();
            //     System.out.println("Enter an pos:");
            //     pos = in.nextInt();
            //     //add.(position,item);
            //     if(pos>0 && pos<account.size()){
            //         account.add(pos-1,input);
    
            //     }
    
            // }
    
            //Replace Portion
            // else if (input.equals("p")){
            //     System.out.println("Enter an anmial:");
            //     input = in.nextLine();
            //     System.out.println("Enter an pos:");
            //     pos = in.nextInt();
            //     //add.(position,item);
            //     if(pos>0 && pos<account.size()){
            //         account.set(pos-1,input);
    
            //     }
    
            // }
            
        }
    }
}