
package controlador;

import conexionPostgreSQL.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author marin
 */
public class InicioDeSesion {
    public InicioDeSesion(){}
    private String usuario; 
    private String password; 
    public InicioDeSesion(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }
    public String getUsuario() {
        return usuario;
    }
    public String getPassword() {
        return password;
    }  
    
    
    public static String verificarSiExisteUnUsuario(String nombre) {
        Connection conexion;
        String validacion = null;
        try {
            conexion = Conexion.getConnection();
            String condicion = "SELECT usuario FROM usuarios WHERE usuario = ?";
            PreparedStatement pst = conexion.prepareStatement(condicion);
            pst.setString(1, nombre);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                validacion = "YA EXISTE ESE USUARIO";
            } else {
                validacion = "NO EXISTE ESE USUARIO";
            }
        } catch (Exception e) {
            
        }
        return validacion; 
    }
}
