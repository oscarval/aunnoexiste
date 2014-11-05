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
		this.tablero = new Ficha[0][0];
	}
/**
 * CONSTRUCTORA: INCIAMOS EL TABLERO
 * @param ancho tipo int: del tablero
 * @param alto tipo int: del tablero
 */
	public Tablero(int ancho, int alto){
		this.ancho = ancho;
		this.alto = alto;
		this.tablero = new Ficha[ancho][alto];
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
/**
 * INSERTAMOS LA FICHA, QUE SE PASA COMO PARAMETRO, 	
 * @param color
 * @param columna
 * @return
 */
	public void insertaFicha( Ficha color,int fila, int columna){		
		this.tablero[columna][fila] = color;
	}
/**
 * RETORNAMOS EL COLOR DE LA FICHA EN DICHA POSICION 
 * @param fila
 * @param col
 * @return
 */
	public Ficha getColorPosicion(int col, int fila){
		return this.tablero[col][fila];
	}
/**
 * 	DEVUELVE EL TABLERO A PINTAR	
 */
	public String toString(){
		String lineas="";
		String cabecera="|";
		for(int i=1; i <= this.ancho; i++)
			cabecera = cabecera + i;
		cabecera = cabecera + "|" + System.getProperty("line.separator");
		for(int i=this.alto-1; i>=0 ; i--){
			lineas = lineas + "|";
			for(int j=0; j < this.ancho; j++){
				lineas = lineas + this.tablero[j][i].toString();
			}
			lineas = lineas +"|"+ System.getProperty("line.separator");
		}
		return lineas+cabecera;
	}
/**
 * INICIA EL TABLERO CON FICHAS VACIAS	
 * @param color
 */
	public void iniciarTableroVacio(){
		for(int i=0; i < this.alto; i++){
			for(int j=0; j < this.ancho; j++){
				this.tablero[j][i] = Ficha.VACIA;
			}
		}
	}
}
