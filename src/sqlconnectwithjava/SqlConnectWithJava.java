 /*first download sqlconnector for java
you can download it for mysql website 
and extract it
then you add the jarfile to the library of the project
then write code like it
*/
package sqlconnectwithjava;//give your package name . my package name is sqlconnectwithjava
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SqlConnectWithJava extends javax.swing.JFrame {

      public SqlConnectWithJava () {
        //initComponents(); it will write automatically when you make an jframe
        connect();
      }
      Connection con;
    PreparedStatement pst;
    
     public void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost/client","root","Password@66");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SqlConnectWithJava.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnectWithJava.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      private void btnsubmitActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
            String name=txtname.getText();
            String phone=txtphone.getText();
            String address=txtaddress.getText();
            String age=txtage.getText();
            
            
            pst =con.prepareStatement("insert into example(name,phone,address,age)values(?,?,?,?)");
            pst.setString(1, name);
            pst.setString(2, phone);
            pst.setString(3, address);
            pst.setString(4, age);
            int k=pst.executeUpdate();
            
            if (k==1){
                JOptionPane.showMessageDialog(this,"record added successfully");
                //txtname.setText("");
                //txtphone.setText("");
                //txtaddress.setText("");
                ?/txtage.setText("");
                //txtname.requestFocus();
                
            }else{
                 JOptionPane.showMessageDialog(this,"record added failed");
            }
   
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
