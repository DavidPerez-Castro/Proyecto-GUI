/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectogui.db;

import java.sql.Connection;

/**
 *
 * @author david
 */
public abstract class TransaccionDB<T> {
    protected T pojo;
    
    public TransaccionDB(T pojo){
        this.pojo=pojo;
    }
    
    public abstract boolean execute(Connection conn);
   
}
