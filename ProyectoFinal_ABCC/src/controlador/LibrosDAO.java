
package controlador;
import conexionPostgreSQL.Conexion; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author marin
 */
public class LibrosDAO {
    public static String verificarSiExisteUnLibro(String nombre) {
        Connection conexion;
        String validacion = null;
        try {
            conexion = Conexion.getConnection();
            String condicion = "SELECT nombre_libro FROM Libros WHERE nombre_libro = ?";
            PreparedStatement pst = conexion.prepareStatement(condicion);
            pst.setString(1, nombre);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                validacion = "YA EXISTE ESE LIBRO";
            } else {
                validacion = "NO EXISTE ESE LIBRO";
            }
        } catch (Exception e) {
            
        }
        return validacion; 
    }

}
