import java.util.ArrayList;

public class AcctStorage {
    ArrayList<Account> accounts = new ArrayList<Account>();
    

    public void addAcct(Account acct) {
        accounts.add(acct);
    }
    public void rmAcct(String location) {
        this.find('l', location)
    }

    public ArrayList<Account> find(char type, String description) {
        /*
        these for type
        c for category
        l for location
        u for username
        p for password
        */
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
        return new Account(null, null, null, null);
    }
    
    public String prepToSave() {
        String result = new String();
        

        return result;
    }
}