import java.util.Scanner;

public class Main {
    private final int ARRIBA = 1;
    private final int ABAJO = 2;
    private final int DERECHA = 3;
    private final int IZQUIERDA = 4;

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("*******************************************************");
        System.out.println("Bienvenido al juego del explorador");
        System.out.println("*******************************************************");
        Mapa mapajuego = new Mapa();

            mapajuego.Mostrar();

            System.out.println("\n W=Arriba    A=Izquierda    S=Abajo   D=Derecha\n");
            System.out.println("¿Qué acción quieres realizar? ");
            String opcion = teclado.nextLine();
            while (!(opcion.equalsIgnoreCase("W") || opcion.equalsIgnoreCase("A") ||opcion.equalsIgnoreCase("S") ||opcion.equalsIgnoreCase("D")) ){
                System.out.println("Introduzca una opción válida");
                opcion = teclado.nextLine();
            }
            int opcionDireccion;
           // if


    }
}