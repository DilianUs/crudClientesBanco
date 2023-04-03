package FormatoValidaciones;
import Modelo.Cliente;
import Modelo.Cuenta;

public class Validaciones {
    private final int TAMANO_NUM=16;
    public boolean validarClienteNuevo(Cliente cliente){
        if(validarNumCliente(cliente)==true){
            if(validarNombreCliente(cliente)==true){
                System.out.println("Datos del nuevo cliente validados");
               return true;
            }else{
                return false;
            }
        }else{

            return false;
        }
    }

    public boolean validaCuentaNueva(Cuenta cuenta){
        if(validarNumCuenta(cuenta)==true){
            if(validarSaldo(cuenta)){
                System.out.println("Datos de nueva cuenta validados");
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }

    }

    private boolean validarNumCliente(Cliente cliente){
        String NumeroDeCliente = String.valueOf(cliente.getNumeroCliente()) ;
        if(NumeroDeCliente.isEmpty()){
            System.out.println("El campo 'Numero de cliente' está vacio");
            return false;
        }else{
            if(NumeroDeCliente.matches("^-?[0-9]+$")){
                if(NumeroDeCliente.length()!=TAMANO_NUM){
                    System.out.println("El numero de cliente debe se tener 16 digitos");
                    return false;
                }else{
                    return true;
                }
            }else{
                System.out.println("El numero de cuenta debe ser un numero");
                return false;
            }

        } 
    }

    private boolean validarNombreCliente(Cliente cliente){
        String NombreDeCliente = cliente.getNombreCliente();
        if(NombreDeCliente.isEmpty()){
            System.out.println("El campo 'Nombre de cliente' está vacio");
            return false;
        }else{
            if(NombreDeCliente.matches("^([A-Z]{1}[a-z]+[ ]?){1,4}$")){
                return true;
            }else{
                System.out.println("El nombre de cliente no debe tener numeros");
                return false;
            }

        } 

    }

    private boolean validarNumCuenta(Cuenta cuenta){
        String NumeroDeCuenta = String.valueOf(cuenta.getNumeroCuenta());
        if(NumeroDeCuenta.isEmpty()){
            System.out.println("El campo 'Numero de cuenta' está vacio");
            return false;
        }else{
            if(NumeroDeCuenta.matches("^-?[0-9]+$")){
                if(NumeroDeCuenta.length()!=TAMANO_NUM){
                    System.out.println("El numero de cuenta debe se tener 16 digitos");
                    return false;
                }else{
                    return true;
                }
            }else{
                System.out.println("El numero de cuenta debe ser un numero");
                return false;
            }

        } 
    }

    private boolean validarSaldo(Cuenta cuenta){
        
        try {
            double saldoCliente=0;
            saldoCliente = cuenta.getSaldo() ;
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }
}
