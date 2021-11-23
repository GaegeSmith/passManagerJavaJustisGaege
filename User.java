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

    public String prepareForSave() {
        return "User?fn:" + this.firstName + "?ln:" + this.lastName + "?un:" + this.username + "?pw:" + this.password + "?h:" + this.hint;
    }
}
