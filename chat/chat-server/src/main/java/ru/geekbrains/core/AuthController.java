package ru.geekbrains.core;

import ru.geekbrains.data.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.sql.*;

public class AuthController {
    private static Connection connection;
    private static Statement statement;

    synchronized static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:chat/main.db");
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    synchronized static String getNickname(String login, String password) {
        try {
            ResultSet rs = statement.executeQuery(
                    String.format("SELECT * FROM student WHERE login = '%s' and password = '%s'",
                            login, password));
            if (rs.next()) {
                return rs.getString("name");
            }
        } catch (SQLException throwable) {
            throw new RuntimeException(throwable);
        }
        return null;
    }
    synchronized static ArrayList<String> getNicknames() {
        ArrayList<String> nicknames = new ArrayList<>();
        try {
            ResultSet rs = statement.executeQuery(String.format("SELECT name FROM student"));
            while (rs.next()) {
                nicknames.add(rs.getString("name"));
            }
            return nicknames;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    synchronized static ArrayList<String> getLogins() {
        ArrayList<String> logins = new ArrayList<>();
        try {
            ResultSet rs = statement.executeQuery(String.format("SELECT login FROM student"));
            while (rs.next()) {
                logins.add(rs.getString("login"));
            }
            return logins;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    synchronized static void addUser(String login, String password, String name) {
        try {
            connection.setAutoCommit(false);

            PreparedStatement ps = connection.prepareStatement("INSERT INTO student " +
                    "(login, password, name) VALUES (?, ?, ?)");
            ps.setString(1, login);
            ps.setString(2, password);
            ps.setString(3, name);
            ps.executeUpdate();

            connection.commit();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

//    HashMap<String, User> users = new HashMap<>();
//
//    public void init() {
//        for (User user : receiveUsers()) {
//            users.put(user.getLogin(), user);
//        }
//    }
//
//    public String getNickname(String login, String password) {
//        User user = users.get(login);
//        if (user != null && user.isPasswordCorrect(password)) {
//            return user.getNickname();
//        }
//        return null;
//    }
//
//    private ArrayList<User> receiveUsers() {
//        ArrayList<User> usersArr = new ArrayList<>();
//        usersArr.add(new User("admin", "admin", "sysroot"));
//        usersArr.add(new User("alex", "123", "alex-st"));
//        return usersArr;
//    }

}
