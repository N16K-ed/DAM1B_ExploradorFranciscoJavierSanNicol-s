import java.util.Scanner;
public class Mapa {
    private char[][] tablero;;
    private Posicion posTesoro;
    private Posicion posJugador;
    private Enemigo[] listadoEnemigos;
    private Posicion[] posicionTrampas;

    public Mapa(){
        //Scanner teclado
        Scanner teclado = new Scanner(System.in);

        // Crea al explorador
        System.out.println("Introduzca su nombre:");
        String nombre = teclado.nextLine();
        Explorador jugador = new Explorador(nombre);
        this.posJugador = jugador.getPosicionActual();

        //inicializa tablero
        this.tablero = new char[6][20];
        for (int filas = 0; filas < tablero.length; filas++){
            for (int columnas = 0; columnas < tablero[filas].length; columnas++){
                tablero[filas][columnas] = ' ';
            }
        }
        //inicializar los enemigos
        this.listadoEnemigos = new Enemigo[3];
        for (int i = 0; i < listadoEnemigos.length; i++ ){
            do {
                this.listadoEnemigos[i] = new Enemigo(new Posicion((int) (Math.random() * 6), (int) (Math.random() * 20)));
            }while (this.listadoEnemigos[i].getPosicionActual() == posJugador ); //do while para que no aparezca en la posición en la que aparece el explorador
        }
        //inicializar las trampas
        this.posicionTrampas = new Posicion[3];
        for (int i = 0; i < posicionTrampas.length; i++ ){
            do {
                posicionTrampas[i] = new Posicion((int) (Math.random() * 6), (int) (Math.random() * 19 + 1));
            }while(posicionTrampas[i] == posJugador || posicionTrampas[i] == this.listadoEnemigos[0].getPosicionActual() || posicionTrampas[i] == this.listadoEnemigos[1].getPosicionActual() || posicionTrampas[i] == this.listadoEnemigos[2].getPosicionActual());
        } // la condicion del do while evita que se posicionen trampas donde los enemigos y jugador
        //inicializa tesoro
        do {
            this.posTesoro = new Posicion((int) (Math.random() * 6), (int) (Math.random() * 20));
        }while (this.posTesoro == posJugador || this.posTesoro == posicionTrampas[0] || this.posTesoro == posicionTrampas[1] || this.posTesoro == posicionTrampas[2] || posTesoro == this.listadoEnemigos[0].getPosicionActual() || this.posTesoro == this.listadoEnemigos[1].getPosicionActual() || this.posTesoro == this.listadoEnemigos[2].getPosicionActual());
    }

    public char[][] getTablero(){
        return tablero;
    }

    public Posicion getPosTesoro(){
        return posTesoro;
    }

    public void Mostrar(){
        for (int filas = 0; filas < tablero.length; filas++){
            System.out.println("---------------------------------------------------------------------------------");
            System.out.print("| ");
            int numeroTrampas;
            int numeroEnemigos;
            for (int columnas = 0; columnas < tablero[filas].length; columnas++){
                if (filas == posJugador.getCoordenadaFila() && columnas == posJugador.getCoordenadaCol()){ //para los colores de los carácteres
                    System.out.print("\u001B[32m" + "J" + "\u001B[0m" + " | " ); //accede al código ANSI para el color verde (32) y predeterminado (0)
                }else if ((filas == listadoEnemigos[0].getPosicionActual().getCoordenadaFila() && columnas == listadoEnemigos[0].getPosicionActual().getCoordenadaCol()) ||
                          (filas == listadoEnemigos[1].getPosicionActual().getCoordenadaFila() && columnas == listadoEnemigos[1].getPosicionActual().getCoordenadaCol()) ||
                          (filas == listadoEnemigos[2].getPosicionActual().getCoordenadaFila() && columnas == listadoEnemigos[2].getPosicionActual().getCoordenadaCol())){
                    System.out.print("\u001B[31m" + "E" + "\u001B[0m" + " | " ); // 31 es el valor del rojo
                }else if ((filas == posicionTrampas[0].getCoordenadaFila() && columnas == posicionTrampas[0].getCoordenadaCol()) ||
                          (filas == posicionTrampas[1].getCoordenadaFila() && columnas == posicionTrampas[1].getCoordenadaCol()) ||
                          (filas == posicionTrampas[2].getCoordenadaFila() && columnas == posicionTrampas[2].getCoordenadaCol())){
                    System.out.print("\u001B[31m" + "T" + "\u001B[0m" +" | " );
                }else{
                    System.out.print(tablero[filas][columnas] + " | ");
                }
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------------------------------------------");
    }
}
