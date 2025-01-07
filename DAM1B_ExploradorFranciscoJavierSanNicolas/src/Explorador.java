public class Explorador {
    private final int ARRIBA = 1; //direccion
    private final int ABAJO = 2; //direccion
    private final int DERECHA = 3; //direccion
    private final int IZQUIERDA = 4; //direccion

    private String nombre;
    private Posicion posicionActual;


    public Explorador(String nombre){
        this.nombre = nombre;
        this.posicionActual = new Posicion((int)(Math.random()*6), 0);
    }

    public String getNombre(){
        return nombre;
    }

    public Posicion getPosicionActual(){
        return posicionActual;
    }

    public void setPosicionActual(Posicion posicionActual){
        this.posicionActual = posicionActual;
    }

    public void moverse(int direccion){
        if (direccion == ARRIBA){
            if (posicionActual.getCoordenadaFila() > 0){
                this.posicionActual.setCoordenadaFila(posicionActual.getCoordenadaFila() - 1);
            }
        }else if (direccion == ABAJO){
            if (posicionActual.getCoordenadaFila() < 5){
                this.posicionActual.setCoordenadaFila(posicionActual.getCoordenadaFila() + 1);
            }
        }else if (direccion == DERECHA){
            if (posicionActual.getCoordenadaCol() < 19){
                this.posicionActual.setCoordenadaCol(posicionActual.getCoordenadaCol() + 1);
            }
        }else{
            if (posicionActual.getCoordenadaCol() > 0){
                this.posicionActual.setCoordenadaCol(posicionActual.getCoordenadaCol() - 1);
            }
        }
    }
}
