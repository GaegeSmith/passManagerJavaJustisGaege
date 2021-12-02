public class User {
    String firstName;
    String lastName;
    String username;
    String password = "";
    String hint;
    User() {
        // ask for user info
        this.firstName = Useful.input("What is your first name? ");
        this.lastName = Useful.input("What is your last name? ");
        this.username = Useful.input("What do you want your username to be? ");

        // make sure the password is secure
        while (!PasswordHandler.checker(this.password)) {
            this.password = Useful.input("What do you want your password to be, must be 8 characters with at least one of each of these:  UPPERCASE LETTER, lowercase letter, number 0-9, and special characters \"!\", \"@\", \"#\", \"$\", \"%\", \"^\", \"&\", \"(\", \")\", or type \"gen\" to generate one automagically: ");
            if (this.password.equals("gen")) {
                int len = 0;
                while (!(8 <= len && len <= 20)) {
                    len = Useful.intput("How long do you want your password, between 8 and 20 characters? ");
                }
                this.password = PasswordHandler.generator(len);
            }
        }
        System.out.println("This is your profile password, DO NOT LOSE!\n" + this.password);
        this.hint = Useful.input("Create a hint for your password so you can remeber it: ");
        while (this.hint.equals(this.password)) {
            this.hint = Useful.input("Create a hint for your password so you can remeber it, make sure it is not the same as your password: ");
        }
    }
    User(String fn, String ln, String un, String pw, String h) {
        this.firstName = fn;
        this.lastName = ln;
        this.username = un;
        this.password = pw;
        this.hint = h;
    }
    public boolean login() {
        return true;
        // int attempts = 3;
        // while (attempts > 0) {
        //     if (attempts == 1) {
        //         System.out.println("Password hint: " + this.hint);
        //     }
        //     String username = Useful.input("Username: ");
        //     System.out.println();
        //     String password = Useful.input("Password: ");
        //     if (username.equals(this.username) && password.equals(this.password)) {
        //         return true;
        //     }
        //     attempts--;
        // }
        // return false;
    }
    public String prepareForSave() {
        return "User?" + this.firstName + "?" + this.lastName + "?" + this.username + "?" + this.password + "?" + this.hint;
    }
}
