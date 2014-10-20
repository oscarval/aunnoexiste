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
		boolean salir = false;
		do{
			incorrecto = 0;
			System.out.println("Qué deseas hacer: (salir,poner,deshacer,reiniciar) ");			
			orden = this.in.next();
				
			if(orden.equals("poner")){
				System.out.println(orden);
			}
			else if(orden.equals("poner")){
				
			}
			else if(orden.equals("reiniciar")){
				
			}
			else if(orden.equals("salir")){
				salir = true;
			}
			else{
				System.out.println("Orden incorrecta");
				incorrecto = 1;
			}
		}
		while ((!partida.esTerminada() || incorrecto == 1) && !salir);
	}
	
	public void nuevaPartida(){
		this.partida = new Partida();
		this.in = new Scanner(System.in);
		this.run();
	}
}
