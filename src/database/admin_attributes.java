package database;

public class admin_attributes {
    
    private static String name;
    private static String username;
    private static String password;

    public admin_attributes() {
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        admin_attributes.name = name;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        admin_attributes.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        admin_attributes.password = password;
    }
    
    
    
}
