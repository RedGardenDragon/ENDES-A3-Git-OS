
public class U07_A02 {
    class CuentaCorriente {
    private String dni;
    private String nombreTitular;
    private double saldo;

    public CuentaCorriente(String dni, double saldoInicial) {
        this(dni, "Desconocido", saldoInicial);
    }

    public CuentaCorriente(String dni, String nombreTitular) {
        this(dni, nombreTitular, 0.0);
    }

    public CuentaCorriente(String dni, String nombreTitular, double saldoInicial) {
        this.dni = dni;
        this.nombreTitular = nombreTitular;
        this.saldo = saldoInicial;
    }

    public boolean sacarDinero(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            return true;
        } else {
            System.out.println("Saldo insuficiente o cantidad inválida.");
            return false;
        }
    }

    public void ingresarDinero(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
        } else {
            System.out.println("Cantidad inválida.");
        }
    }

    public void mostrarInformacion() {
        System.out.println("DNI: " + dni);
        System.out.println("Titular: " + nombreTitular);
        System.out.println("Saldo: " + saldo + "€");
    }
}

public class Main {
    public static void main(String[] args) {
        CuentaCorriente cuenta1 = new CuentaCorriente("12345678A", "Juan Pérez");
        cuenta1.mostrarInformacion();

        CuentaCorriente cuenta2 = new CuentaCorriente("87654321B", 300.0);
        cuenta2.mostrarInformacion();

        CuentaCorriente cuenta3 = new CuentaCorriente("11223344C", "Ana López", 500.0);
        cuenta3.mostrarInformacion();
    }
}
    
}
