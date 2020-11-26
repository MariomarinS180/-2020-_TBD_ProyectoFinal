package conexionPostgreSQL;
import Ventanas_ABCC.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
public class Conexion {
    private String r;
    static Connection con;
    private static PreparedStatement ps;
    private static ResultSet rs;
    
    public static Connection getConnection(){
        String url = "jdbc:postgresql://localhost:5432/BD_Biblioteca";
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No Se pudo Establecer la conexion" + e.getMessage(),"Error de Conexion",JOptionPane.ERROR_MESSAGE);
        }
        try {
            con = DriverManager.getConnection(url,"mmarin","03082000s");
        } catch (SQLException e) {
        }
        return con;
    }
    public boolean ejecutarInstruccion(String sql){
        try {
            ps = con.prepareStatement(sql);
            int r = ps.executeUpdate(sql);
            return r ==1 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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
        //ps es sentencia
        //rs es resultado
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
                lista.add(rs.getString("id_registrador"));
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
         Ventana.main(args);
    }
}
