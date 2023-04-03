package ServiciosAplicacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DAOImplements.DAOException;
import DAOImplements.DAOManagerImp;
import FormatoValidaciones.Validaciones;
import Modelo.Cliente;
import Modelo.Cuenta;

public class Agregar {
    public static Scanner entradaTecladoCadena = new Scanner(System.in);
    public static Scanner entradaTecladoINT = new Scanner(System.in);
    public static Validaciones verificador = new Validaciones();
    public static DAOManagerImp managerDAO = new DAOManagerImp();
    
    public boolean agregarNuevoCliente(){
        boolean aprobadoCliente; 
        Cliente clienteNuevo = new Cliente();
        String nombreCliente;
        Long numeroCliente;
        System.out.println("Agregar nuevo Cliente");
        System.out.println("Ingrese el nombre completo del cliente \n");
        nombreCliente = entradaTecladoCadena.nextLine();
       
        
        System.out.println("Ingrese el numero del cliente (16 digitos)");
        numeroCliente =entradaTecladoINT.nextLong();

        
        clienteNuevo.setNumeroCliente(numeroCliente);
        clienteNuevo.setNombreCliente(nombreCliente);

          aprobadoCliente=verificador.validarClienteNuevo(clienteNuevo);
        if(aprobadoCliente==true){
            try {
                managerDAO.getClienteDAO().agregar(clienteNuevo);
            } catch (DAOException e) {
                e.printStackTrace();
            }
            System.out.println("Operacion realizada con exito");
            return true;
        }else{
            System.out.println("Verifique los datos del cliente");
            return false;
        }
    }

    public boolean agregarNuevaCuenta(){
        List<Cliente> listaClientes= new ArrayList<>();
        Scanner entrada= new Scanner(System.in);
        Cuenta nuevaCuenta= new Cuenta();
        int opcion;
        boolean aprobadoCuenta; 
        boolean procesoExitoso=false;
        Agregar agregarClienteN = new Agregar();
        do {
            System.out.println("Agregar nueva cuenta");
            System.out.println("1.-Aregar a cliente existente");
            System.out.println("2.- Agrear a cliente nuevo");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    try {
                        listaClientes= managerDAO.getClienteDAO().obtenerTodos();
                    } catch (DAOException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Lista de Clientes \n");
                    for(int i=0; i<listaClientes.size(); i++) {
                        System.out.println(i+".-"+listaClientes.get(i).toString());
                    }
                    
                    System.out.println("\n Ingrese el numero de lista del cliente que desee utilizar");
                    int clienteSeleccionado = entrada.nextInt();

                    System.out.println("Ingrese el numero de la cuenta nueva(16 digitos)");
                    long numCuenta = entrada.nextLong();

                    entrada.nextLine();
                    System.out.println("Ingrese el saldo inicial de la cuenta");
                    double saldoNuevo = entrada.nextDouble();

                    nuevaCuenta.setNumeroCliente(listaClientes.get(clienteSeleccionado).getNumeroCliente());
                    nuevaCuenta.setNumeroCuenta(numCuenta);
                    nuevaCuenta.setSaldo(saldoNuevo);

                    aprobadoCuenta = verificador.validaCuentaNueva(nuevaCuenta);
                    if(aprobadoCuenta ==true){
                        try {
                            managerDAO.getCuentaDAO().agregar(nuevaCuenta);
                        } catch (DAOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Operacion realizada con exito");
                        procesoExitoso= true;
                    }else{
                        System.out.println("Verifique los datos del cliente");
                        procesoExitoso= false; 
                    }
                    break;
                case 2:
                    System.out.println("Primero se debe crear el cliente para agregar la cuenta");
                    boolean procesoAprobado; 
                    do {
                        procesoAprobado= agregarClienteN.agregarNuevoCliente();
                    } while (procesoAprobado=false);

                    try {
                        listaClientes= managerDAO.getClienteDAO().obtenerTodos();
                    } catch (DAOException e) {
                        e.printStackTrace();
                    }

                    do {
                        System.out.println("Se creara una cuenta para el siguiente cliente");
                        System.out.println("Nombre del cliente: "+listaClientes.get(listaClientes.size()-1).getNombreCliente());

                        System.out.println("Ingrese el numero de la cuenta nueva(16 digitos)");
                        long numCuentaN = entrada.nextLong();

                        entrada.nextLine();
                        System.out.println("Ingrese el saldo inicial de la cuenta");
                        double saldoNuevoS = entrada.nextDouble();

                        nuevaCuenta.setNumeroCliente(listaClientes.get(listaClientes.size()-1).getNumeroCliente());
                        nuevaCuenta.setNumeroCuenta(numCuentaN);
                        nuevaCuenta.setSaldo(saldoNuevoS);
                            
                        aprobadoCuenta = verificador.validaCuentaNueva(nuevaCuenta);
                        if(aprobadoCuenta ==true){
                            try {
                                managerDAO.getCuentaDAO().agregar(nuevaCuenta);
                            } catch (DAOException e) {
                                e.printStackTrace();
                            }
                            System.out.println("Operacion realizada con exito");
                            procesoExitoso= true;
                        }else{
                            System.out.println("Verifique los datos del cliente");
                            procesoExitoso= false; 
                        }  
                    } while (procesoExitoso=false);
  
                    break;    
            
                default:
                System.out.println("Esa no es una opcion valida");
                    break;
            }

        } while (opcion!=1 && opcion != 2);
       
        return procesoExitoso;
    }
}
