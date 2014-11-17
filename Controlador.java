package tp.pr1;

import java.util.Scanner;
public class Controlador {
	private Partida partida;
	private Scanner in;
/**
 * CONTRUCTORA QUE INICIA LA PARTIDA Y SUS ATRIBUTOS
 * @param partida Partida a jugar. Se pasa una partid aocmo referencia
 * @param in Se utiliza para obtener los opciones que el usuario introduzca por teclado
 */
	public Controlador(Partida partida, Scanner in){
		this.partida = partida;
		this.in = in;
	}
	
/**
 * EJECUTA EL JUEGO Y CONTROLA LA PARTIDA INCIADA.	
 */
	public void run(){	
		String orden;
		int incorrecto;
		int columna;
		boolean salir = false,terminada=false;
		
		
		do {
			incorrecto = 0;
			System.out.println(partida);
			System.out.println(partida.cabecera());		
			orden = this.in.next();
			
			if(orden.equalsIgnoreCase("poner"))
			{			
				System.out.println("Introduce la columna: ");
				columna = this.in.nextInt();
				this.in.nextLine();
				
				if(partida.ejecutaMovimiento(partida.getTurno(), columna))
				{
					
					terminada = this.partida.esTerminada();
					if(!terminada)
						this.partida.turnoSiguiente();
				}
					
				else
				{					
					System.out.println("Movimiento incorrecto");
				
				}
			}
				
			else if(orden.equalsIgnoreCase("deshacer"))
			{
				if(this.partida.deshacer()){
					this.partida.turnoSiguiente();
				}
				else
				{
					System.out.println("Movimiento incorrecto");
				}
			}
			
			else if(orden.equalsIgnoreCase("reiniciar"))
			{
				
				this.partida.reiniciarPartida();
			}
			
			else if(orden.equalsIgnoreCase("salir"))
			{
				salir = true;
			}
			
			else
			{
				System.out.println("Orden incorrecta");
				incorrecto = 1;			
			}
		}	while ((!terminada || incorrecto == 1) && !salir && !partida.partidaLlena());
		
		if (salir == true) 			//	Si ha seleccionado salir
		{
			System.out.println("Te has retirado!") ;
		}
	
		else if (this.partida.existeGanador())			// Si ha ganado alguien
		{
	
			System.out.println("Partida Ganada por: " + partida.getGanador());
		}	
	
		else if (partida.partidaLlena())  		// Si está llena
		{
			System.out.println("Partida llena");
		}
		
	}
}
