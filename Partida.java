package tp.pr1;

public class Partida {
//	ATRIBUTOS
	private Tablero tablero;
	private Ficha turno;
	private boolean terminada;
	private Ficha ganador;
	private Pila pila;
	
/**
 * CONTRUCTORA INICIAL: Define la capacidad de la pila de Deshacer, inicializa el tablero y cede el turno a blancas
 */
	public Partida(){
		this.pila = new Pila();
		this.terminada = false;
		this.tablero = new Tablero(4,4);
		this.tablero.iniciarTableroVacio();
		this.turno = Ficha.BLANCA;
	}
/**
 * REINICIA LA PARTIDA PONIENDO TODAS LA FICHAS EN VACIAS Y LA PILA A 0
 */
	public void reiniciarPartida(){
		this.pila.reiniciarPila();
		this.tablero.iniciarTableroVacio();
		this.turno = Ficha.BLANCA;
	}
	
/**
 * PONER MOVIMIENTO (COLUMNA) EN LA PILA
 * @param col Número de columna seleccionada. Importante: col debe ser >0
 */
	private void ponerStack(int col){
		this.pila.poner(col-1);
	}
/**
 * OBTENER EL ÚLTIMO NUMERO DE COLUMNA QUE SE ENCUENTRA EN LA PILA	
 * @return El número de columna
 */
	private int sacarStack(){
		return this.pila.sacar();
	}
/**
 * DESHACE EL ÚLTIMO MOVIMIENTO QUE SE HA REALIZADO EN LA PARTIDA	
 * @return Booleano que confirma si el posible deshacer.
 */
	public boolean deshacer(){
		boolean ok=false;
		int colum = this.sacarStack();
		if(colum != -1){
			this.deshacerFicha(colum);
			ok = true;
		}
		return ok;
	}
/**
 * DESHACE EL MOVIMIENTO REALIZADO EN UNA COLUMNA, CONVIRTIENDO LA PRIMERA FICHA DIFERENTE DE VACIA DE LA COLUMNA, EN VACIA	
 * @param colum Número de columna 
 */
	private void deshacerFicha(int colum){
		int i= this.tablero.getAlto()-1;
		boolean finish=false;
		while( i >=0 && !finish)
		{
			if(this.tablero.getColorPosicion(colum, i) != Ficha.VACIA)
			{
				this.tablero.insertaFicha(Ficha.VACIA, i, colum);
				finish = true;
			}
			i--;
		}
	}
	
/**
 * COLOCAR UNA FICHA EN LA COLUMNA CORRESPONDIENTE
 * DEFINE EL TURNO EN EL TABLERO
 * COMPRUEBA SI LA PARTIDA SIGUE O FINALIZA
 * 
 * @param color tipo ficha(enum)
 * @param col tipo int: columna de colocacion de ficha
 * @return si todo es correcto y valido
 */
	public boolean ejecutaMovimiento(Ficha color, int col){
		boolean OK = true;
		int fila;
		this.terminada = false;
		
		if(col <= this.tablero.getAncho() && col > 0)
		{
			fila = this.getFilaVacia(col);
			if(fila != -1)
			{
				this.tablero.insertaFicha(this.turno,fila, col-1);
				
				if(this.existeGanador())
				{			//llamamos a la funcion para saber si existe ganador
					this.terminada = true;
					this.ganador = this.turno;
				}
				else
					this.ponerStack(col);
			}
			else
				OK = false;
		}
		else
			OK = false;
		
		return OK;
	}
	
/**
 * COMPROBAR LA FILA VACIA EN EL TABLERO 	
 * @param col Número de columna 
 * @return Número de fila vacía. Retornará -1 si esta llena.
 */
	private int getFilaVacia(int col){
		int fila=-1,i=0;
		boolean vacia=false;
		while(i < this.tablero.getAlto() && !vacia )
		{
				if(this.tablero.getColorPosicion(col-1,i) == Ficha.VACIA)
				{
					fila = i; 
					vacia = true;
				}
			i++;
		}	
		return fila;
	}
	
/**
 * PASA AL SIGUIENTE TURNO
 */
	public void turnoSiguiente(){
		if(this.turno == Ficha.BLANCA)
			this.turno = Ficha.NEGRA;
		else
			this.turno = Ficha.BLANCA;
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
 * RETORNA LA FICHA(TURNO) QUE ESTA ACTIVO PARA EJECUTAR MOVIMIENTO
 * @return El turno presente en la partida
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
		interfaz = interfaz + "¿Que deseas hacer? ";
		return interfaz;
	}
	
/**
 * MOSTRAMOS EL TURNO.
 * @return Convertimos a String el valor de la Ficha
 */
	public String pintarTurno(){
		String jugador="";
		if(this.turno == Ficha.BLANCA)
			jugador = jugador + "Blancas";
		else if(this.turno == Ficha.NEGRA)
			jugador = jugador + "Negras";
		return jugador;
	}
	
/**
 * DEVUELVE EL GANADOR DE LA PARTIDA	
 * @return El valor de la ficha ganadora, en formato string
 */
	public String getGanador(){
		String jugador="";
		if(this.ganador == Ficha.BLANCA)
			jugador = jugador + "Blancas";
		else if(this.ganador == Ficha.NEGRA)
			jugador = jugador + "Negras";
		return jugador;
	}
	
/**
 * 	COMPRUEBA SI LA PARTIDA SE HA LLENADO TOTALMENTE
 * @return Valor booleano si está llena o no
 */
	public boolean partidaLlena(){
		boolean llena=true;
		int j = this.tablero.getAlto()-1;
		for(int i=0; i < this.tablero.getAncho() ; i++)
				if(this.tablero.getColorPosicion(i,j) == Ficha.VACIA)
					llena = false;
		return llena;
	}
	
/**
 * COMPRUEBA SI HAY UN GANADOR CON 4 FICHAS SEGUIDAS
 * @return un valor booleano si hay ganador
 */
	public boolean existeGanador(){
		boolean finish=false;
		int validos = 0,i=0,j=0,k=0;
		
//		Comprobamos en horizontal
		while(i <this.tablero.getAlto())
		{
			j=0;
			validos=0;
			while(j <this.tablero.getAncho() && !finish)
			{
				if(this.tablero.getColorPosicion(j, i) == this.turno)
				{
					validos++;
				}
				else
				{
					validos=0;
				}
				if(validos > 3)
					finish=true;
				j++;
			}
			i++;
		}
		i=0;j=0;
		if(validos < 4)
			validos = 0;
		
//		Comprobamos en vertical
		while(i <this.tablero.getAncho() && !finish)
		{
			j=0;
			validos=0;
			while(j <this.tablero.getAlto())
			{
				if(this.tablero.getColorPosicion(i, j) == this.turno )
				{
					validos++;
				}
				else
				{
					validos=0;
				}	
				if(validos > 3)
					finish=true;
				j++;			
			}
			i++;
		}
		i=0;j=0;
		if(validos < 4)
			validos = 0;
		
//		Comprobamos en diagonal
		while(i < this.tablero.getAncho() && !finish)
		{
			j=0;
			while(j <this.tablero.getAlto() && !finish)
			{
				k=0;
				validos=0;
				while(i+k < this.tablero.getAncho() && j+k < this.tablero.getAlto())
				{
					if(this.tablero.getColorPosicion(i+k, j+k) == this.turno )
					{
						validos++;
					}
					else
					{
						validos=0;
					}	
					if(validos > 3)
						finish=true;
					k++;
				}
				j++;
			}
			i++;
		}
		i=0;j=0;k=0;
		if(validos < 4)
			validos = 0;
		
//		comprobamos diagonal inverso
		while(i < this.tablero.getAncho() && !finish)
		{
			j=3;
			while(j <this.tablero.getAlto() && !finish)
			{
				k=0;
				validos=0;
				while(i+k+3 < this.tablero.getAncho()  && j-k >=0 && this.tablero.getColorPosicion(i+k, j-k) != Ficha.VACIA)
				{
					if(this.tablero.getColorPosicion(i+k, j-k) == this.turno )
					{
						validos++;
					}
					else
					{
						validos=0;
					}	
					if(validos > 3)
						finish=true;
					k++;
				}
				j++;
			}
			i++;
		}
		
		return finish;
	}
}
