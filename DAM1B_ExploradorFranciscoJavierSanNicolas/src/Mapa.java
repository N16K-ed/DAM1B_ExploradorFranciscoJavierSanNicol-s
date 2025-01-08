public class Mapa {
    private final int ARRIBA = 1; //direccion
    private final int ABAJO = 2; //direccion
    private final int DERECHA = 3; //direccion
    private final int IZQUIERDA = 4; //direccion

    private char[][] tablero;;
    private Posicion posTesoro;
    private Posicion posJugador;
    private Enemigo[] listadoEnemigos;
    private Posicion[] posicionTrampas;
    private EnemigoInteligente jefe;

    public Mapa(){
        this.posJugador = Main.getJugador().getPosicionActual();
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
                posicionTrampas[i] = new Posicion((int) (Math.random() * 6), (int) (Math.random() * 20));
            }while(posicionTrampas[i] == posJugador || posicionTrampas[i] == this.listadoEnemigos[0].getPosicionActual() || posicionTrampas[i] == this.listadoEnemigos[1].getPosicionActual() || posicionTrampas[i] == this.listadoEnemigos[2].getPosicionActual());
        } // la condicion del do while evita que se posicionen trampas donde los enemigos y jugador
        //inicializa tesoro
        do {
            this.posTesoro = new Posicion((int) (Math.random() * 6), (int) (Math.random() * 20));
        }while (this.posTesoro == posJugador || this.posTesoro == posicionTrampas[0] || this.posTesoro == posicionTrampas[1] || this.posTesoro == posicionTrampas[2] || posTesoro == this.listadoEnemigos[0].getPosicionActual() || this.posTesoro == this.listadoEnemigos[1].getPosicionActual() || this.posTesoro == this.listadoEnemigos[2].getPosicionActual());
        //inicializa enemigo inteligente
        do {
            this.jefe = new EnemigoInteligente(new Posicion((int) (Math.random() * 6), (int) (Math.random() * 20)));
        }while (this.jefe.getPosicionActual() == posJugador || this.jefe.getPosicionActual()== posicionTrampas[0] || this.jefe.getPosicionActual() == posicionTrampas[1] || this.jefe.getPosicionActual() == posicionTrampas[2] || this.jefe.getPosicionActual() == this.listadoEnemigos[0].getPosicionActual() || this.jefe.getPosicionActual() == this.listadoEnemigos[1].getPosicionActual() || this.jefe.getPosicionActual() == this.listadoEnemigos[2].getPosicionActual() || this.jefe.getPosicionActual() == this.posTesoro);
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
                }else if ((filas == jefe.getPosicionActual().getCoordenadaFila() && columnas == jefe.getPosicionActual().getCoordenadaCol())){
                    System.out.print("\u001B[31m" + "*" + "\u001B[0m" + " | ");
                }else{
                    System.out.print(tablero[filas][columnas] + " | ");
                }
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------------------------------------------");
    }

    public void moverTodosEnemigos(){
        for (int i = 0; i < listadoEnemigos.length; i++){
            int numAleatorio = (int)(Math.random()*4+1); //Direccion aleatoria
            if (numAleatorio == ARRIBA){
                if (listadoEnemigos[i].getPosicionActual().getCoordenadaFila() - 1 != listadoEnemigos[0].getPosicionActual().getCoordenadaFila() || //if evita a los enemigos
                        listadoEnemigos[i].getPosicionActual().getCoordenadaFila() - 1 != listadoEnemigos[1].getPosicionActual().getCoordenadaFila() ||
                        listadoEnemigos[i].getPosicionActual().getCoordenadaFila() - 1 != listadoEnemigos[2].getPosicionActual().getCoordenadaFila()){
                    if (listadoEnemigos[i].getPosicionActual().getCoordenadaFila() - 1 !=  posicionTrampas[0].getCoordenadaFila()|| //if evita a las trampas
                            listadoEnemigos[i].getPosicionActual().getCoordenadaFila() - 1 != posicionTrampas[1].getCoordenadaFila()  ||
                            listadoEnemigos[i].getPosicionActual().getCoordenadaFila() - 1 != posicionTrampas[2].getCoordenadaFila()) {
                        if (listadoEnemigos[i].getPosicionActual().getCoordenadaFila() - 1 != jefe.getPosicionActual().getCoordenadaFila()){ //if evita al enemigo inteligente
                                listadoEnemigos[i].moverse(ARRIBA);
                        }
                    }
                }
            }else if (numAleatorio == ABAJO){
                if (listadoEnemigos[i].getPosicionActual().getCoordenadaFila() + 1 != listadoEnemigos[0].getPosicionActual().getCoordenadaFila() || //if evita a los enemigos
                        listadoEnemigos[i].getPosicionActual().getCoordenadaFila() + 1 != listadoEnemigos[1].getPosicionActual().getCoordenadaFila() ||
                        listadoEnemigos[i].getPosicionActual().getCoordenadaFila() + 1 != listadoEnemigos[2].getPosicionActual().getCoordenadaFila()){
                    if (listadoEnemigos[i].getPosicionActual().getCoordenadaFila() + 1 !=  posicionTrampas[0].getCoordenadaFila()|| //if evita a las trampas
                            listadoEnemigos[i].getPosicionActual().getCoordenadaFila() + 1 != posicionTrampas[1].getCoordenadaFila()  ||
                            listadoEnemigos[i].getPosicionActual().getCoordenadaFila() + 1 != posicionTrampas[2].getCoordenadaFila()) {
                        if (listadoEnemigos[i].getPosicionActual().getCoordenadaFila() + 1 != jefe.getPosicionActual().getCoordenadaFila()){//if evita al enemigo inteligente
                            listadoEnemigos[i].moverse(ABAJO);
                        }
                    }
                }
            }else if (numAleatorio == IZQUIERDA){
                if (listadoEnemigos[i].getPosicionActual().getCoordenadaCol() - 1 != listadoEnemigos[0].getPosicionActual().getCoordenadaCol() || //if evita a los enemigos
                        listadoEnemigos[i].getPosicionActual().getCoordenadaCol() - 1 != listadoEnemigos[1].getPosicionActual().getCoordenadaCol() ||
                        listadoEnemigos[i].getPosicionActual().getCoordenadaCol() - 1 != listadoEnemigos[2].getPosicionActual().getCoordenadaCol()){
                    if (listadoEnemigos[i].getPosicionActual().getCoordenadaCol() - 1 !=  posicionTrampas[0].getCoordenadaCol()|| //if evita a las trampas
                            listadoEnemigos[i].getPosicionActual().getCoordenadaCol() - 1 != posicionTrampas[1].getCoordenadaCol()  ||
                            listadoEnemigos[i].getPosicionActual().getCoordenadaCol() - 1 != posicionTrampas[2].getCoordenadaCol()) {
                        if (listadoEnemigos[i].getPosicionActual().getCoordenadaCol() - 1 != jefe.getPosicionActual().getCoordenadaCol()){//if evita al enemigo inteligente
                            listadoEnemigos[i].moverse(IZQUIERDA);
                        }
                    }
                }
            }else {
                if (listadoEnemigos[i].getPosicionActual().getCoordenadaCol() + 1 != listadoEnemigos[0].getPosicionActual().getCoordenadaCol() || //if evita a los enemigos
                        listadoEnemigos[i].getPosicionActual().getCoordenadaCol() + 1 != listadoEnemigos[1].getPosicionActual().getCoordenadaCol() ||
                        listadoEnemigos[i].getPosicionActual().getCoordenadaCol() + 1 != listadoEnemigos[2].getPosicionActual().getCoordenadaCol()){
                    if (listadoEnemigos[i].getPosicionActual().getCoordenadaCol() + 1 !=  posicionTrampas[0].getCoordenadaCol()|| //if evita a las trampas
                            listadoEnemigos[i].getPosicionActual().getCoordenadaCol() + 1 != posicionTrampas[1].getCoordenadaCol()  ||
                            listadoEnemigos[i].getPosicionActual().getCoordenadaCol() + 1 != posicionTrampas[2].getCoordenadaCol()) {
                        if (listadoEnemigos[i].getPosicionActual().getCoordenadaCol() + 1 != jefe.getPosicionActual().getCoordenadaCol()){//if evita al enemigo inteligente
                            listadoEnemigos[i].moverse(DERECHA);
                        }
                    }
                }
            }
        }
    }

    public Posicion[] getPosicionTrampas(){
        return posicionTrampas;
    }

    public Enemigo[] getListadoEnemigos() {
        return listadoEnemigos;
    }

    public EnemigoInteligente getJefe() {
        return jefe;
    }
}
