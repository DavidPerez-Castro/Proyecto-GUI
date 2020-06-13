package proyectogui.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class ConexionBD {
    private static ConexionBD con=null;
    public static ConexionBD getInstance(){
        if(con==null)
            con=new ConexionBD();
        return con;
    }
    private Connection conn = null;
    
    private ConexionBD(){
        String urlDatabase = "jbc:postgresql://localhost:5432/CRUD";
         try{
             Class.forName("org.postgresql.Driver");
             conn = DriverManager.getConnection(urlDatabase, "postgres", "password");
             } catch (Exception e) {
            System.out.println("Ocurrio un error:" + e.getMessage());
        }
        System.out.println("La conexion se realizo sin problemas");
    }
    
    public boolean execute(String sql){
        boolean res=false;
        try{
            
            Statement st=conn.createStatement();
            st.execute(sql);
            res=true;
        } catch (SQLException ex){
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
         }
   
    public boolean execute(TransaccionDB t){
        boolean res=false;
        
        res= t.execute(conn);
        return res;
    }
}