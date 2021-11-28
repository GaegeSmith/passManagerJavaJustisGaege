import java.util.ArrayList;

public class AcctStorage {
    private ArrayList<Account> accounts = new ArrayList<Account>();
    
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
        String hrln = "═";
        String vrln = "║";
        String vert = "╠";
        String drcn = "╚";
        String result = user.username + "\n";
        ArrayList<String> cats = this.lsCats();
        
        
        // loop through that list
        for (int i = 0; i < cats.size(); i++) {
            // create a list of all accounts with current category
            ArrayList<Account> tmpCat = this.find('c', cats.get(i));
            //add different strings based on the current number of accounts left in the category
            if ((cats.size() - i) > 0) {result += vrln + "\n";}
            if ((cats.size() - i) > 1) {result += vert + Useful.multStr(hrln, 3);}
            if ((cats.size() - i) == 1) {result += drcn + Useful.multStr(hrln, 3);}

            // loop through that list
            for (int j = 0; j < tmpCat.size(); j++) {
                result += "" + 
            }
        }

        return result;
    }
}
