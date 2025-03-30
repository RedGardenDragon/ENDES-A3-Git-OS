

    import java.util.Scanner;

class Hora {
    private int hora;
    private int minuto;
    private int segundo;

    public Hora(int hora, int minuto, int segundo) {
        setHora(hora);
        setMinuto(minuto);
        setSegundo(segundo);
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        if (hora >= 0 && hora < 24) {
            this.hora = hora;
        } else {
            this.hora = 0;
        }
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        if (minuto >= 0 && minuto < 60) {
            this.minuto = minuto;
        } else {
            this.minuto = 0;
        }
    }

    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) {
        if (segundo >= 0 && segundo < 60) {
            this.segundo = segundo;
        } else {
            this.segundo = 0;
        }
    }

    public void avanzarSegundo() {
        segundo++;
        if (segundo == 60) {
            segundo = 0;
            minuto++;
            if (minuto == 60) {
                minuto = 0;
                hora++;
                if (hora == 24) {
                    hora = 0;
                }
            }
        }
    }

    public void mostrarHora() {
        System.out.printf("%02d:%02d:%02d\n", hora, minuto, segundo);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la hora (0-23): ");
        int h = scanner.nextInt();
        System.out.print("Ingrese los minutos (0-59): ");
        int m = scanner.nextInt();
        System.out.print("Ingrese los segundos (0-59): ");
        int s = scanner.nextInt();
        System.out.print("Ingrese la cantidad de segundos a mostrar: ");
        int n = scanner.nextInt();

        Hora hora = new Hora(h, m, s);
        System.out.println("Hora inicial:");
        hora.mostrarHora();

        for (int i = 0; i < n; i++) {
            hora.avanzarSegundo();
            hora.mostrarHora();
        }
        scanner.close();
    }
}


