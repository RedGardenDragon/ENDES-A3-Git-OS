
public class U07_A01 {
    
    class CuentaCorriente {
    private String dni;
    private String nombreTitular;
    private double saldo;

    public CuentaCorriente(String dni, String nombreTitular) {
        this.dni = dni;
        this.nombreTitular = nombreTitular;
        this.saldo = 0.0;
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
        CuentaCorriente cuenta = new CuentaCorriente("12345678A", "Juan Pérez");
        cuenta.mostrarInformacion();
        cuenta.ingresarDinero(500);
        cuenta.mostrarInformacion();
        cuenta.sacarDinero(200);
        cuenta.mostrarInformacion();
        cuenta.sacarDinero(400);
    }
}

    
}
