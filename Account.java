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

    public String toString(int colWidth, String firstNext, String lastNext) {
        return "Site/App: " + this.usedAt + "\n" + firstNext + Useful.multStr(" ", colWidth) + lastNext + Useful.multStr(" ", colWidth) + "╚" + Useful.multStr("═", colWidth) + "Username: " + this.username + Useful.multStr("═", colWidth) + "Password: " + this.password;
    }

    public String prepareForSave() {
        return this.usedAt + "?" + this.username + "?" + this.password + "?" + this.category;
    }
    
}
