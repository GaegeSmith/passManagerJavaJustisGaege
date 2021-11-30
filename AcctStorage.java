import java.util.ArrayList;

public class AcctStorage {
    private ArrayList<Account> accounts = new ArrayList<Account>();
    private User user;
    private BufferWriter userFile = new BufferWriter("user.txt");
    public AcctStorage() {
        // if a file for an account exists
        if (userFile.exists()) {
            // read the user file
            try {
                userFile.readString();
            } catch (Exception e) {
                System.out.println("How did you find this Easter Egg, this should never print");
            }
            
            // login
            if (!this.user.login()) {
                System.out.println("Sorry, you have failed the login process to many times.");
                System.exit(0);
            }
        } else {
            // create acct

            // login
            if (!this.user.login()) {
                System.out.println("Sorry, you have failed the login process to many times.");
                System.exit(0);
            }
        }
    }
    
    public void addAcct(String usedAt, String username, String password, String category) {
        accounts.add(new Account(usedAt, username, password, category));
    }
    public void rmAcct(String location) {
        ArrayList<Account> found = this.find('l', location);
        if (found.size() > 1) {
            String msg = "Which account do you want to remove?\n";
            
            for (int i = 0; i < found.size(); i++) {
                msg += "" + (i + 1) + ". " + found.get(i).username + "\n";
            }

            int toDelete = Useful.intput(msg) - 1;
            while (toDelete >= found.size() || toDelete < 0) {
                toDelete = Useful.intput(msg) - 1;
            }
            this.accounts.remove(found.get(toDelete));

        } else if (found.size() == 1) {
            this.accounts.remove(found.get(0));

        } else {
            System.out.println("No accounts for " + location + " were found.");

        }
    }
    public ArrayList<Account> find(char type, String description) {
        /*
        these for type
        c for category
        l for location
        u for username
        p for password
        */
        ArrayList<Account> results = new ArrayList<Account>();
        for (int i = 0; i < this.accounts.size(); i++) {
            switch (type) {
                case 'c':
                    if (this.accounts.get(i).category == description) {
                        results.add(this.accounts.get(i));
                    }
                break;
                case 'l':
                    if (this.accounts.get(i).usedAt == description) {
                        results.add(this.accounts.get(i));
                    }
                break;
                case 'u':
                    if (this.accounts.get(i).username == description) {
                        results.add(this.accounts.get(i));
                    }
                break;
                case 'p':
                    if (this.accounts.get(i).password == description) {
                        results.add(this.accounts.get(i));
                    }
                break;
                
            }
        }
        return results;
    }
    public ArrayList<String> lsCats() {
        ArrayList<String> cats = new ArrayList<String>();
        // create list of categories
        for (int i = 0; i < this.accounts.size(); i++) {
            if (!cats.contains(this.accounts.get(i).category)) {
                cats.add(this.accounts.get(i).category);
            }
        }
        return cats;
    }
    public String toPrint(User user) {
        // number of chars after the new vertical line
        int colWidth = 3;
        String spc = Useful.multStr(" ", colWidth);
        String hrln = Useful.multStr("═", colWidth);
        String vrln = "║";
        String vert = "╠";
        String drcn = "╚";
        String result = user.username;
        ArrayList<String> cats = this.lsCats();
        
        
        // loop through that list
        for (int i = 0; i < cats.size(); i++) {
            // add different strings based on the current number of accounts left in the category
            if ((cats.size() - i) >= 2) {result += "\n" + vert + hrln;}
            if ((cats.size() - i) == 1) {result += "\n" + drcn + hrln;}

            // always add new category name
            result += cats.get(i);

            // create a list of all accounts with current category
            ArrayList<Account> tmpCat = this.find('c', cats.get(i));
            
            // loop through that list of accounts
            for (int j = 0; j < tmpCat.size(); j++) {
                if ((tmpCat.size() - j) >= 2) {result += vert + hrln;}
                if ((tmpCat.size() - j) == 1) {result += drcn + hrln;}
                result += vrln + spc + tmpCat.get(j).toString() + "\n";
            }
        }
        
        return result;
    }
    public void saveAndClose() {
        // TODO:
        // do this
    }
}
