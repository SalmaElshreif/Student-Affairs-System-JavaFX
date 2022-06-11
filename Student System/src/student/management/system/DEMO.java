//
//
//import java.sql.*;
//import java.util.Date;
//
//// https://jar-download.com/artifacts/mysql/mysql-connector-java
//// https://www.apachefriends.org/download.html
//
//public class DEMO {
//
//    public static Connection get_DB_Connection() {
//        final String DB_SERVER = "localhost";
//        final String PORT = "3306";
//        final String DB_NAME = "usersdb";
//        final String DB_URL = "jdbc:mysql://" + DB_SERVER + ":" + PORT + "/" + DB_NAME;
//        final String USER = "root";
//        final String PASS = "";
//        try {
//            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            return conn;
//        } catch (SQLException e) {
//            System.out.println("Database is not connected !");
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public static boolean search(String username, String password) {
//        boolean existed = false;
//        try {
//            Connection conn = get_DB_Connection();
//            String sql_query = "select username, password from users where username=? and password=?";
//            PreparedStatement stmt = conn.prepareStatement(sql_query);
//            stmt.setString(1, username);
//            stmt.setString(2, password);
//            ResultSet results = stmt.executeQuery();
//            existed = results.next();
//            conn.close();
//            return existed;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return existed;
//        }
//    }
//
//    public static void insert(String username, String password) {
//        try {
//            boolean existed = search(username, password);
//            if (existed) {
//                System.out.println("User is already existed before !");
//            } else {
//                Connection conn = get_DB_Connection();
//                // generate random id from current time millesecond
//                Date date = new Date();
//                long id = date.getTime();
//                String sql_query = "insert into users (id,username,password) values (?,?, ?)";
//                PreparedStatement stmt = conn.prepareStatement(sql_query);
//                stmt.setLong(1, id);
//                stmt.setString(2, username);
//                stmt.setString(3, password);
//                stmt.executeUpdate();
//                System.out.println("Insertion is done");
//                conn.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void update(String username, String password) {
//        try {
//            Connection conn = get_DB_Connection();
//            String sql_query = "update users set password=? where username=?";
//            PreparedStatement stmt = conn.prepareStatement(sql_query);
//            stmt.setString(1, password);
//            stmt.setString(2, username);
//            stmt.executeUpdate();
//            System.out.println("Updating is done");
//            conn.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void delete(String username, String password) {
//        try {
//            boolean existed = search(username, password);
//            if (!existed) {
//                System.out.println("User is not founded to be deleted !");
//            } else {
//                Connection conn = get_DB_Connection();
//                String sql_query = "delete from users where username= ? and password=?";
//                PreparedStatement stmt = conn.prepareStatement(sql_query);
//                stmt.setString(1, username);
//                stmt.setString(2, password);
//                stmt.executeUpdate();
//                System.out.println("Deleting is done");
//                conn.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void getAllData() {
//        boolean emptyTable = true;
//        try {
//            Connection conn = get_DB_Connection();
//            String sql_query = "select * from users";
//            PreparedStatement stmt = conn.prepareStatement(sql_query);
//            ResultSet results = stmt.executeQuery();
//            System.out.println("****** Table data *****");
//            while (results.next()) {
//                // Retrieve each row data
//                System.out.print("id: " + results.getLong("id"));
//                System.out.print(" , username: " + results.getString("username"));
//                System.out.println(" , password: " + results.getString("password"));
//                emptyTable = false;
//            }
//            if (emptyTable) {
//                System.out.println("Users table is empty !");
//            }
//            conn.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//    //  get_DB_Connection();
////
////        boolean existed = search("Kareem", "1234");
////        if (existed) {
////            System.out.println("this user is existed");
////        } else {
////            System.out.println("this user is not existed");
////        }
//
//     insert("mohamed", "1234");
//        insert("hany", "omar");
//
//        //  update("Kareem", "9999");
////     delete("Kareem", "9999");
//      getAllData();
//    }
//}
