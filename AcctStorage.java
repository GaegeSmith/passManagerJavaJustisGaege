import java.util.ArrayList;

public class AcctStorage {
    ArrayList<Account> accounts = new ArrayList<Account>();
    
    public void addAcct(Account acct) {
        accounts.add(acct);
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
    public String prepToSave() {
        String result = new String();
        

        return result;
    }
}
