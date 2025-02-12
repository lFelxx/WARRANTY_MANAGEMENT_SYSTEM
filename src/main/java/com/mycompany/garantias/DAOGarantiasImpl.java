
package com.mycompany.garantias;

import com.mycompany.models.Garantias;
import com.mycompany.db.DataBase;
import com.mycompany.interfaces.DAOGarantias;
import com.mycompany.models.Users;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DAOGarantiasImpl extends DataBase implements DAOGarantias{

    @Override
    public void registrar(Garantias garant) throws Exception {
        try {
            this.Conect();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO garantiasregis (Factura, precioProduct, cedulaClient, nameClient, Apellido, Telefono, Daño) VALUES(?,?,?,?,?,?,?);");
            st.setString(1, garant.getFactura());
            st.setString(2, garant.getPrice());
            st.setString(3, garant.getUserCed());
            st.setString(4, garant.getUserName());
            st.setString(5, garant.getApellido());
            st.setString(6, garant.getTelefono());
            st.setString(7, garant.getDamag());
            st.executeUpdate();
            st.close();
        } catch(Exception e){
            throw e;
        } finally{
            this.Close();
        }
    }

    @Override
    public void modificar(Garantias garant) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(int garantId, String typeGar) throws Exception {
        try {
            this.Conect();
            // indicamos donde buscar en la bd para eliminar los usuarios, de la tabla users y en la columna "id_users"
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM "+typeGar+" WHERE id_garantia = ?;");
            st.setInt(1, garantId);
            st.executeUpdate();
        } catch(Exception e){
            throw e;
        } finally{
            this.Close();
        }
    }


    @Override
    public Garantias getGarantId(int garantId, String typeGar) throws Exception {
        // Instanseamos al objeto garantia
        Garantias garanti = new Garantias();
        try{
            // nos conectamos a la base de datos
            // y consultamos todos los datos dentro de ella
            this.Conect();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM "+typeGar+" WHERE id_garantia = ? LIMIT 1;");          
            st.setInt(1, garantId);
            ResultSet rs = st.executeQuery();
            // ciclo que itera todos los registros de la bd
            while(rs.next()){
                garanti.setId_garantia(rs.getString("id_garantia"));
                garanti.setFactura(rs.getString("Factura"));
                garanti.setPrice(rs.getString("precioProduct"));
                garanti.setUserCed(rs.getString("cedulaClient"));
                garanti.setUserName(rs.getString("nameClient"));
                garanti.setApellido(rs.getString("Apellido"));
                garanti.setTelefono(rs.getString("Telefono"));
                garanti.setDamag(rs.getString("Daño"));
            }
            rs.close();
            st.close();
        }catch(Exception e){
            throw e;
        }finally {
            this.Close();
        }
        // retornamos el objeto garantia con todas sus propiedades
        return garanti;
    }

    @Override
    public List<Garantias> listar(String fact, String typeGar) throws Exception {
         List<Garantias> lista = null;
        try{
            // nos conectamos a la base de datos
            // y consultamos todos los datos dentro de ella
            this.Conect();
            // validamos 
            String Query = fact.isEmpty() ? "SELECT * FROM "+typeGar+";" : "SELECT * FROM "+typeGar+" WHERE id_garantia LIKE '%"+ fact +"%';";
            PreparedStatement st = this.conexion.prepareStatement(Query);
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            // ciclo que itera todos los registros de la bd
            while(rs.next()){
                // creamos el objeto "garantias"
                Garantias garant = new Garantias();
                // le agregamos cada una de sus propiedades
                garant.setId_garantia(rs.getString("id_garantia"));
                garant.setFactura(rs.getString("Factura"));
                garant.setPrice(rs.getString("precioProduct"));
                garant.setUserCed(rs.getString("cedulaClient"));
                garant.setUserName(rs.getString("nameClient"));
                garant.setApellido(rs.getString("Apellido"));
                garant.setTelefono(rs.getString("Telefono"));
                garant.setDamag(rs.getString("Daño"));
                // se agrega a una lista
                lista.add(garant);
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
    public void apobGar(Garantias garant, String typeGar) throws Exception {
        try {
            this.Conect();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO "+typeGar+" (Factura, precioProduct, cedulaClient, nameClient, Apellido, Telefono, Daño) VALUES(?,?,?,?,?,?,?);");
            st.setString(1, garant.getFactura());
            st.setString(2, garant.getPrice());
            st.setString(3, garant.getUserCed());
            st.setString(4, garant.getUserName());
            st.setString(5, garant.getApellido());
            st.setString(6, garant.getTelefono());
            st.setString(7, garant.getDamag());
            st.executeUpdate();
            st.close();
        } catch(Exception e){
            throw e;
        } finally{
            this.Close();
        }
    }

    @Override
    public List<Garantias> listarGarApro(String fact) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
