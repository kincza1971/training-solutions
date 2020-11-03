package stringtype.registration;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Felhasználónév (kötelező)?");
        String username = scnr.nextLine();
        System.out.println("password?");
        String password1 = scnr.nextLine();
        System.out.println("Password újra?");
        String password2 = scnr.nextLine();
        System.out.println("email cím?");
        String email = scnr.nextLine();

        UserValidator uv = new UserValidator();
        System.out.println(uv.isValidUsername(username) ? "username ok" : "username is necessary");
        System.out.println(uv.isValidPassword(password1, password2) ? "password ok" : "passwords have to be minimum 8 letters long and equal");
        System.out.println(uv.isValidEmail(email) ? "email ok" : "please give valid email");

    }
}
