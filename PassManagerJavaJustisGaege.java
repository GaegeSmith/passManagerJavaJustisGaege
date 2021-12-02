import java.util.ArrayList;
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

        String input = "";
        AcctStorage accounts = new AcctStorage();

        while (! input.equals("c")) {
            //System.out.println(account);
            input = Useful.input("Would you like to do (a)dd, (r)emove ,(c)lose or (d)elete? ");
            
            
            
            
            /*
            if(input.equals("a")) {
                //ask for the account info
                String cat = Useful.input("What category is this password (ex. Games, Banking, Work)? ");
                String usedAt = Useful.input("What is this account for? ");
                String username = Useful.input("What is the username? ");
                String password = Useful.input("Enter a password at least 8 characters, one uppercase letter, one lowercase letter, one number, and one of these ('!', '@', '#', '$', '%', '^', '&', '(', ')'), or type random for a random password: ");
                
                // check password entered by user, or generate random password
                while (PasswordHandler.checker(password)) {
                    if (password.equals("random")) {
                        int len = Useful.intput("Enter a length for the password (minimum 8, maximum 20: ");
                        while (len < 8 && len > 20) {
                            len = Useful.intput("Enter a length for the password (minimum 8, maximum 20: ");
                        }
                        password = PasswordHandler.generator(len);
                        break;
                    }
                    password = Useful.input("Enter a password at least 8 characters, one uppercase letter, one lowercase letter, one number, and one of these ('!', '@', '#', '$', '%', '^', '&', '(', ')'), or type random for a random password: ");
                }
                // add acount to account storage
                accounts.addAcct(usedAt, username, password, cat);
            
            } else if (input.equals("r")) { 
                System.out.println("Your Accounts are:" + accounts); //test to see if works
                
                input = Useful.input("What account would you like to remove? ");
                accounts.remove(input);

                System.out.println("Your Accounts are:" + accounts);

            } else if(input.equals("d")) {
                input = Useful.input(msg)
                accounts.clear();
                //src: https://howtodoinjava.com/java/collections/arraylist/empty-clear-arraylist/
            } else if(input.equals("c")) {
                input = Useful.input(msg)
                //.join is going to join the listArray with , 
                //src: https://stackoverflow.com/questions/599161/best-way-to-convert-an-arraylist-to-a-string
                //String accountsList = String.join(",",accounts);
                //https://stackoverflow.com/questions/942326/calling-static-method-on-a-class and bander 
                System.out.println("Are you sure?");
                input = Useful.input(msg)
                if(input.equals("yes")) { 
                    String accountsList = String.join(",", accounts);
                    String cateorgyList = String.join(",", cateorgy);

                    //variable to format the write string named output d
                    String output = ("Acccount:"+accountsList+"\n"+"Cateorgys:"+cateorgyList);
                    // BufferWriter.writeString(output);
                    // BufferWriter.saveAndClose(); 
                    System.exit(0);
                }
                //still needs the save portion 
            }
            */
        }
        accounts.saveAndClose();
    }
}