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
            listadoEnemigos[i] = new Enemigo(new Posicion((int)(Math.random()*6),(int)(Math.random()*19 +1))); //random*19 + 1 para que no aparezca en la columna en la que aparece el explorador
        }
        //inicializar las trampas
        this.posicionTrampas = new Posicion[3];
        for (int i = 0; i < posicionTrampas.length; i++ ){
            posicionTrampas[i] = new Posicion((int)(Math.random()*6),(int)(Math.random()*19 +1));
        }
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
            for (int columnas = 0; columnas < tablero[filas].length; columnas++){
                if (tablero[filas][columnas] == 'J'){ //para los colores de los carácteres
                    System.out.println("\u001B[32m" + tablero[filas][columnas] + "\u001B[0m" + "|" ); //accede al código ANSI para el color verde (32) y predeterminado (0)
                }else if (tablero[filas][columnas] == 'E' || tablero[filas][columnas] == 'T'){
                    System.out.println("\u001B[31m" + tablero[filas][columnas] + "\u001B[0m" + "|" ); // 31 es el valor del rojo
                }else{
                    System.out.print(tablero[filas][columnas] + " | ");
                }
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------------------------------------------");
    }
}
