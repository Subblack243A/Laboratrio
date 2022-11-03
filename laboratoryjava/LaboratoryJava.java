package laboratoryjava;

import java.sql.*;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LaboratoryJava {

    public static void main(String[] args) {
        Connection conec;
        Statement state;
        ResultSet reset;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LaboratoryJava.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conec = DriverManager.getConnection("jdbc:mysql://localhost:3306/laboratory", "root", "");
            state = conec.createStatement();
            state.executeUpdate("INSERT INTO personas VALUES (null, 'Maria Cruz','1990-02-12')");
            //Aqui leeremos los datos
            reset = state.executeQuery("SELECT * FROM personas");
            reset.next();
            do {                
                System.out.print("ID: " + reset.getString("ID") + "\nNombre: " + reset.getString("Nombre") + "\nNacimiento: " + reset.getString("Nacimiento") + "\n");
            } while (reset.next());
        } catch (SQLException ex) {
            Logger.getLogger(LaboratoryJava.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
