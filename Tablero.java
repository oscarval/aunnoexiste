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
	public boolean insertaFicha(Ficha color,int columna, Ficha turno){
			for(int i=0; i < this.alto; i++){
				if(this.tablero[i][columna] == color.BLANCA){
					this.tablero[i][columna] = turno;
				}
			}
		return true;
	}
/**
 * 	DEVUELVE EL TABLERO A PINTAR	
 */
	public String toString(){
		String lineas="";
		String cabecera="|";
		for(int i=1; i < this.ancho; i++)
			cabecera = cabecera + i;
		cabecera = cabecera + "|" + System.getProperty("line.separator");
		for(int i=this.alto-1; i >= 0; i--){
			lineas = lineas + "|";
			for(int j=0; j < this.ancho-1; j++){
				lineas = lineas + this.tablero[i][j]; 
			}
			lineas = lineas + "|\n";
		}
		return lineas+cabecera;
	}
	
	public void iniciarTableroVacio(Ficha color){
		for(int i=0; i < this.alto; i++)
			for(int j=0; j < this.ancho; j++)
				this.tablero[i][j] = color;
	}
}
