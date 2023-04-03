package DAOImplements;

import ModeloDAO.ClienteDAO;
import ModeloDAO.CuentaDAO;
import ModeloDAO.DAOManager;

public class DAOManagerImp implements DAOManager {
    private ClienteDAO clienteDAO =null;
    private CuentaDAO cuentaDAO =null;

    @Override
    public ClienteDAO getClienteDAO() {
        if(clienteDAO==null){
            clienteDAO = new ClienteDAOimp();
        }
        return clienteDAO ;
    }

    @Override
    public CuentaDAO getCuentaDAO() {
        if(cuentaDAO==null){
            cuentaDAO = new CuentaDAOimp();
        }
        return cuentaDAO ;
    }
    
}
