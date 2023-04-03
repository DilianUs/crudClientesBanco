package ServiciosAplicacion;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DAOImplements.DAOException;
import DAOImplements.DAOManagerImp;
import Modelo.Cliente;
import Modelo.Cuenta;

public class Eliminar {
    public static DAOManagerImp managerDAO = new DAOManagerImp();

    public boolean eliminarCliente(){
        List<Cliente> listaClientes= new ArrayList<>();
        Scanner entrada= new Scanner(System.in);
         boolean eliminacionAprobada;
        try {
            listaClientes= managerDAO.getClienteDAO().obtenerTodos();
        } catch (DAOException e) {
            e.printStackTrace();
        }

            System.out.println("Eliminar un cliente");
        
            System.out.println("-Lista de clientes-\n");
            for(int i=0; i<listaClientes.size(); i++) {
                System.out.println(i+".-"+listaClientes.get(i).getNombreCliente());
            }
            System.out.println("\n Ingrese el numero de lista del cliente que desee eliminar");
            int clienteSeleccionado = entrada.nextInt();
            
            System.out.println("Esta seguro de eliminar al cliente:" + listaClientes.get(clienteSeleccionado).getNombreCliente() +"?");
            entrada.nextLine();
            System.out.println("SI(S) ------ NO(N)");
            String desicionEliminar = entrada.nextLine();
            if(desicionEliminar.equals("S")){
                System.out.println("Se eliminara al cliente seleccionado");
                try {
                    managerDAO.getClienteDAO().eliminar(listaClientes.get(clienteSeleccionado));
                } catch (DAOException e) {
                    e.printStackTrace();
                } 
                System.out.println("Operacion realizada con exito");
                eliminacionAprobada=true;
            }else{
                if(desicionEliminar.equals("N")){
                    System.out.println("Operacion cancelada...\n Regresando al menú principal");
                    eliminacionAprobada=true;
                }else{
                    System.out.println("La opcion está fuera de rango, reresando al menú principal");
                    eliminacionAprobada=true;
                }
            }
            entrada.close();
        return eliminacionAprobada;
    }

    public boolean eliminarCuenta(){
        List<Cliente> listaClientes= new ArrayList<>();
        List<Cuenta> listaCuentas= new ArrayList<>();
        List<Cuenta> listaCuentasCliente= new ArrayList<>();
        Scanner entrada= new Scanner(System.in);
        boolean eliminacionCuAprobada = false;
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
        System.out.println("Cuentas pertenecientes a :" + clienteTitular.getNombreCliente());
        for(int i=0; i<listaCuentas.size(); i++) {
            if(listaCuentas.get(i).getNumeroCliente().equals(clienteTitular.getNumeroCliente())){
                listaCuentasCliente.add(listaCuentas.get(i));  
            }
        }

        for(int i=0; i<listaCuentasCliente.size(); i++) {
            if(listaCuentasCliente.get(i).getNumeroCliente().equals(clienteTitular.getNumeroCliente())){
                System.out.println(i+".-"+listaCuentasCliente.get(i).toString());  
            }
        }

        entrada.nextLine();
        System.out.println("Ingrese el numero de lista que corresponda a la cuenta a eliminar");
        int cuentaSeleccionada = entrada.nextInt();

        System.out.println("Esta seguro de eliminar la cuenta:" + listaCuentasCliente.get(cuentaSeleccionada).getNumeroCuenta() +" del cliente: "+listaClientes.get(titularSeleccionado).getNombreCliente() + "?");
        entrada.nextLine();
        System.out.println("SI(S) ------ NO(N)");
        String desicionEliminar = entrada.nextLine();

        if(desicionEliminar.equals("S")){
            System.out.println("Se eliminara la cuenta seleccionada");
            try {
                managerDAO.getCuentaDAO().eliminar(listaCuentasCliente.get(cuentaSeleccionada));
            } catch (DAOException e) {
                e.printStackTrace();
            } 
            System.out.println("Operacion realizada con exito");
            eliminacionCuAprobada=true;
        }else{
            if(desicionEliminar.equals("N")){
                System.out.println("Operacion cancelada...\n Regresando al menú principal");
                eliminacionCuAprobada=true;
            }else{
                System.out.println("La opcion está fuera de rango, reresando al menú principal");
                eliminacionCuAprobada=true;
            }
        }
        entrada.close();
        return eliminacionCuAprobada;
    }
}
