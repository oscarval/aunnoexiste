package tp.pr1;

public class Main {

	public static void main(String[] args) {
//		CREAR PARTIDA VACÍA
		Partida partida = new Partida();
//		CRAER CONTROLADOR
		Controlador controlador = new Controlador();
//		LANZAMOS LA EJECUCIÓN DEL JUEGO CON LA PARTIDA VACÍA
		controlador.nuevaPartida(partida);
		controlador.run();
	}

}
