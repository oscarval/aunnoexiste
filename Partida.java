package tp.pr1;

public class Partida {
//	ATRIBUTOS
	private Tablero tablero;
	private Ficha turno;
	private boolean terminada;
	private Ficha ganador;
	private int[] undoStack;
	private int numUndo;
/**
 * CONTRUCTORA INCIAL: Define la capacidad de la pila de Deshacer
 */
	public Partida(){
		this.undoStack = new int[10];
		this.terminada = false;
	}
/**
 * COLOCAR UNA FICHA EN COLUMNA CORRESPONDIENTE
 * DEFINE EL TURNO EN EL TABLERO
 * COMPRUEBA SI LA PARTIDA SIGUE O FINALIZA
 * 
 * @param color tipo ficha(enum)
 * @param col tipo int: columna de colocación de ficha
 * @return si todo es correcto y válido
 */
	public boolean ejecutaMovimiento(Ficha color, int col){
		boolean OK = true;
		
		this.terminada = true;
		return OK;
	}
/**
 * CONSULTAMOS SI LA PARTIDA HA TERMINADO
 * 	
 * @return valor booleano terminada
 */
	public boolean esTerminada(){
		return this.terminada;
	}
}
