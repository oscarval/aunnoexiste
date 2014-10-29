package tp.pr1;

public enum Ficha {
	VACIA, BLANCA, NEGRA;
/**
 * RETORNA LA CONVERSIÓN DE LA FICHA A STRING (x,o)	
 */
	public String toString(){
		String ficha="-";
		if(this == BLANCA)
			ficha = "x";
		else if(this == NEGRA)
			ficha ="o";	
		return ficha;
	}
}
