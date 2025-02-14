package example.config;

public class DatabaseConfig {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/employeemanager";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public static String getDbUrl() { return DB_URL; }
    public static String getDbUser() { return DB_USER; }
    public static String getDbPassword() { return DB_PASSWORD; }
}
