package by.bsuir.ratkevich.library.user;

import java.util.HashMap;
import java.io.*;

public class UserHandler {

    private HashMap<String, String> users;

    private String fileName = "Users.txt";

    public UserHandler () {

        users = new HashMap <>();
        readUsersFromFile ();
    }

    public boolean addUser (String userName, String password, boolean isAdmin) {

        User user = new User (userName, password.hashCode(), isAdmin);

        if (!isUserNameFree (user)) {

            users.put(userName, password.hashCode() + "|" + isAdmin);
            writeUserToFile(user);

            return true;
        }

        return false;

    }

    public void readUsersFromFile () {

        String userName;
        int passwordHash;
        boolean isAdmin;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            String[] buffer;

            while ((line = reader.readLine()) != null) {
                buffer = line.split("\\|");

                userName = buffer[0];
                passwordHash = Integer.parseInt(buffer[1]);
                isAdmin = Boolean.parseBoolean(buffer[2]);

                users.put(userName , passwordHash + "|" + isAdmin );
            }

        } catch (IOException e) {

        }

    }

    public void writeUserToFile (User user) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {

            writer.write(user.getUserName() + "|" + user.getPasswordHash() + "|" + user.getIsAdmin() + "\n");

        } catch (IOException e) {

        }

    }

    public boolean isUserNameFree (User user) {

        return users.containsKey (user.getUserName());
    }

    public User isLoginCorrect (String userName, String password, boolean isAdmin) {

        if (!users.containsKey(userName)) {

            return null;
        }

        return new User (userName, password.hashCode(),isAdmin);
    }


}
