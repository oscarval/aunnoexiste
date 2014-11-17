package tp.pr1;
import java.util.Scanner;

public class Main {
	private static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
//		CREAR PARTIDA VACIA
		Partida partida = new Partida(); 
//		CREAR CONTROLADOR
		Controlador controlador = new Controlador(partida, in);
//		LANZAMOS LA EJECUCION DEL JUEGO CON LA PARTIDA VACIA
		controlador.run();
	}

}
