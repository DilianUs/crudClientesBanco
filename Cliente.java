public class Cliente {
    private String NumeroCliente;
    private String NombreCliente;
    private String NumeroCuenta;
    private String SaldoCliente;

    public Cliente() {
    }


    public String getNumeroCliente() {
        return NumeroCliente;
    }

    public void setNumeroCliente(String NumeroCliente) {
        this.NumeroCliente = NumeroCliente;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String NombreCliente) {
        this.NombreCliente = NombreCliente;
    }

    public String getNumeroCuenta() {
        return NumeroCuenta;
    }

    public void setNumeroCuenta(String NumeroCuenta) {
        this.NumeroCuenta = NumeroCuenta;
    }

    public String getSaldoCliente() {
        return SaldoCliente;
    }

    public void setSaldoCliente(String SaldoCliente) {
        this.SaldoCliente = SaldoCliente;
    }

    @Override
    public String toString() {
        return   NumeroCliente + "," + NombreCliente + "," + NumeroCuenta + "," + SaldoCliente ;
    }
}
