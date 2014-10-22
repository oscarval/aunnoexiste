package tp.pr1;
import java.util.Scanner;

public class Controlador {	
	private Partida partida;
	private Scanner in;
/**
 * Solicita una orden al usuario	
 */
	public void run(){	
		String orden;
		int incorrecto;
		int columna;
		boolean salir = false;
		this.in = new Scanner(System.in);
		do{
			incorrecto = 0;
			System.out.println(partida.cabecera());		
			orden = this.in.next();				
			if(orden.equalsIgnoreCase("poner")){
				System.out.println("Introduce la columna: ");
				columna = this.in.nextInt();this.in.nextLine();
				partida.ejecutaMovimiento(partida.getTurno(), columna);
				System.out.println(partida);
			}
			else if(orden.equalsIgnoreCase("deshacer")){
				
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
		while ((!partida.esTerminada() || incorrecto == 1) && !salir);
	}
	
	public void nuevaPartida(Partida refPartida){
		this.partida = refPartida;		
	}
}
