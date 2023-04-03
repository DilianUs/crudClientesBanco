package ServiciosAplicacion;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DAOImplements.DAOException;
import DAOImplements.DAOManagerImp;
import FormatoValidaciones.Validaciones;
import Modelo.Cliente;
import Modelo.Cuenta;
public class Modificar {
    public static DAOManagerImp managerDAO = new DAOManagerImp();
    public static Validaciones verificador = new Validaciones();

    public boolean modificarNombreCliente(){
        List<Cliente> listaClientes= new ArrayList<>();
        Scanner entrada= new Scanner(System.in);
        Cliente clienteModificado= new Cliente();
        boolean aprobadoCliente; 

        try {
            listaClientes= managerDAO.getClienteDAO().obtenerTodos();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        System.out.println("Modificar datos de cliente");
        System.out.println("----Lista de Clientes----");
        for(int i=0; i<listaClientes.size(); i++) {
            System.out.println(i+".-"+listaClientes.get(i).getNombreCliente());
        }
        System.out.println("\n Ingrese el numero de lista del cliente que desee modificar");
        int clienteSeleccionado = entrada.nextInt();

        entrada.nextLine();
        System.out.println("Ingrese modificacion al nombre del titular(nombre completo)");
        String nuevoNombre = entrada.nextLine();

        clienteModificado = listaClientes.get(clienteSeleccionado);
        clienteModificado.setNombreCliente(nuevoNombre);

        aprobadoCliente = verificador.validarClienteNuevo(clienteModificado);

        if(aprobadoCliente==true){
            System.out.println("Esta seguro de cambiar el nombre del cliente:" + listaClientes.get(clienteSeleccionado).getNombreCliente() +"?");
            System.out.println(nuevoNombre);
            
            System.out.println("SI(S) ------ NO(N)");
            String desicionModificar = entrada.nextLine();
            
            if(desicionModificar.equals("S")){
                System.out.println("Se modificara al cliente seleccionado");
                try {
                    managerDAO.getClienteDAO().modificar(clienteModificado);
                } catch (DAOException e) {
                    e.printStackTrace();
                } 
                System.out.println("Operacion realizada con exito");
                
                return true;
            }else{
                if(desicionModificar.equals("N")){
                    System.out.println("Operacion cancelada...\n Regresando al menú principal");
                    
                    return true;
                }else{
                    System.out.println("La opcion está fuera de rango, reresando al menú principal");
                    
                    return true;
                }
            }

        }else{
            System.out.println("Ocurrio un error en los nuevos datos del cliente, regresando al menu principal");
           
            return false;
        }
        

    }

    public boolean agregarSaldo(){
        List<Cliente> listaClientes= new ArrayList<>();
        List<Cuenta> listaCuentas= new ArrayList<>();
        List<Cuenta> listaCuentasCliente= new ArrayList<>();
        Scanner entrada= new Scanner(System.in);
        boolean aprobadoCuenta; 
        Cuenta cuentaDeposito = null;
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

        System.out.println("Es requerido conocer el nombre del titular de la cuenta");
        for(int i=0; i<listaClientes.size(); i++) {
            System.out.println(i+".-"+listaClientes.get(i).getNombreCliente());
        }
        System.out.println("Escriba el numero de lista que corresponda al titular");
        int titularSeleccionado = entrada.nextInt();
        
        Cliente clienteTitular = listaClientes.get(titularSeleccionado);
        int numeroCuentas =0;
        System.out.println("Cuentas pertenecientes a :" + clienteTitular.getNombreCliente());

        for(int i=0; i<listaCuentas.size(); i++) {
            if(listaCuentas.get(i).getNumeroCliente().equals(clienteTitular.getNumeroCliente())){
                listaCuentasCliente.add(listaCuentas.get(i)); 
                numeroCuentas++;
            }
        }
        if(numeroCuentas==0){
            System.out.println("El cliente no tiene cuentas activas, regresando al menu primcupal");
            
            return true;
        }else{
             for(int i=0; i<listaCuentasCliente.size(); i++) {
                if(listaCuentasCliente.get(i).getNumeroCliente().equals(clienteTitular.getNumeroCliente())){
                    System.out.println(i+".-"+listaCuentasCliente.get(i).toString());  
                }
            }

            entrada.nextLine();
            System.out.println("Ingrese el numero de lista que corresponda a la cuenta a hacer deposito");
            int cuentaSeleccionada = entrada.nextInt();
            
            entrada.nextLine();
            System.out.println("Ingrese el saldo a depositar");
            double saldoNuevo = entrada.nextDouble();


            cuentaDeposito= listaCuentasCliente.get(cuentaSeleccionada);
            cuentaDeposito.setSaldo(cuentaDeposito.getSaldo()+saldoNuevo);

            aprobadoCuenta = verificador.validaCuentaNueva(cuentaDeposito);

            if(aprobadoCuenta==true){
                try {
                    managerDAO.getCuentaDAO().modificar(cuentaDeposito);
                } catch (DAOException e) {
                    e.printStackTrace();
                }
                System.out.println("Operacion realizada con exito");
                
                return true;
            }else{
                System.out.println("Saldo ingresado erroneamente, regreando a menu principal");
                
                return true;
            }
        }

    }
}
