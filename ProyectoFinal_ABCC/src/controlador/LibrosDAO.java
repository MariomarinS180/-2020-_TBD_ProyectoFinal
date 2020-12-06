
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
public class LibrosDAO{   
    public boolean eliminarLibro(String codigoLibro) {
		String sql = "DELETE FROM Libros WHERE codigo_libro = '"+codigoLibro+"'";
		return new Conexion().ejecutarInstruccion(sql);
	}
    public boolean modificarLibro(BibliotecaLibros b){
        String sql = "UPDATE Libros SET nombre_libro= '"+b.getNombre()+"', editorial_libro='"+b.getEditorial()+"', num_paginas="+b.getNumero_de_Cajas()+", anio_edicion="+b.getAnio_de_Edicion()+", genero='"+b.getGenero_libro()+"', precio="+b.getPrecio()+", autor_libro='"+b.getAutor_Libro()+"', pais_autor='"+b.getPais_Autor()+"' WHERE codigo_libro = "+b.getCodigo()+""; 
        return new Conexion().ejecutarInstruccion(sql); 
    }
    public boolean agregarUsuario(InicioDeSesion i){
        String sql = "INSERT INTO usuarios VALUES('"+i.getUsuario()+"', '"+i.getPassword()+"');";
        return new Conexion().ejecutarInstruccion(sql); 
    }
    /*
    public boolean altaLibro(BibliotecaLibros b){
        String nombre = b.getNombre(); 
        String editorial = b.getEditorial(); 
        int num_paginas = b.getNumero_de_Cajas(); 
        int anio = b.getAnio_de_Edicion(); 
        String genero = b.getGenero_libro(); 
        int precio = b.getPrecio(); 
        String autor = b.getAutor_Libro(); 
        String pais = b.getPais_Autor(); 
        int registrador = b.getRegistrador(); 
        
        boolean ejecucionCorrecta = false; 
        
        String sql = "INSERT INTO libros VALUES('"+nombre+
                "','"+editorial+
                 "','"+num_paginas+
                 "','"+anio+
                 "','"+genero+
                 "','"+precio+
                 "','"+autor+
                 "','"+pais+
                 "','"+registrador+"')";
        ejecucionCorrecta = Conexion.ejecutarInstruccion(sql); 
    }
    */
    
    
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
