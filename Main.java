import java.util.ArrayList;
/*
 * Author:Dilian Us
 * date:16/01/2023
 * name:clientes_Banco
 * email:dilian0217@gmail.com
 * description: Imprimir datos de clientesde un banco, guardados en un documento de texto
 */

public class Main {
    public static void main(String[] args) {
        LectorArchivos lector = new LectorArchivos();
        ArrayList<String> listaClientes = new ArrayList<String>();
        Organizador organizador = new Organizador();
        Validaciones verificador = new Validaciones();
        
        lector.leerArchivo("clientes_Banco.txt", listaClientes);
        organizador.imprimirClientes(listaClientes);

        EscritorArchivos write = new EscritorArchivos();
        Cliente clienteNuevo = new Cliente();
        clienteNuevo.setNumeroCliente("1234567891232343");
        clienteNuevo.setNombreCliente("Jose Adrian Us Medina");
        clienteNuevo.setNumeroCuenta("1232343454534522");
        clienteNuevo.setSaldoCliente("1.5");
        
        if(verificador.validarClienteNuevo(clienteNuevo)){
            write.anadirCliente("clientes_Banco.txt", clienteNuevo);
       }else{
           System.out.println("Llene los datos del cliente correctamente");
       } 
        
    }
}