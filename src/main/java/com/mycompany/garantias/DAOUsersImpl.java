
package com.mycompany.garantias;

import com.mycompany.db.DataBase;
import com.mycompany.interfaces.DAOUsers;
import com.mycompany.models.Users;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DAOUsersImpl extends DataBase implements DAOUsers {

    @Override
    public void registrar(Users user) throws Exception {
        try {
            this.Conect();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO users(id_users, name, apellido_p, apellido_m, direccion, telefono) VALUES(?,?,?,?,?,?)");
            st.setString(1, user.getId_users());
            st.setString(2, user.getName());
            st.setString(3, user.getApellido_p());
            st.setString(4, user.getApellido_m());
            st.setString(5, user.getDireccion());
            st.setString(6, user.getTelefono());
            st.executeUpdate();
        } catch(Exception e){
            throw e;
        } finally{
            this.Close();
        }
    }

    @Override
    public void modificar(Users user) throws Exception {
        try {
            this.Conect();
            PreparedStatement st = this.conexion.prepareStatement("UPDATE  users SET name = ?, apellido_p = ?, apellido_m = ?, direccion = ?, telefono  = ?  WHERE  id_users = ? ");
            st.setString(1, user.getName());
            st.setString(2, user.getApellido_p());
            st.setString(3, user.getApellido_m());
            st.setString(4, user.getDireccion());
            st.setString(5, user.getTelefono());
            st.setString(6, user.getId_users());
                    
            st.executeUpdate();
        } catch(Exception e){
            throw e;
        } finally{
            this.Close();
        }
    }

    @Override
    public void eliminar(int userId) throws Exception {
        try {
            this.Conect();
            // indicamos donde buscar en la bd para eliminar los usuarios, de la tabla users y en la columna "id_users"
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM users WHERE id_users = ?;");
            st.setInt(1, userId);
            st.executeUpdate();
        } catch(Exception e){
            throw e;
        } finally{
            this.Close();
        }
    }

    @Override
    public List<Users> listar(String ced) throws Exception {
        List<Users> lista = null;
        try{
            // nos conectamos a la base de datos
            // y consultamos todos los datos dentro de ella
            this.Conect();
            // validamos 
            String Query = ced.isEmpty() ? "SELECT * FROM users;" : "SELECT * FROM users WHERE id_users LIKE '%"+ ced +"%';";
            PreparedStatement st = this.conexion.prepareStatement(Query);
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            // ciclo que itera todos los registros de la bd
            while(rs.next()){
                // creamos el objeto "users"
                Users user = new Users();
                // le agregamos cada una de sus propiedades
                user.setId_users(rs.getString("id_users"));
                user.setName(rs.getString("name"));
                user.setApellido_p(rs.getString("apellido_p"));
                user.setApellido_m(rs.getString("apellido_m"));
                user.setDireccion(rs.getString("direccion"));
                user.setTelefono(rs.getString("telefono"));
                // se agrega a una lista
                lista.add(user);
            }
            rs.close();
            st.close();
        }catch(Exception e){
            throw e;
        }finally {
            this.Close();
        }
        return lista;
    }

    @Override
    public Users getUserId(int userId) throws Exception {
        // Instanseamos al objeto usuario
        Users user = null;
        try{
            // nos conectamos a la base de datos
            // y consultamos todos los datos dentro de ella
            this.Conect();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM users WHERE id_users = ? LIMIT 1;");
            st.setInt(1, userId);
            ResultSet rs = st.executeQuery();
            // ciclo que itera todos los registros de la bd
            while(rs.next()){
                user = new Users();
                user.setId_users(rs.getString("id_users"));
                user.setName(rs.getString("name"));
                user.setApellido_p(rs.getString("apellido_p"));
                user.setApellido_m(rs.getString("apellido_m"));
                user.setDireccion(rs.getString("direccion"));
                user.setTelefono(rs.getString("telefono"));
            }
            rs.close();
            st.close();
        }catch(Exception e){
            throw e;
        }finally {
            this.Close();
        }
        // retornamos el objeto user con todas sus propiedades
        return user;
    }
    
}
