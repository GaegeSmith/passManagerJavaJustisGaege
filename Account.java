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


    
}
