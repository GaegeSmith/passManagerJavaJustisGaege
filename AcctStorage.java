import java.util.ArrayList;

public class AcctStorage {
    ArrayList<Account> accounts = new ArrayList<Account>();
    

    public void addAcct(Account acct) {
        accounts.add(acct);
    }
    public void rmAcct(String location) {
        ArrayList<Account> found = this.find('l', location);
        if (found.size() > 0) {
            String msg = "";
            
            for (int i = 0; i < found.size(); i++) {
                
            }

            int toDelete = Useful.intput(msg);
        } else {
            System.out.println("No accounts for " + " were found.");
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
