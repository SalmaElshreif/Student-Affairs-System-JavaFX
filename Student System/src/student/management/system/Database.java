//
//package student.management.system;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Date;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//
//public class Database {
//    
//    public static Connection get_DB_Connection() {
//        final String DB_SERVER = "localhost";
//        final String PORT = "3306";
//        final String DB_NAME = "1-student_system";
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
//     public static void insert(String username, String password) {
//         boolean existed = search(username, password);
//         if (existed) {
//             System.out.println("User is already existed before !");
//         } else {
//             try {
//                 Connection conn = get_DB_Connection();
//                 // generate random id from current time millesecond
//                 Date date = new Date();
//                 long id = date.getTime();
//                 String sql_query = "insert into users (id,username,password) values (?,?, ?)";
//                 PreparedStatement stmt = conn.prepareStatement(sql_query);
//                 stmt.setLong(1, id);
//                 stmt.setString(2, username);
//                 stmt.setString(3, password);
//                 stmt.executeUpdate();
//                 System.out.println("Insertion is done");
//                 conn.close();
//             } catch (SQLException ex) {
//                 Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
//             }
//         }
//    }
//}
//    
//
