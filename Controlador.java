package tp.pr1;

import java.util.Scanner;
public class Controlador {	
	private Partida partida;
	private Scanner in;
	
	public Controlador(Partida partida, Scanner in){
		this.partida = partida;
		this.in = in;
	}
/**
 * Solicita una orden al usuario	
 */
	public void run(){	
		String orden;
		int incorrecto;
		int columna;
		boolean salir = false,terminada=false;
		
		do{
			incorrecto = 0;
			System.out.println(partida.cabecera());		
			orden = this.in.next();
				if(orden.equalsIgnoreCase("poner")){			
					System.out.println("Introduce la columna: ");
					columna = this.in.nextInt();this.in.nextLine();
					if(partida.ejecutaMovimiento(partida.getTurno(), columna)){
						System.out.println(partida);
						terminada = this.partida.esTerminada();
						if(!terminada)
							this.partida.turnoSiguiente();
					}
					else{					
						System.out.println("Movimiento incorrecto");
						System.out.println(partida);
					}
				}
				else if(orden.equalsIgnoreCase("deshacer")){
					if(this.partida.deshacer()){
						System.out.println(partida);
						this.partida.turnoSiguiente();
					}else{
						System.out.println("Movimiento incorrecto");
						System.out.println(partida);
					}
				}
				else if(orden.equalsIgnoreCase("reiniciar")){
					
				}
				else if(orden.equalsIgnoreCase("salir")){
					salir = true;
				}
				else{
					System.out.println("Orden incorrecta");
					incorrecto = 1;			
				}
		}
		while ((!terminada || incorrecto == 1) && !salir && !partida.partidaLlena());
		
		if (salir == true) 			//	Si ha seleccionado salir
		{
			System.out.println("Te has retirado!") ;
		}
	
		else if (this.partida.existeGanador())			// Si ha ganado alguien
		{
	
			System.out.println("Partida Ganada por: " + partida.getGanador());
		}	
	
		else if (partida.partidaLlena())  		// Si esta llena
		{
			System.out.println("Partida llena");
		}
		
	}
}
