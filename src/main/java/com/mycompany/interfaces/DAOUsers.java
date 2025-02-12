
package com.mycompany.interfaces;

import com.mycompany.models.Users;
import java.util.List;


public interface DAOUsers {
    public void registrar(Users users) throws Exception;
    public void modificar(Users users) throws Exception;
    public void eliminar(int userId) throws Exception;
    public List<Users> listar(String ced) throws Exception;
    public Users getUserId(int userId) throws Exception;
}
