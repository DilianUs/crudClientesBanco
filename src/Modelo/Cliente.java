package Modelo;


import java.util.ArrayList;

public class Cliente {
    private Long NumeroCliente;
    private String NombreCliente;
    private ArrayList<Cuenta> cuentas;

    public Cliente() {
    }

    public Long getNumeroCliente() {
        return NumeroCliente;
    }

    public void setNumeroCliente(Long NumeroCliente) {
        this.NumeroCliente = NumeroCliente;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String NombreCliente) {
        this.NombreCliente = NombreCliente;
    }

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(ArrayList<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    @Override
    public String toString() {
        return  "NumeroCliente=" + NumeroCliente + ", NombreCliente=" + NombreCliente + ", cuentas=" + cuentas + "\n" ;
    }


}
