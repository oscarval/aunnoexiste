package tp.pr1;
import java.util.Scanner;

public class Main {
	private static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
//		CREAR PARTIDA VAC�A
		Partida partida = new Partida(); 
//		CRAER CONTROLADOR
		Controlador controlador = new Controlador(partida, in);
//		LANZAMOS LA EJECUCI�N DEL JUEGO CON LA PARTIDA VAC�A
		controlador.run();
	}

}
