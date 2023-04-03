package Modelo;



public class Cuenta {
    private Long NumeroCliente;
    private Long NumeroCuenta;
    private double Saldo;

    public Cuenta() {  
    }

    public Long getNumeroCliente() {
        return NumeroCliente;
    }

    public void setNumeroCliente(Long NumeroCliente) {
        this.NumeroCliente = NumeroCliente;
    }

    public Long getNumeroCuenta() {
        return NumeroCuenta;
    }

    public void setNumeroCuenta(Long NumeroCuenta) {
        this.NumeroCuenta = NumeroCuenta;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double Saldo) {
        this.Saldo = Saldo;
    }

    @Override
    public String toString() {
        return  " NumeroCuenta=" + NumeroCuenta + ", Saldo=" + Saldo ;
    }
}
