package conexionPostgreSQL;
import Ventanas_ABCC.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
public class Conexion {
    private String r;
    static Connection con;
    private static PreparedStatement ps;
    private static ResultSet rs;
    private Statement stm; 
    
    public static Connection getConnection(){
        String url = "jdbc:postgresql://localhost:5432/BD_Biblioteca";
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No se pudo establecer la conexion" + e.getMessage(),"Error de Conexion",JOptionPane.ERROR_MESSAGE);
        }
        try {
            con = DriverManager.getConnection(url,"mmarin","03082000s");
        } catch (SQLException e) {
        }
        return con;
    }
    
    public boolean ejecutarInstruccion(String sql){
        boolean res = false;
        try {
            stm = con.createStatement(); 
            stm.execute(sql); 
            res = true;  
        } catch (Exception ex) {
           Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (Exception ex) {
             Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);    
            }
        }
        return res; 
    }
    
    public static ResultSet ejecutarConsultaDeRegistros(String sql){
        ResultSet rs = null;
        try {
            ps= con.prepareStatement(sql);
            return ps.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
            return rs;
        }
    }
    
    public static ResultSet Consulta(String consulta){
        Connection con = getConnection();
        Statement declara;
        try{
            declara=con.createStatement();
            ResultSet respuesta = declara.executeQuery(consulta);
            return respuesta;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(),
            "Error de Conexion",JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public static ArrayList<String> llenar_combo(){
        Connection con = getConnection();
        Statement res; 
       ArrayList<String> lista = new ArrayList<String>();
       String sql = "SELECT * FROM Registrador"; 
        try {
            res = con.createStatement();
            rs = res.executeQuery(sql); 
            //System.out.print("Correcto");
        } catch (Exception e) {
            //System.out.print("No Correcto");
        }
        try {
            while(rs.next()){
                lista.add(rs.getString("nombre"));
            }
        } catch (Exception e) {
        }              
       return lista;
    }
    public void cerrarConexion(){
        try {
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]) {
         VentanaLogin.main(args);
    }

}
