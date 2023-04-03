import java.util.Scanner;
import ServiciosAplicacion.Agregar;
import ServiciosAplicacion.Eliminar;
import ServiciosAplicacion.Modificar;
import ServiciosAplicacion.Mostrar;

/*
 * Author:Dilian Us
 * date:16/01/2023
 * name:clientes_Banco
 * email:dilian0217@gmail.com
 * description: Imprimir datos de clientesde un banco, guardados en un documento de texto
 */


public class Main {
    public static Scanner entradaTecladoINT = new Scanner(System.in);
    public static Scanner entradaTecladoCadena = new Scanner(System.in);
    public static Agregar agregar = new Agregar();
    public static Eliminar eliminar = new Eliminar();
    public static Modificar modificar = new Modificar();
    public static Mostrar mostrar = new Mostrar();

    public static void main(String[] args) {
        int opcionMenu;
        do {
            
            System.out.println("SISTEMA BANCARIO FARLAND");
            System.out.println("----------Menu----------");
            System.out.println("1.-Agregar Cliente");//finalizado
            System.out.println("2.-Agregar cuenta");//finalizado
            System.out.println("3.-Eliminar Cliente");//finalizado
            System.out.println("4.-Eliminar Cuenta");//finalizado
            System.out.println("5.-Modificar Datos de Cliente");//finalizado
            System.out.println("6.-Mostrar todos los clientes");
            System.out.println("7.-Agregar Saldo a una cuenta");
            System.out.println("8.-Salir del programa");
            opcionMenu = entradaTecladoINT.nextInt();

            switch (opcionMenu) {
                case 1:
                        entradaTecladoINT.nextLine();
                        boolean procesoClienteAprobado; 
                        do {
                            procesoClienteAprobado=agregar.agregarNuevoCliente();
                        } while (procesoClienteAprobado=false);

                    break;
                case 2:
                        entradaTecladoINT.nextLine();
                        boolean procesoCuentaAprobado; 
                        do {
                            procesoCuentaAprobado = agregar.agregarNuevaCuenta();
                        } while (procesoCuentaAprobado=false);
                    break;
                case 3:
                        entradaTecladoINT.nextLine();
                        boolean procesoEliminacionAprobado;
                        do {
                            procesoEliminacionAprobado = eliminar.eliminarCliente();
                        } while (procesoEliminacionAprobado=false);
                    
                    break; 
                case 4:
                        entradaTecladoINT.nextLine();
                        boolean procesoEliminacionCuAprobado;
                        do {
                            procesoEliminacionCuAprobado = eliminar.eliminarCuenta();
                        } while (procesoEliminacionCuAprobado=false);
                    
                    break;   
                case 5:
                        entradaTecladoINT.nextLine();
                        boolean procesoModificarAprobado; 
                        do {
                            procesoModificarAprobado = modificar.modificarNombreCliente();
                        } while (procesoModificarAprobado=false);
                    break;
                case 6:
                        mostrar.mostrarClientesCuenta();
                        
                    break;
                case 7:
                        entradaTecladoINT.nextLine();
                        boolean procesoSaldoAprobado; 
                        do {
                            procesoSaldoAprobado = modificar.agregarSaldo();
                        } while (procesoSaldoAprobado=false);
                    
                    break;
                    
                default:
                        
                        System.out.println("¿Seguro que quiere terminar la operacion?");
                        System.out.println("1.-SI(S)");
                        System.out.println("2.-NO(N)");
                        String desicion = entradaTecladoCadena.nextLine();
                        if(desicion.equals("S")){
                            opcionMenu = 8;
                        }else{
                            opcionMenu=9;
                        }
                    break;
            }
            
        
        } while (opcionMenu!=8);
        
        System.out.println("Gracias por usar nuestro servicio");
        System.out.println("-----------!BUEN DIA¡-----------");
    }

}