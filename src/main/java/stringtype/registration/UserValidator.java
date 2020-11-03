package stringtype.registration;

public class UserValidator {
    private String userName;
    private String password1;
    private String password2;
    private String email;

    public UserValidator() {

    }

    public boolean isValidUsername(String username) {
        return username.length()>0;
    }

    public boolean isValidPassword(String password1, String password2) {
        return password1.equals(password2) && (password1.length()>7);
    }

    public boolean isValidEmail(String email) {
        boolean result = true;

        if ((email.indexOf("@") >0) && !(email.substring(email.indexOf("@"),(email.indexOf("@")+1) ).equals("."))) {

            String domain = email.substring(email.indexOf("@")+2);

            if (!((domain.indexOf(".") >0)&& ((domain.indexOf(".") < (domain.length()-1))))) {
                result = false;
            };

        } else {
            result = false;
        };
        return  result;
    }

}
