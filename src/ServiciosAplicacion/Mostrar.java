package ServiciosAplicacion;

import java.util.ArrayList;
import java.util.List;

import DAOImplements.DAOException;
import DAOImplements.DAOManagerImp;
import Modelo.Cliente;
import Modelo.Cuenta;

public class Mostrar {
    public static DAOManagerImp managerDAO = new DAOManagerImp();
    
    public void  mostrarClientesCuenta(){
        
        List<Cliente> listaClientes= new ArrayList<>();
        List<Cuenta> listaCuentas= new ArrayList<>();
        
        Cliente cliente = new Cliente();
        Cuenta cuenta = new Cuenta();
        try {
            listaClientes= managerDAO.getClienteDAO().obtenerTodos();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        try {
            listaCuentas= managerDAO.getCuentaDAO().obtenerTodos();
        } catch (DAOException e) {
            e.printStackTrace();
        }

        System.out.println("Lista de clientes y cuentas");
        for(int i=0; i<listaClientes.size(); i++) {
            ArrayList<Cuenta> listaCuentasCliente= new ArrayList<>();
            cliente = listaClientes.get(i);
            for(int j=0; j<listaCuentas.size(); j++) {
                cuenta = listaCuentas.get(j);
                 if(cliente.getNumeroCliente().equals(cuenta.getNumeroCliente())){
                    listaCuentasCliente.add(listaCuentas.get(j)); 
                }
            }
            cliente.setCuentas(listaCuentasCliente);
            System.out.println(cliente.toString());
        }
        
    }

}
