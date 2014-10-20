package tp.pr1;

public class Tablero {
	
	private Ficha[][] tablero;
	private int ancho;
	private int alto;

/**
 * CONSTRUCTORA: INCIAMOS EL TABLERO
 * por defecto alto=0, ancho=0
 */
	public Tablero(){
		this.ancho = 0;
		this.alto = 0;
	}
/**
 * CONSTRUCTORA: INCIAMOS EL TABLERO
 * @param ancho tipo int: del tablero
 * @param alto tipo int: del tablero
 */
	public Tablero(int ancho, int alto){
		this.ancho = ancho;
		this.alto = alto;
	}
	
/**
 * CONSULTA DE ALTO
 * @return  tipo int: alto del tablero
 */
	public int getAlto(){
		return this.alto;
	}
	
/**
 * 	CONSULTA DE ANCHO
 * @return tipo int: ancho del tablero
 */
	public int getAncho(){
		return this.ancho;
	}
	
}
