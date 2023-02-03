import java.util.ArrayList;
/*
 * Author:Dilian Us
 * date:16/01/2023
 * name:clientes_Banco
 * email:dilian0217@gmail.com
 * description: Imprimir datos de clientesde un banco, guardados en un documento de texto
 */

import FormatoValidaciones.Convertidor;
import FormatoValidaciones.Validaciones;
import Modelo.Cliente;
import ServiciosArchivos.EscritorArchivos;
import ServiciosArchivos.LectorArchivos;

public class Main {
    public static void main(String[] args) {
        LectorArchivos lector = new LectorArchivos();
        ArrayList<String> listaClientes = new ArrayList<String>();
        Convertidor organizador = new Convertidor();
        Validaciones verificador = new Validaciones();

        lector.leerArchivo("../clientes_Banco.txt", listaClientes);
        organizador.imprimirClientes(listaClientes);

        EscritorArchivos write = new EscritorArchivos();
        Cliente clienteNuevo = new Cliente();
        clienteNuevo.setNumeroCliente("1234567891232343");
        clienteNuevo.setNombreCliente("Jose Adrian Pech Medina");
        clienteNuevo.setNumeroCuenta("1232343454534522");
        clienteNuevo.setSaldoCliente("1.6");
        
        if(verificador.validarClienteNuevo(clienteNuevo)){
            write.anadirCliente("clientes_Banco.txt", clienteNuevo);
       }else{
           System.out.println("Llene los datos del cliente correctamente");
       } 
        
    }
}