public class Account {
    private String email;
    private String password;

    private Account() {}
    private Account(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public static Account loadFromFile(String filepath) {
        return new Account("xa12284003@student.karazin.ua", "fastumgel");
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
