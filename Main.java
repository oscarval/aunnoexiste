package tp.pr1;

public class Main {

	public static void main(String[] args) {
//		CREAR PARTIDA VAC�A
		Partida partida = new Partida();
//		CRAER CONTROLADOR
		Controlador controlador = new Controlador();
//		LANZAMOS LA EJECUCI�N DEL JUEGO CON LA PARTIDA VAC�A
		controlador.nuevaPartida(partida);
		controlador.run();
	}

}
