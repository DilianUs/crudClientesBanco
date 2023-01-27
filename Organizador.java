import java.util.ArrayList;

/*
 * Author:Dilian Us
 * date:16/01/2023
 * email:dilian0217@gmail.com
 */
public class Organizador {
    public void imprimirClientes(ArrayList<String> listaClientes) {

        for(int i=0; i<listaClientes.size();i++){
            String[] datosCliente = listaClientes.get(i).split(",");
            System.out.println("N#: "+datosCliente[0]+" Nombre: "+datosCliente[1]+" N.Cuenta: "+datosCliente[2]+" Saldo: "+datosCliente[3]);
            //System.out.println(listaClientes.get(i));
        }
    }
}
