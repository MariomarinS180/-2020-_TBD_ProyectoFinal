package conexionPostgreSQL;

import Ventanas_ABCC.Ventana;
import Ventanas_ABCC.VentanaLogin;
import java.sql.*;
public class Conexion {
    
    public static void main(String[] args) {
        Ventana.main(args);
        String url = "jdbc:postgresql://localhost:5432/BD_Biblioteca"; 
        String usuario = "mmarin"; 
        String contrasenia = "03082000s"; 
        
        try {
            Class.forName("org.postgresql.Driver"); 
            Connection conexion = DriverManager.getConnection(url, usuario, contrasenia); 
            java.sql.Statement st = conexion.createStatement(); 
            String sql 
                    = "SELECT id_registrador, nombre, apellido_paterno, apellido_materno FROM registrador"; 
            ResultSet rs  = st.executeQuery(sql); 
            while(rs.next()){
                String id = rs.getString("id_registrador"); 
                String nombre = rs.getString("nombre"); 
                String primerap = rs.getString("apellido_paterno"); 
                String segundoap = rs.getString("apellido_materno"); 
                 System.out.println("ID: " + id + " <<Nombre: " + nombre + " PrimerAP: " + primerap + " SegundoAP: "+ segundoap ); 
            }
            rs.close();
            st.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("ERROR DE CONEXIÓN " + e.getMessage());
        }   
    }
}
