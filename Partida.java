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
 * CONTRUCTORA INCIAL: Define la capacidad de la pila de Deshacer, inicializa el tablero y sede el turno a blancas
 */
	public Partida(){
		this.undoStack = new int[10];
		this.terminada = false;
		this.tablero = new Tablero(8,8);
		this.tablero.iniciarTableroVacio(Ficha.VACIA);
		this.turno = Ficha.BLANCA;
	}
/**
 * COLOCAR UNA FICHA EN COLUMNA CORRESPONDIENTE
 * DEFINE EL TURNO EN EL TABLERO
 * COMPRUEBA SI LA PARTIDA SIGUE O FINALIZA
 * 
 * @param color tipo ficha(enum)
 * @param col tipo int: columna de colocaci�n de ficha
 * @return si todo es correcto y v�lido
 */
	public boolean ejecutaMovimiento(Ficha color, int col){
		boolean OK = true;
		this.terminada = false;
		if(col <= this.tablero.getAlto()){
			this.tablero.insertaFicha(color, col, this.turno);
		}
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
	
/**
 * RETRONA LA FICHA(TURNO) QUE ESTA ACTIVO PARA EJECUTAR MOVIMIENTO
 * @return
 */
	public Ficha getTurno(){
		return this.turno;
	}
	
/**
 * PINTAMOS LA TABLA
 */
	public String toString(){
		return this.tablero.toString();
	}
/**
 * PINTAMOS LA CABECERA DE ENTRADA	
 * @return caracteres para la cabecera
 */
	public String cabecera(){
		String interfaz="";
		interfaz = "Juega ";
		
		if(this.turno == turno.BLANCA)
			interfaz = interfaz + "Blancas";
		else if(this.turno == turno.NEGRA)
			interfaz = interfaz + "Negras";
		
		interfaz = interfaz + System.getProperty("line.separator");
		interfaz = interfaz + "Qué deseas hacer? ";
		return interfaz;
	}
}
