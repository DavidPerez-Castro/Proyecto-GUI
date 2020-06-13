
package proyectogui.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class TransaccioDBPersona extends TransaccionDB<Persona>{

    public TransaccioDBPersona(Persona pojo) {
        super(pojo);
    }

    @Override
    public boolean execute(Connection conn) {  
        boolean res=false;
        try {
        String sql="insert into persona (clave, nombre, direccion, telefono) values (?,?,?,?)";
        PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, pojo.getClave());
            ps.setString(2, pojo.getNombre());
            ps.setString(3, pojo.getDireccion());
            ps.setString(4, pojo.getTelefono());
       
            ps.execute();
            System.out.println("Se guardo");
            res=true;
        } catch (SQLException ex) {
            Logger.getLogger(TransaccioDBPersona.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return res;
        
    }
    
}
