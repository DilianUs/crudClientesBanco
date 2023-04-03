package ModeloDAO;

import java.util.List;
import DAOImplements.DAOException;

public interface DAO<Objeto,TipoID>{

    void agregar(Objeto e) throws DAOException;
    void eliminar(Objeto e) throws DAOException;
    void modificar(Objeto e) throws DAOException;
    Objeto obtener(TipoID id) throws DAOException;
    List<Objeto> obtenerTodos()throws DAOException;
}
