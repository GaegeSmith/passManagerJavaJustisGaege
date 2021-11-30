public class User {
    String firstName;
    String lastName;
    String username;
    String password;
    String hint;
    User(String fn, String ln, String un, String pw, String h) {
        this.firstName = fn;
        this.lastName = ln;
        this.username = un;
        this.password = pw;
        this.hint = h;
    }
    public boolean login() {
        int attempts = 3;
        while (attempts > 0) {
            if (attempts == 1) {
                System.out.println("Password hint: " + this.password);
            }
            String username = Useful.input("Username: ");
            System.out.println();
            String password = Useful.input("Password: ");
            if (username == this.username && password == this.password) {
                return true;
            }
            attempts--;
        }
        return false;
    }
    public String prepareForSave() {
        return "User?fn:" + this.firstName + "?ln:" + this.lastName + "?un:" + this.username + "?pw:" + this.password + "?h:" + this.hint;
    }
}
