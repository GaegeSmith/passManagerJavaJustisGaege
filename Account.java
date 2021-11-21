import java.util.ArrayList;
import java.util.Scanner;
public class Account {
    // stores each account the user saves, stores the place where it is used (website, app, etc.), username, password
    String usedAt;
    String username;
    String password;

    Account(String usedAt, String username, String password) {
        this.usedAt = usedAt;
        this.username = username;
        this.password = password;
    }
    Scanner in = new Scanner(System.in);
    String input = "";
    int pos;
    //need to add in a new List for the animal one <-- Done     
    ArrayList<String> accounts = new ArrayList<String>();
    while (! input.equals("q")){
        //System.out.println(account);
        System.out.println("Would you like to (a)dd, r(emove) , s(ave), ,c(lose) ,d(elete) or (q)uit");

        input = in.nextLine();
        
        if(input.equals("a")){
            System.out.println("Add an account/cateorgy");
            input = in.nextLine();
            account.add(input);
        }
        
        else if (input.equals("r")){ 
            System.out.println("Enter account/cateorgy you want to remove:");
            input = in.nextLine();
            account.remove(input);
        }

        else if (input.equals("c")){
            System.out.println("Are you sure?");
            input = in.nextLine();
            if(input.equals("yes")){
                account.clear();
            }
        }
        
        else if(input.equals("d")){
            input = in.nextLine();
            account.clear(input); //using clear instead of remove cause it clears the list/elements 
            //src: https://stackoverflow.com/questions/6548157/how-to-write-an-arraylist-of-strings-into-a-text-file
            FileWriter writer = new FileWriter("output.txt"); 
            for(String str: arr) {
                writer.write(str + System.lineSeparator());
            }
                writer.close();
            //src: https://howtodoinjava.com/java/collections/arraylist/empty-clear-arraylist/
        }
        else if(input.equals("c")){
            input = in.nextLine();
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


    
}
