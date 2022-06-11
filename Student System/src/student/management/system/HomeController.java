/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.management.system;

import java.io.IOException;
import java.net.URL;
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
import javafx.stage.Stage;


public class HomeController implements Initializable {

    
    @FXML
    private Button btnStudent;

    @FXML
    private Button btnCourse;

    @FXML
    private Button btnShowstudent;
    
        @FXML
    private Button btnUpdatestudent;
        


        @FXML
    void student(ActionEvent ev) {
    try {
        // close current
        Node p=(Node) ev.getSource();
        Stage p1=(Stage) p.getScene().getWindow();
        p1.close();
        // open new
        Stage st=new Stage();
        Parent pr = FXMLLoader.load(getClass().getResource("/AddStudent/Student.fxml"));
        Scene scene = new Scene(pr);
        st.setScene(scene);
        st.setTitle("Student Page");  
        st.show();
    } catch (IOException ex) {
      Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    
    }
    
    
     @FXML
    void course(ActionEvent event) {
        
            try {
        // close current
        Node p=(Node) event.getSource();
        Stage p1=(Stage) p.getScene().getWindow();
        p1.close();
        // open new
        Stage st=new Stage();
        Parent pr = FXMLLoader.load(getClass().getResource("/UpdateCourse/UpdateCourse.fxml"));
        Scene scene = new Scene(pr);
        st.setScene(scene);
        st.setTitle("Update Course Page");  
        st.show();
    } catch (IOException ex) {
      Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
    }

    }
    
    
    @FXML
    void ShowStudent(ActionEvent event1) {
        
                    try {
        // close current
        Node p=(Node) event1.getSource();
        Stage p1=(Stage) p.getScene().getWindow();
        p1.close();
        // open new
        Stage st=new Stage();
        Parent pr = FXMLLoader.load(getClass().getResource("/ShowStudent/ShowStudent.fxml"));
        Scene scene = new Scene(pr);
        st.setScene(scene);
        st.setTitle("Show Student Page");  
        st.show();
    } catch (IOException ex) {
      Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
    }

    }
    
      @FXML
    void UpdateStudent(ActionEvent event2) {
        
                            try {
        // close current
        Node p=(Node) event2.getSource();
        Stage p1=(Stage) p.getScene().getWindow();
        p1.close();
        // open new
        Stage st=new Stage();
        Parent pr = FXMLLoader.load(getClass().getResource("/UpdateStudent/UpdateStudent.fxml"));
        Scene scene = new Scene(pr);
        st.setScene(scene);
        st.setTitle("Update Student Page");  
        st.show();
    } catch (IOException ex) {
      Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
    }

    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
}
