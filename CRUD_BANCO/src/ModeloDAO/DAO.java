package ModeloDAO;

import java.util.ArrayList;

public interface DAO<Objeto,TipoID>{

    void agregar(Objeto e) ;
    void eliminar(Objeto e);
    void modificar(Objeto e);
    Objeto obtener(TipoID id);
    ArrayList<Objeto> obtenerTodos();
}
