public class Enemigo {
    private final int ARRIBA = 1; //direccion
    private final int ABAJO = 2; //direccion
    private final int DERECHA = 3; //direccion
    private final int IZQUIERDA = 4; //direccion

    private Posicion posicionActual;

    public Enemigo(Posicion Posicion){
        this.posicionActual = Posicion;
    }

    public void moverse(int direccion){
            if (direccion == ARRIBA){ //Para que no se salga del mapa
                if (this.posicionActual.getCoordenadaFila() != 0){
                    this.posicionActual.setCoordenadaFila(this.posicionActual.getCoordenadaFila() - 1);
                }
            }else if (direccion == ABAJO){
                if (this.posicionActual.getCoordenadaFila() != 5){
                    this.posicionActual.setCoordenadaFila(this.posicionActual.getCoordenadaFila() + 1);
                }
            }else if (direccion == DERECHA){
                if (this.posicionActual.getCoordenadaCol() != 0){
                    this.posicionActual.setCoordenadaCol(this.posicionActual.getCoordenadaCol() - 1);
                }
            }else {
                if (this.posicionActual.getCoordenadaCol() != 19){
                    this.posicionActual.setCoordenadaCol(this.posicionActual.getCoordenadaCol() + 1);
                }
            }
    }

    public void setPosicionActual(Posicion posicionActual){
        this.posicionActual = posicionActual;
    }

    public Posicion getPosicionActual(){
        return posicionActual;
    }
}
