package student.management.system;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class LoginController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private TextField txtname;

    @FXML
    private Button btnok;

    @FXML
    private PasswordField txtpass;

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    @FXML
    void login(ActionEvent event) {

        String name = txtname.getText();
        String pass = txtpass.getText();

        if (name.equals(" ") || pass.equals(" ")) {

            JOptionPane.showMessageDialog(null, "UserName or Password Blank");

        } else {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/1-student_system", "root", "");

                pst = con.prepareStatement("select * from users where username=? and password=?");

                pst.setString(1, name);
                pst.setString(2, pass);

                rs = pst.executeQuery();

                if (rs.next()) {
                    
                  //  JOptionPane.showMessageDialog(null, "Login Success");
                    try {
                        // close current
                        Node p = (Node) event.getSource();
                        Stage p1 = (Stage) p.getScene().getWindow();
                        p1.close();
                        // open new
                        Stage st = new Stage();
                        Parent pr = FXMLLoader.load(getClass().getResource("Home.fxml"));
                        Scene scene = new Scene(pr);
                        st.setScene(scene);
                        st.setTitle("Home Page");
                        st.show();
                    } catch (IOException ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {

                    JOptionPane.showMessageDialog(null, "Login Failed");
                    txtname.setText(" ");
                    txtpass.setText(" ");
                    txtname.requestFocus();
                }

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

//            try {
//                // close current
//                Node p = (Node) event.getSource();
//                Stage p1 = (Stage) p.getScene().getWindow();
//                p1.close();
//                // open new
//                Stage st = new Stage();
//                Parent pr = FXMLLoader.load(getClass().getResource("Home.fxml"));
//                Scene scene = new Scene(pr);
//                st.setScene(scene);
//                st.setTitle("Home Page");
//                st.show();
//            } catch (IOException ex) {
//                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            String name = txtname.getText();
//            String pass = txtpass.getText();
//
//            if (name.equals(" ") || pass.equals(" ")) {
//
//                JOptionPane.showMessageDialog(null, "UserName or Password Blank");
//
//            } else {
//
//                try {
//                    Class.forName("com.mysql.jdbc.Driver");
//                    con = DriverManager.getConnection("jdbc:mysql://localhost/1-student_system", "root", "");
//
//                    pst = con.prepareStatement("select * from users where username=? and password=?");
//
//                    pst.setString(1, name);
//                    pst.setString(2, pass);
//
//                    rs = pst.executeQuery();
//
//                    if (rs.next()) {
//
//                        JOptionPane.showMessageDialog(null, "Login Success");
//                    } else {
//
//                        JOptionPane.showMessageDialog(null, "Login Failed");
//                        txtname.setText(" ");
//                        txtpass.setText(" ");
//                        txtname.requestFocus();
//                    }
//
//                } catch (ClassNotFoundException | SQLException ex) {
//                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//
//            }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
