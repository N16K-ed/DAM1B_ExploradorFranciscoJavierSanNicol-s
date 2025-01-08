public class EnemigoInteligente {
    private final int ARRIBA = 1; //direccion
    private final int ABAJO = 2; //direccion
    private final int DERECHA = 3; //direccion
    private final int IZQUIERDA = 4; //direccion
    private int direccionMover;

    private Posicion posicionActual;

    public EnemigoInteligente(Posicion Posicion){
        this.posicionActual = Posicion;
    }

    public void moverse(Mapa mapa){
        Posicion posJugador = Main.getJugador().getPosicionActual();
        int difX = posJugador.getCoordenadaCol() - this.posicionActual.getCoordenadaCol();
        int difY = posJugador.getCoordenadaFila() - this.posicionActual.getCoordenadaFila();
        int difXabs = Math.abs(difX);
        int difYabs = Math.abs(difY);//uso abs() para poder comparar las diferencias para decidir la dirección del movimiento. Guardo las originales para saber el sentido del movimiento (si izd o der, arriba o abajo)

        if (difXabs > difYabs){ //decide mover en la dif más grande. En este caso las columnas
            if (difX > 0){ //mover derecha
                if (this.posicionActual.getCoordenadaCol() + 1 != mapa.getListadoEnemigos()[0].getPosicionActual().getCoordenadaCol() || //if evita a los enemigos
                        this.posicionActual.getCoordenadaCol() + 1 != mapa.getListadoEnemigos()[1].getPosicionActual().getCoordenadaCol() ||
                        this.posicionActual.getCoordenadaCol() + 1 != mapa.getListadoEnemigos()[2].getPosicionActual().getCoordenadaCol()){
                    if (this.posicionActual.getCoordenadaCol() + 1 != mapa.getPosicionTrampas()[0].getCoordenadaCol()|| //if evita a las trampas
                            this.posicionActual.getCoordenadaCol() + 1 != mapa.getPosicionTrampas()[1].getCoordenadaCol()  ||
                            this.posicionActual.getCoordenadaCol() + 1 != mapa.getPosicionTrampas()[2].getCoordenadaCol()) {
                        if (this.posicionActual.getCoordenadaCol() != 19) {//confines del mapa
                            this.posicionActual.setCoordenadaCol(this.posicionActual.getCoordenadaCol() + 1);
                        }
                    }
                }
            } else{ //mover izda
                if (this.posicionActual.getCoordenadaCol() - 1 != mapa.getListadoEnemigos()[0].getPosicionActual().getCoordenadaCol() || //if evita a los enemigos
                        this.posicionActual.getCoordenadaCol() - 1 != mapa.getListadoEnemigos()[1].getPosicionActual().getCoordenadaCol() ||
                        this.posicionActual.getCoordenadaCol() - 1 != mapa.getListadoEnemigos()[2].getPosicionActual().getCoordenadaCol()){
                    if (this.posicionActual.getCoordenadaCol() - 1 != mapa.getPosicionTrampas()[0].getCoordenadaCol()|| //if evita a las trampas
                            this.posicionActual.getCoordenadaCol() - 1 != mapa.getPosicionTrampas()[1].getCoordenadaCol()  ||
                            this.posicionActual.getCoordenadaCol() - 1 != mapa.getPosicionTrampas()[2].getCoordenadaCol()) {
                        if (this.posicionActual.getCoordenadaCol() != 0) {//confines del mapa
                            this.posicionActual.setCoordenadaCol(this.posicionActual.getCoordenadaCol() - 1);
                        }
                    }
                }
            }
        }else if (difXabs < difYabs) {//se mueve en filas
            if (difY > 0){ //mover abajo
                if (this.posicionActual.getCoordenadaFila() + 1 != mapa.getListadoEnemigos()[0].getPosicionActual().getCoordenadaFila() || //if evita a los enemigos
                        this.posicionActual.getCoordenadaFila() + 1 != mapa.getListadoEnemigos()[1].getPosicionActual().getCoordenadaFila() ||
                        this.posicionActual.getCoordenadaFila() + 1 != mapa.getListadoEnemigos()[2].getPosicionActual().getCoordenadaFila()){
                    if (this.posicionActual.getCoordenadaFila() + 1 != mapa.getPosicionTrampas()[0].getCoordenadaFila()|| //if evita a las trampas
                            this.posicionActual.getCoordenadaFila() + 1 != mapa.getPosicionTrampas()[1].getCoordenadaFila()  ||
                            this.posicionActual.getCoordenadaFila() + 1 != mapa.getPosicionTrampas()[2].getCoordenadaFila()) {
                        if (this.posicionActual.getCoordenadaFila() != 5) {//confines del mapa
                            this.posicionActual.setCoordenadaFila(this.posicionActual.getCoordenadaFila() + 1);
                        }
                    }
                }
            } else{ //mover arriba
                if (this.posicionActual.getCoordenadaFila() - 1 != mapa.getListadoEnemigos()[0].getPosicionActual().getCoordenadaFila() || //if evita a los enemigos
                        this.posicionActual.getCoordenadaFila() - 1 != mapa.getListadoEnemigos()[1].getPosicionActual().getCoordenadaFila() ||
                        this.posicionActual.getCoordenadaFila() - 1 != mapa.getListadoEnemigos()[2].getPosicionActual().getCoordenadaFila()){
                    if (this.posicionActual.getCoordenadaFila() - 1 != mapa.getPosicionTrampas()[0].getCoordenadaFila()|| //if evita a las trampas
                            this.posicionActual.getCoordenadaFila() - 1 != mapa.getPosicionTrampas()[1].getCoordenadaFila()  ||
                            this.posicionActual.getCoordenadaFila() - 1 != mapa.getPosicionTrampas()[2].getCoordenadaFila()) {
                        if (this.posicionActual.getCoordenadaFila() != 0) {//confines del mapa
                                this.posicionActual.setCoordenadaFila(this.posicionActual.getCoordenadaFila() - 1);
                        }
                    }
                }
            }
        }else{ //si las diferencias son las mismas en valor absoluto, se mueve por defecto en columnas ya que hay mas y es más común que se utilicen
            if (difX > 0){ //mover derecha
                if (this.posicionActual.getCoordenadaCol() != 19){//confines del mapa
                    this.posicionActual.setCoordenadaCol(this.posicionActual.getCoordenadaCol() + 1);
                }
            } else{ //mover izda
                if (this.posicionActual.getCoordenadaCol() != 0){//confines del mapa
                    this.posicionActual.setCoordenadaCol(this.posicionActual.getCoordenadaCol() - 1);
                }
            }
        }
    }

    public void setPosicionActual(Posicion posicionActual){
        this.posicionActual = posicionActual;
    }

    public Posicion getPosicionActual(){
        return posicionActual;
    }

    public int getDireccionMover() {
        return direccionMover;
    }
}
