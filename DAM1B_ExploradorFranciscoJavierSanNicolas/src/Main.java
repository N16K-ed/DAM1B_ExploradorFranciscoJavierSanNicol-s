import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final int ARRIBA = 1;
    private static final int ABAJO = 2;
    private static final int DERECHA = 3;
    private static final int IZQUIERDA = 4;
    private static Explorador jugador;

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("*******************************************************");
        System.out.println("Bienvenido al juego del explorador");
        System.out.println("*******************************************************");

        // Crea al explorador
        System.out.println("Introduzca su nombre:");
        String nombre = teclado.nextLine();
        jugador = new Explorador(nombre);

        Mapa mapajuego = new Mapa();
        do {
            mapajuego.Mostrar();

            System.out.println("\n W=Arriba    A=Izquierda    S=Abajo   D=Derecha\n");
            System.out.println("¿Qué acción quieres realizar? ");
            String opcion = teclado.nextLine();
            while (!(opcion.equalsIgnoreCase("W") || opcion.equalsIgnoreCase("A") || opcion.equalsIgnoreCase("S") || opcion.equalsIgnoreCase("D"))) {
                System.out.println("Introduzca una opción válida");
                opcion = teclado.nextLine();
            }
            opcion = opcion.toUpperCase();
            int opcionDireccion;
            if (opcion.equals("W")){
                opcionDireccion = ARRIBA;
            } else if (opcion.equals("A")){
                opcionDireccion = IZQUIERDA;
            } else if (opcion.equals("S")){
                opcionDireccion = ABAJO;
            }else {
                opcionDireccion = DERECHA;
            }
            jugador.Moverse(opcionDireccion);
        }while (jugador.getPosicionActual() != mapajuego.getPosTesoro());
        System.out.println("Has ganado");


    }
    public static Explorador getJugador(){
        return jugador;
    }
}