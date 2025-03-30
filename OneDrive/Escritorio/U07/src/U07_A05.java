
public class U07_A05 {
    class Gestor {
    public String nombre;
    private final String telefono;
    protected double importeMaximo;

    public Gestor(String nombre, String telefono) {
        this(nombre, telefono, 10000);
    }

    public Gestor(String nombre, String telefono, double importeMaximo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.importeMaximo = importeMaximo;
    }

    public String getTelefono() {
        return telefono;
    }
}

public class CuentaCorriente {
    protected String dni;
    public String nombreTitular;
    private double saldo;
    private static String nombreBanco = "Banco Central";
    private Gestor gestor;

    public CuentaCorriente(String dni, double saldoInicial) {
        this(dni, "Desconocido", saldoInicial, null);
    }

    public CuentaCorriente(String dni, String nombreTitular) {
        this(dni, nombreTitular, 0.0, null);
    }

    public CuentaCorriente(String dni, String nombreTitular, double saldoInicial) {
        this(dni, nombreTitular, saldoInicial, null);
    }

    public CuentaCorriente(String dni, String nombreTitular, double saldoInicial, Gestor gestor) {
        this.dni = dni;
        this.nombreTitular = nombreTitular;
        this.saldo = saldoInicial;
        this.gestor = gestor;
    }

    public static String getNombreBanco() {
        return nombreBanco;
    }

    public static void setNombreBanco(String nuevoNombreBanco) {
        nombreBanco = nuevoNombreBanco;
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
        System.out.println("Banco: " + nombreBanco);
        if (gestor != null) {
            System.out.println("Gestor: " + gestor.nombre);
            System.out.println("Teléfono del gestor: " + gestor.getTelefono());
        } else {
            System.out.println("No tiene gestor asignado.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Gestor gestor1 = new Gestor("Carlos Rodríguez", "123456789");
        CuentaCorriente cuenta1 = new CuentaCorriente("12345678A", "Juan Pérez", 500.0, gestor1);
        cuenta1.mostrarInformacion();

        Gestor gestor2 = new Gestor("Ana Gómez", "987654321", 15000);
        CuentaCorriente cuenta2 = new CuentaCorriente("87654321B", "María López", 300.0, gestor2);
        cuenta2.mostrarInformacion();

        CuentaCorriente cuenta3 = new CuentaCorriente("11223344C", "Ana López", 500.0);
        cuenta3.mostrarInformacion();

        System.out.println("Banco actual: " + CuentaCorriente.getNombreBanco());
        CuentaCorriente.setNombreBanco("Banco Internacional");
        System.out.println("Nuevo nombre del banco: " + CuentaCorriente.getNombreBanco());
    }
}

}
