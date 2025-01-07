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
        //Crea el mapa
        Mapa mapajuego = new Mapa();

        //muestra el mapa tras cada turno hasta llegar al tesoro o mueras debido a trampas o enemigos
        do {
            mapajuego.Mostrar();

            //Wallhack para ganar facil, eliminar al entregar
            System.out.println(mapajuego.getPosTesoro().getCoordenadaFila());
            System.out.println(mapajuego.getPosTesoro().getCoordenadaCol());
            System.out.println(jugador.getPosicionActual().getCoordenadaFila());
            System.out.println(jugador.getPosicionActual().getCoordenadaCol());
            //Fin del wallhack


            System.out.println("\nW=Arriba    A=Izquierda    S=Abajo   D=Derecha\n");
            System.out.println("¿Qué acción quieres realizar? ");
            String opcion = teclado.nextLine();
            //Opciones case sensitive
            while (!(opcion.equalsIgnoreCase("W") || opcion.equalsIgnoreCase("A") || opcion.equalsIgnoreCase("S") || opcion.equalsIgnoreCase("D"))) {
                System.out.println("Introduzca una opción válida");
                opcion = teclado.nextLine();
            }
            //para evitar problemas
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
            //el explorador se mueve segun le indiquemos
            jugador.moverse(opcionDireccion);
            mapajuego.moverTodosEnemigos();

        }while (jugador.getPosicionActual().getCoordenadaCol() != mapajuego.getPosTesoro().getCoordenadaCol()
                || jugador.getPosicionActual().getCoordenadaFila() != mapajuego.getPosTesoro().getCoordenadaFila()

                                                                                                                    );
        //El bucle se hace una vez y luego se repite hasta que ninguna de las cordenadas del explorador sean distintas a la del tesoro.


        System.out.println("\nHas ganado");
    }
    public static Explorador getJugador(){
        return jugador;
    }
}