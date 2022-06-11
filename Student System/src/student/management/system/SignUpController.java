
package student.management.system;

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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class SignUpController implements Initializable {
    
@FXML
    private TextField txtname;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtpass;

    @FXML
    private Button btnSignup;
    
    Connection con ;
    ResultSet rs ;
    
    @FXML
    private void SignUp(ActionEvent e){
 try {
        // close current
        Node p=(Node) e.getSource();
        Stage p1=(Stage) p.getScene().getWindow();
        p1.close();
        // open new
        Stage st=new Stage();
        Parent pr = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(pr);
        st.setScene(scene);
        st.setTitle("Login Page");  
        st.show();
    } catch (IOException ex) {
      Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
    }
 
            String username = txtname.getText() ;
            String email = txtEmail.getText() ;
            String password =txtpass .getText() ;
        
         if(username.equals(" ") && email.equals(" ") && password.equals(" ")) {
            
            JOptionPane.showMessageDialog(null, "UserName or Password Blank") ;
            
        }
        
                 else{
            
            try {
                Class.forName("com.mysql.jdbc.Driver") ;
                con = DriverManager.getConnection("jdbc:mysql://localhost/1-student_system", "root" ,"") ;
                
                String sql_query = "insert into users (username,email,password) values (? ,?, ?)";
                PreparedStatement stmt = con.prepareStatement(sql_query);
             //   stmt.setLong(1, id);
                stmt.setString(1, username);
                stmt.setString(2, email);
                stmt.setString(3, password);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "insertion is Done");
                 con.close();
                  
                if(rs.next()){
                    
                        JOptionPane.showMessageDialog(null, "Login Success") ;                
                }
                else{
                    
                        JOptionPane.showMessageDialog(null, "Login Failed") ;  
                        txtname.setText(" ") ;
                        txtEmail.setText(" ") ;
                        txtpass.setText(" ") ;
                        txtname.requestFocus();
                }
                
                
                
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
 
 
    }
    
        @FXML
    void OpenLogin(ActionEvent event) {

        try {
        // close current
        Node p=(Node) event.getSource();
        Stage p1=(Stage) p.getScene().getWindow();
        p1.close();
        // open new
        Stage st=new Stage();
        Parent pr = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(pr);
        st.setScene(scene);
        st.setTitle("Login Page");  
        st.show();
    } catch (IOException ex) {
      Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
