package by.servlets.db;

public class ConstDb {
    public static final String SELECT_USERS = "select * from users";
    public static final String INSERT_USER = "insert into users(login, password) values (?,?)";
    public static final String SELECT_USER = "select * from users where login=? and password=?";

    public static final int USER_LOGIN_INDEX = 1;
    public static final int USER_PASSWORD_INDEX = 2;

    public static final String DB_URL = "web";
    public static final String USER = "root";
    public static final String PASSWORD = "qwerty12";

    public static final String INSERT_TICKET = "insert into tickets (user_id, text) values(?,?)";
    public static final String SELECT_USER_ID_BY_LOGIN = "select id from users where login = ?";
}
