package main;

import java.io.*;
import java.util.Scanner;

public class Account {
    private String email;
    private String password;

    private Account() {}
    private Account(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public static Account loadFromFile(String filepath) throws IOException {
        Scanner reader = new Scanner(new FileInputStream(filepath));
        String email = reader.next();
        String password = reader.next();
        reader.close();
        return new Account(email, password);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
