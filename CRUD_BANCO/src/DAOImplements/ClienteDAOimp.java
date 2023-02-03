package DAOImplements;

import java.util.ArrayList;
import java.util.List;

import Modelo.Cliente;
import ModeloDAO.ClienteDAO;
import ServiciosArchivos.EscritorArchivos;
import ServiciosArchivos.LectorArchivos;
import FormatoValidaciones.Convertidor;
public class ClienteDAOimp implements ClienteDAO {

    @Override
    public void agregar(Cliente cliente) {
        EscritorArchivos writer = new EscritorArchivos();
        writer.anadirCliente("../clientes_Banco", cliente);
        
    }

    @Override
    public void eliminar(Cliente e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void modificar(Cliente e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Cliente obtener(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<Cliente> obtenerTodos() {
        LectorArchivos lector = new LectorArchivos();
        ArrayList<String> listaClientesBruto = new ArrayList<String>();
        ArrayList<Cliente> listaClientesFinal = new ArrayList<Cliente>();
        Convertidor convertidor = new Convertidor();
        
        lector.leerArchivo("../clientes_Banco.txt", listaClientesBruto);
        convertidor.convertirClientes(listaClientesBruto, listaClientesFinal);
        return listaClientesFinal;
    }
    
}
