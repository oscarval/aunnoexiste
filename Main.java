package tp.pr1;

public class Main {

	public static void main(String[] args) {
		// CREAR PARTIDA VAC�A
		Tablero tablero = new Tablero(4,4);
		Controlador controlador = new Controlador();
		controlador.nuevaPartida();
	}

}
