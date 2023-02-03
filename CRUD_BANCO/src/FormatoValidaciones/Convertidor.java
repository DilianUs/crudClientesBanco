package FormatoValidaciones;
import java.util.ArrayList;

import Modelo.Cliente;

/*
 * Author:Dilian Us
 * date:16/01/2023
 * email:dilian0217@gmail.com
 */
public class Convertidor {
    public void convertirClientes(ArrayList<String> listaClientesTXT,ArrayList<Cliente> listaClientesRecuperados) {

        for(int i=0; i<listaClientesTXT.size();i++){
            String[] datosCliente = listaClientesTXT.get(i).split(",");
            Cliente clienteRecuperado = new Cliente();
            clienteRecuperado.setNumeroCliente(datosCliente[0]);
            clienteRecuperado.setNombreCliente(datosCliente[1]); 
            clienteRecuperado.setNumeroCuenta(datosCliente[2]); 
            clienteRecuperado.setSaldoCliente(datosCliente[3]); 
            listaClientesRecuperados.add(clienteRecuperado);
           
        }
    }
}
