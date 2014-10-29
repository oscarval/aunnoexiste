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
		this.tablero = new Tablero(4,4);
		this.tablero.iniciarTableroVacio(Ficha.VACIA);
		this.turno = Ficha.BLANCA;
	}
/**
 * COLOCAR UNA FICHA EN COLUMNA CORRESPONDIENTE
 * DEFINE EL TURNO EN EL TABLERO
 * COMPRUEBA SI LA PARTIDA SIGUE O FINALIZA
 * 
 * @param color tipo ficha(enum)
 * @param col tipo int: columna de colocaciï¿½n de ficha
 * @return si todo es correcto y vï¿½lido
 */
	public boolean ejecutaMovimiento(Ficha color, int col){
		boolean OK = true;
		int fila;
		this.terminada = false;
		if(col < this.tablero.getAncho() && col > 0){
			fila = this.getFilaVacia(col);
			if(fila != -1)
				this.tablero.insertaFicha(this.turno,fila, col);
			else
				OK = false;
		}
		else
			OK = false;
		return OK;
	}
/**
 * COMPROBAR LA FILA VACIA EN EL TABLERO CUANDO TENG ALA MISMA COLUMNA	
 * @param col
 * @return
 */
	private int getFilaVacia(int col){
		int fila=-1,i=0;
		boolean vacia=false;
		while(i < this.tablero.getAlto() && !vacia ){
				if(this.tablero.getColorPosicion(i, col) == this.turno.VACIA){
					fila = i; 
					vacia = true;
				}
			i++;
		}	
		return fila;
	}
	
	public void turnoSiguiente(){
		if(this.turno == turno.BLANCA)
			this.turno = turno.NEGRA;
		else
			this.turno = turno.BLANCA;
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
		interfaz = "Juega "+this.pintarTurno();		
		interfaz = interfaz + System.getProperty("line.separator");
		interfaz = interfaz + "Qué deseas hacer? ";
		return interfaz;
	}
/**
 * MOSTRAMOS EL TURNO.
 * @return
 */
	public String pintarTurno(){
		String jugador="";
		if(this.turno == turno.BLANCA)
			jugador = jugador + "Blancas";
		else if(this.turno == turno.NEGRA)
			jugador = jugador + "Negras";
		return jugador;
	}
	
	public boolean partidaLlena(){
		boolean llena=true;
		int j = this.tablero.getAlto()-1;
		for(int i=0; i < this.tablero.getAncho() ; i++)
				if(this.tablero.getColorPosicion(j, i) == this.turno.VACIA)
					llena = false;
		return llena;
	}
}
