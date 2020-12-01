
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
        String sql = "INSERT INTO libros VALUES('"+bl.getNombre()+"','"+bl.getEditorial()+"','"+bl.getNumero_de_Cajas()+"','"+bl.getAnio_de_Edicion()+"','"+bl.getGenero_libro()+"','"+bl.getPrecio()+"','"+bl.getAutor_Libro()+"','"+bl.getPais_Autor()+"','"+bl.getRegistrador()+"');";
        boolean res = new Conexion().ejecutarInstruccion2(sql);
        return res; 
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
