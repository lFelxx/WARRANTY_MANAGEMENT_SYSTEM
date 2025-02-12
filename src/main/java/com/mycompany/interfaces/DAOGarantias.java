
package com.mycompany.interfaces;

import com.mycompany.models.Garantias;
import java.util.List;

// metodos de manejo de garantias
public interface DAOGarantias {
    public void registrar(Garantias garant) throws Exception;
    public void apobGar(Garantias garant, String typeGar) throws Exception;
    public void modificar(Garantias garant) throws Exception;
    public void eliminar(int garantId, String typeGar) throws Exception;
    public List<Garantias> listar(String fact, String typegar) throws Exception;
    public List<Garantias> listarGarApro(String fact) throws Exception;
    public Garantias getGarantId(int garantId, String typeGar) throws Exception;
}
