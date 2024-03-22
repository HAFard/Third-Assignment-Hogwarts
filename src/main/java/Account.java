import java.util.UUID;

public abstract class Account implements AccountManagement{
    protected String username;
    // TODO: Passwords should hashed
    protected int password;
    protected UUID accountID;

    public Account(String username, String password) {
        this.username = username;
        this.password = password.hashCode();
        this.accountID = UUID.randomUUID();
    }
    public abstract void showDashboard();

    @Override
    public boolean validatePassword(String enteredPassword) {
        //TODO
        if (enteredPassword.hashCode() == this.password){
            return true;
        }
        return false;
    }

    @Override
    public void changeUsername(String newUsername) {
        //TODO
        this.username = newUsername;
    }

    @Override
    public void changePassword(String newPassword) {
        //TODO
        this.password = newPassword.hashCode();
    }


    @Override
    public String toString() {
        return username;
    }
}
