package tp.pr1;

public class Pila {
	public static final int MAX_PILA = 10;
	private int[] undoStack;
	private int numUndo;
/**
 * CONTRUCTORA QUE INCIALIZA LA PILA	
 */
	public Pila(){
		this.undoStack = new int[MAX_PILA];
		this.numUndo = 0;
	}
/**
 * REINICIA LA PILA, PONIENDO EL CONTADOR DEL ARRAY A 0	
 */
	public void reiniciarPila(){
		this.numUndo = 0;
	}
	
/**
 * 	PONER MOVIMIENTO(COLUMNA) EN LA PILA	
 * @param col Número de columna
 */
	public void poner(int col){
		if(!this.estaLlena()){
			this.undoStack[this.numUndo] = col;
			this.numUndo++;
		}
		else{
			//recorrer la pila a la izquierda
			for(int i = 0; i < MAX_PILA-1; i++){
				this.undoStack[i] = this.undoStack[i+1];
			}
			this.undoStack[MAX_PILA-1] = col;
		}
	}
/**
 * OBTIENE EL ULTIMO VALOR DE LA PILA	
 * @return Número del último movimiento(columna) que se ha realizado
 */
	public int sacar(){
		int col=-1;
		if(!this.estaVacia()){
			col = this.undoStack[this.numUndo-1];
			this.numUndo--;
		}
		return col;
	}
/**
 * COMPROBAR SI LA PILA ESTA VACIA	
 * @return Booleano si esta vacia o no
 */
	private boolean estaVacia(){
		boolean ok=false;
		if(this.numUndo == 0)
			ok=true;
		return ok;
	}
/**
 * COMPROBAR SI LA PILA ESTA LLENA
 * @return Booleano si esta llena o no
 */
	private boolean estaLlena(){
		boolean ok=false;
		if(this.numUndo == MAX_PILA)
			ok = true;
		return ok;
	}
}
