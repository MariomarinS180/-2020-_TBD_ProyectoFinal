
package controlador;
import conexionPostgreSQL.Conexion; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.BibliotecaLibros; 
import Ventanas_ABCC.Ventana; 
/**
 *
 * @author marin
 */
public class LibrosDAO {
    public boolean agregarLibro(BibliotecaLibros bl){
        String sql = "INSERT INTO libros('"+bl.getNombre()+"','"+bl.getEditorial()+"',"+bl.getNumero_de_Cajas()+","+bl.getAnio_de_Edicion()+",'"+bl.getGenero_libro()+"',"+bl.getPrecio()+",'"+bl.getAutor_Libro()+"','"+bl.getPais_Autor()+"','"+bl.getRegistrador()+"');";
        boolean res = new Conexion().ejecutarInstruccion(sql); 
        return res; 
    }
    public static String verificarSiExisteUnLibro(String nombre) {
        Connection conexion;
        String validacion = null;
        try {
            conexion = Conexion.getConnection();
            String condicion = "SELECT nombre_libro FROM libros WHERE nombre_libro = ?";
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
