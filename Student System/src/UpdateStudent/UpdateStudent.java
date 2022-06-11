package UpdateStudent;

import AddStudent.Student;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import student.management.system.HomeController;
import student.management.system.SignUpController;

public class UpdateStudent implements Initializable {

    @FXML
    private TextField name;

    @FXML
    private TextField email;

    @FXML
    private TextField address;

    @FXML
    private TextField number;

    @FXML
    private TextField nationality;

    @FXML
    private DatePicker dob;

    @FXML
    private ChoiceBox<?> gender;

    @FXML
    private Button back;

    @FXML
    private Button delete;

    @FXML
    private Button update;

    @FXML
    private Button Search;

    @FXML
    private TextField search;

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    @FXML
    void Search(ActionEvent event) {

        String ids = search.getText();

        if (ids.equals(" ")) {
            JOptionPane.showMessageDialog(null, "Id is Blank");

        } else {
            try {

                long id = Long.parseLong(ids);

                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/1-student_system", "root", "");

                String sql_query = "select * from students where id=?";
                PreparedStatement stmt = con.prepareStatement(sql_query);
                stmt.setLong(1, id);

                rs = stmt.executeQuery();

                if (rs.next()) {
                    name.setText(rs.getString("name"));
                    email.setText(rs.getString("email"));
                    address.setText(rs.getString("address"));
                    number.setText(rs.getString("number"));
                    nationality.setText(rs.getString("nationality"));

                } else {

                    JOptionPane.showMessageDialog(null, "NOT FOUND");

                }

                con.close();

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(UpdateStudent.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @FXML
    void Update(ActionEvent event) {

        String ids = search.getText();

        long id1 = Long.parseLong(ids);

        String name1 = name.getText();
        String email1 = email.getText();
        String address1 = address.getText();
        String number1 = number.getText();
        String nationality1 = nationality.getText();

        if (name1 == "" || email1 == "" || address1 == "" || number1 == "" || nationality1 == "") {

            JOptionPane.showMessageDialog(null, "NOT UPDATED");

        } else {

            try {

                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/1-student_system", "root", "");

                String sql_query = "update students set name = ? , email=? , address=? , number=? , nationality=? where id=?";

                //  String sql_query = "insert into students (name,email,address,number,nationality) values (? ,?, ?, ?, ?)";
                PreparedStatement stmt = con.prepareStatement(sql_query);

                stmt.setString(1, name1);
                stmt.setString(2, email1);
                stmt.setString(3, address1);
                stmt.setString(4, number1);
                stmt.setString(5, nationality1);
                stmt.setLong(6, id1);

                stmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "UPDATED");

                con.close();

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(UpdateStudent.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @FXML
    void Delete(ActionEvent event) {

        String ids = search.getText();

        long id1 = Long.parseLong(ids);

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/1-student_system", "root", "");

            String sql_query = "delete from students where id=?";

            //  String sql_query = "insert into students (name,email,address,number,nationality) values (? ,?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql_query);
            
             stmt.setLong(1, id1);

            stmt.executeUpdate();
            
                    name.setText("");
                    email.setText("");
                    address.setText("");
                    number.setText("");
                    nationality.setText("");
                    search.setText("");
                    

            JOptionPane.showMessageDialog(null, "Deleted");

            con.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UpdateStudent.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void Back(ActionEvent event) throws IOException {
        
//            Parent pr = FXMLLoader.load(getClass().getResource("/student.management.system/Home.fxml"));
//            Scene scene = new Scene(pr);
//            Stage window = (Stage) back.getScene().getWindow() ;
//            window.setScene(scene);

        try {
            // close current
            Node p = (Node) event.getSource();
            Stage p1 = (Stage) p.getScene().getWindow();
            p1.close();
            // open new
            Stage st = new Stage();
            Parent pr = FXMLLoader.load(getClass().getResource("/student.management.system/Home.fxml"));
            Scene scene = new Scene(pr);
            st.setScene(scene);
            st.setTitle(" Home Page");
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(UpdateStudent.class.getName()).log(Level.SEVERE, null, ex);
            
            System.out.println(ex.toString()) ;
        }

    }

    @FXML
    void SearchField(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
