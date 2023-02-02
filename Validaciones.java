

public class Validaciones {
    private final int TAMANO_NUM=16;
    public boolean validarClienteNuevo(Cliente cliente){
        if(validarNumCliente(cliente)==true){
            if(validarNombreCliente(cliente)==true){
                if(validarNumCuenta(cliente)==true){
                    if(validarSaldo(cliente)==true){
                        System.out.println("Datos el nuevo cliente validados");
                        return true;
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }else{

            return false;
        }
    }

    public boolean validarNumCliente(Cliente cliente){
        String NumeroDeCliente = cliente.getNumeroCliente();
        if(NumeroDeCliente.isEmpty()){
            System.out.println("El campo 'Numero de cliente' está vacio");
            return false;
        }else{
            if(NumeroDeCliente.matches("^-?[0-9]+$")){
                if(cliente.getNumeroCliente().length()!=TAMANO_NUM){
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

    public boolean validarNombreCliente(Cliente cliente){
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

    public boolean validarNumCuenta(Cliente cliente){
        String NumeroDeCuenta = cliente.getNumeroCuenta();
        if(NumeroDeCuenta.isEmpty()){
            System.out.println("El campo 'Numero de cuenta' está vacio");
            return false;
        }else{
            if(NumeroDeCuenta.matches("^-?[0-9]+$")){
                if(cliente.getNumeroCuenta().length()!=TAMANO_NUM){
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

    public boolean validarSaldo(Cliente cliente){
         float saldoCliente;
        try {
           
            saldoCliente = Float.parseFloat(cliente.getSaldoCliente()) ;
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }
}
