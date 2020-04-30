package by.servlets.model.beans;

public class User {
    private String pass;
    private String login;
    private boolean isValid;


    public User(String pass, String login, boolean isValid) {
        this.pass = pass;
        this.login = login;
        this.isValid = isValid;
    }

    public User(String pass, String login) {
        this.pass = pass;
        this.login = login;
    }

    public User(User currentSessionUser) {
        this.pass = currentSessionUser.getPass();
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
