import java.util.ArrayList;

public class AcctStorage {
    private ArrayList<Account> accounts = new ArrayList<Account>();
    private User user;
    private BufferWriter dataFile = new BufferWriter("data.txt");
    public AcctStorage() {
        // if a file for an account exists
        if (dataFile.exists()) {
            // read the user file
            ArrayList<String> lines = new ArrayList<String>();
            try {
                lines = dataFile.readString();
                dataFile.saveAndClose();
            } catch (Exception e) {
                // for this to print, the data file would have to be deleted or corrupted after the userFile.exists() runs and before the userFile.readString() runs
                System.out.println("How did you find this Easter Egg, this should never print, good job!\n\n\n\nBad news...your data file was deleted with incredible timing or corrupted");
            }
            for (int i = 0; i < lines.size(); i++) {
                String[] tmpLine = lines.get(i).split("\\?");
                if (tmpLine[0].equals("User")) {
                    this.user = new User(tmpLine[1], tmpLine[2], tmpLine[3], tmpLine[4], tmpLine[5]);
                } else {
                    accounts.add(new Account(tmpLine[0], tmpLine[1], tmpLine[2], tmpLine[3]));
                }
            }
            
            // login
            if (!this.user.login()) {
                System.out.println("Sorry, you have failed the login process to many times.");
                System.exit(0);
            }
        } else {
            // create acct
            this.user = new User();
            
            // login
            if (!this.user.login()) {
                // if user fails login, save their account
                System.out.println("Sorry, you have failed the login process to many times.");
                dataFile.writeString(this.user.prepareForSave());
                dataFile.saveAndClose();
                System.exit(0);
            }
        }
    }
    
    public void addAcct() {
        String usedAt = Useful.input("What website or app is this account for? ");
        String username = Useful.input("What is your username? ");
        String password = PasswordHandler.pwPrompt();
        String category = Useful.input("What category is this account (examples: Banking, Gaming, Work, etc.)? ");
        accounts.add(new Account(usedAt, username, password, category));
    }
    public void rmAcct() {
        String location = Useful.input("What app or website is the account for that you want to remove? ");
        ArrayList<Account> found = this.find('l', location);
        if (found.size() > 1) {
            String msg = "Which account do you want to remove?\n";
            
            for (int i = 0; i < found.size(); i++) {
                msg += "" + (i + 1) + ". " + found.get(i).username + "═══" + found.get(i).password+ "\n";
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
                    if (this.accounts.get(i).category.equals(description)) {
                        results.add(this.accounts.get(i));
                    }
                break;
                case 'l':
                    if (this.accounts.get(i).usedAt.equals(description)) {
                        results.add(this.accounts.get(i));
                    }
                break;
                case 'u':
                    if (this.accounts.get(i).username.equals(description)) {
                        results.add(this.accounts.get(i));
                    }
                break;
                case 'p':
                    if (this.accounts.get(i).password.equals(description)) {
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
    public String toPrint() {
        // number of chars after the new vertical line
        int colWidth = 3;
        String spc = Useful.multStr(" ", colWidth);
        String hrln = Useful.multStr("═", colWidth);
        String vrln = "║";
        String vert = "╠";
        String drcn = "╚";
        String result = this.user.username + "\n";
        ArrayList<String> cats = this.lsCats();
        
        
        // loop through that list
        for (int i = 0; i < cats.size(); i++) {
            // add different strings based on the current number of accounts left in the category
            if ((cats.size() - i) >= 2) {result += vert + hrln;}
            if ((cats.size() - i) == 1) {result += drcn + hrln;}

            // always add new category name
            result += cats.get(i) + "\n";

            // create a list of all accounts with current category
            ArrayList<Account> tmpCat = this.find('c', cats.get(i));
            
            // loop through that list of accounts
            for (int j = 0; j < tmpCat.size(); j++) {
                if (i < cats.size() - 1) {
                    result += vrln;
                } else {
                    result += " ";
                }
                if ((tmpCat.size() - j) >= 2) {result += spc + vert + hrln;}
                if ((tmpCat.size() - j) == 1) {result += spc + drcn + hrln;}

                String fNext = " ";
                String lNext = " ";
                if (j != tmpCat.size() - 1) {lNext = vrln;}
                if (i != cats.size() - 1) {fNext = vrln;}
                result += tmpCat.get(j).toString(colWidth, fNext, lNext) + "\n";
            }
        }
        
        return result;
    }
    public void saveAndClose() {
        this.dataFile.writeString(this.user.prepareForSave());
        for (int i = 0; i < this.accounts.size(); i++) {
            this.dataFile.writeString(this.accounts.get(i).prepareForSave());
        }
        this.dataFile.saveAndClose();
        System.exit(0);
    }
    public void delete() {
        System.out.println("PLEASE NOTE\nDeleteing your profile is PERMANENT adn CANNOT BE REVERSED.\nProceed at your own risk.");
        if (Useful.input("Please enter your password to confirm delete, or anything else to cancel: ").equals(this.user.password)) {
            accounts = new ArrayList<Account>();
            user.firstName = "";
            user.lastName = "";
            user.username = "";
            user.password = "";
            user.hint = "";
            this.dataFile.delete();
            System.exit(0);
        }
    }
}
