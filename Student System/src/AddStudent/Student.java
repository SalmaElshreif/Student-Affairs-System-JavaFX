
package AddStudent;

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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;


public class Student implements Initializable {

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtaddress;

    @FXML
    private TextField txtnumber;

    @FXML
    private TextField txtnationality;
    

//    @FXML
//    private DatePicker dob;
//
//    @FXML
//    private ChoiceBox<?> gender;
    
    @FXML
    private Button Add;
    
    @FXML
    private Button Delete;
    
     Connection con ;
    ResultSet rs ;

    
  public void AddStudent(ActionEvent ev) {
        
        String name = txtname.getText() ;
        String email = txtemail.getText() ;
        String address = txtaddress.getText() ;
        String number =txtnumber.getText() ;
        String nationality =txtnationality.getText() ;
        
         if(name.equals(" ") && email.equals(" ") && address.equals(" ") && number.equals(" ") && nationality.equals(" ") ) {
            
            JOptionPane.showMessageDialog(null, "name or email or address or number or nationality is Blank") ;
            
        }
        
                 else{
            
            try {
                Class.forName("com.mysql.jdbc.Driver") ;
                con = DriverManager.getConnection("jdbc:mysql://localhost/1-student_system", "root" ,"") ;
                
                String sql_query = "insert into students (name,email,address,number,nationality) values (? ,?, ?, ?, ?)";
                PreparedStatement stmt = con.prepareStatement(sql_query);
             //   stmt.setLong(1, id);
                stmt.setString(1, name);
                stmt.setString(2, email);
                stmt.setString(3, address);
                stmt.setString(4, number);
                stmt.setString(5, nationality);
                
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "insertion is Done");
                 con.close();
//                  
//                if(rs.next()){
//                    
//                        JOptionPane.showMessageDialog(null, "Login Success") ;                
//                }
//                else{
//                    
//                        JOptionPane.showMessageDialog(null, "Login Failed") ;  
//                        name.setText(" ") ;
//                        email.setText(" ") ;
//                        address.setText(" ") ;
//                        number.setText(" ") ;
//                        nationality.setText(" ") ;
//                        name.requestFocus();
//                }
//                     
                
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
    }
  
  
      @FXML
    public void DeleteStudent(ActionEvent event) {
        
        String name = txtname.getText() ;
        String email = txtemail.getText() ;
        String address = txtaddress.getText() ;
        String number =txtnumber.getText() ;
        String nationality =txtnationality.getText() ;
        
         if(name.equals(" ") && email.equals(" ") && address.equals(" ") && number.equals(" ") && nationality.equals(" ") ) {
            
            JOptionPane.showMessageDialog(null, "name or email or address or number or nationality is Blank") ;
            
        }
        
                 else{
            
            try {
                Class.forName("com.mysql.jdbc.Driver") ;
                con = DriverManager.getConnection("jdbc:mysql://localhost/1-student_system", "root" ,"") ;
                             
                String sql_query = "delete from students (name,email,address,number,nationality) values (? ,?, ?, ?, ?)";
                PreparedStatement stmt = con.prepareStatement(sql_query);
             //   stmt.setLong(1, id);
                stmt.setString(1, name);
                stmt.setString(2, email);
                stmt.setString(3, address);
                stmt.setString(4, number);
                stmt.setString(5, nationality);
                
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Deletion is Done");
                 con.close();

                
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }

    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
