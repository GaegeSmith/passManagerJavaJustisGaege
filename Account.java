public class Account {
    // stores each account the user saves, stores the place where it is used (website, app, etc.), username, password
    String usedAt;
    String username;
    String password;
    String category;

    Account(String usedAt, String username, String password, String category) {
        this.usedAt = usedAt;
        this.username = username;
        this.password = password;
        this.category = category;
    }

    public String prepareForSave() {
        return "Account?ua:" + this.usedAt + "?un:" + this.username + "?pw:" + this.password + "?cat:" + this.category;
    }
    
}
