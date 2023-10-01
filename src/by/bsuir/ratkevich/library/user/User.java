package by.bsuir.ratkevich.library.user;

public class User {

    private String userName;

    private int passwordHash;

    private boolean isAdmin;

    public User (String userName, int passwordHash, boolean isAdmin) {

        this.userName = userName;
        this.passwordHash = passwordHash;
        this.isAdmin = isAdmin;
    }

    public void setUserName (String userName) {

        this.userName = userName;
    }

    public void setPasswordHash (int passwordHash) {

        this.passwordHash = passwordHash;
    }

    public void setIsAdmin (boolean isAdmin) {

        this.isAdmin = isAdmin;
    }

    public String getUserName () {

        return userName;
    }

    public int getPasswordHash () {

        return passwordHash;
    }

    public boolean getIsAdmin () {

        return isAdmin;
    }

    @Override
    public boolean equals (Object o) {

        if (this == o) return true;
        if (o == null || o.getClass()!=getClass()) return false;

        User user = (User) o;

        return userName.equals(user.getUserName())
                && passwordHash == user.getPasswordHash()
                && isAdmin == user.getIsAdmin();
    }

    @Override
    public int hashCode () {

        return 17*32*userName.hashCode()*passwordHash;
    }

    @Override
    public String toString () {

        return "User: "+ userName;
    }
}
