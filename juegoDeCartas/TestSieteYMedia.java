package juegoDeCartas;


import juegoDeCartas.excepciones.NoQuedanCartasException;
import juegoDeCartas.excepciones.NombreInvalidoException;
import utiles.DeseaContinuar;
import utiles.Menu;
import utiles.Teclado;
/**
 * Diseña e implementa un juego de cartas. Para ello, comienza implementando el juego de las siete y media. 
 * Es opcional implementar otro juego. Recuerda que:
 * A las siete y media se juega con una baraja española
 * Pueden jugar tantos jugadores como se quiera.
 * Al principio del juego se indicará el alias de los jugadores implicados. 
 * Se podrá averiguar el número de partidas ganadas y perdidas por cada jugador.
 * Se podrá mostrar el ranking de las partidas jugadas 
 * Al iniciar cada partida se preguntará qué jugador juega y cuál no.
 * Para que te plantees el diseño te dejo estas preguntas:
 * 
 * El hecho de pedir una carta, ¿a qué método se refiere? ¿De qué objeto/clase?
 * El hecho de plantarse un jugador, ¿a qué método se refiere? ¿De qué objeto/clase?
 * El hecho de plantarse, ¿a qué método se refiere? ¿De qué objeto/clase?
 * El hecho de preguntar el nombre al jugador, ¿a qué método se refiere? ¿De qué objeto/clase?
 * El hecho de preguntarle a un usuario si va a jugar o no, ¿a qué método se refiere? ¿De qué objeto/clase?
 * ¿En qué se diferencia una partida de otra? ¿Coincide la baraja?
 * ¿Qué tienen en común todas las partidas de siete y media?
 * ¿Utilizas algún valor constante?¿Utilizas enumeraciones?
 * 
 * @author Victoriano Sevillano Vega
 * @version 1.0
 */
public class TestSieteYMedia {
	/**
	 * Creamos la partida
	 */
	private static Partida partida;
	/**
	 * Menu para opciones generales
	 */
	private static Menu menuGeneral;
	/**
	 * Menu para jugar
	 */
	private static Menu menuJuego;

	private static Jugadores jugadores = new Jugadores();
	private static Jugadores participantes = new Jugadores();

	public static void main(String[] args) throws NombreInvalidoException, JugadorYaExisteException {
		menuGeneral = new Menu("*** Menu Siete y Media ***", new String[] { "Añadir jugador", "Eliminar jugador",
				"Buscar jugador", "Mostrar jugadores", "Jugar", "Ranking", "Salir" });
		menuJuego = new Menu("*** Menu del jugador ***",
				new String[] { "Escoger jugadores", "Mostrar escogidos", "Iniciar juego", "Volver" });
		int opcion;

		cargaJugadores();
		do {
			opcion = menuGeneral.gestionar();
			try {
				gestionarOpciones(opcion);
			} catch (JugadorNoExisteException | NombreInvalidoException | JugadorYaExisteException e) {
				System.err.println(e.getMessage());
			}
		} while (opcion != 7);
	}

	/**
	 * Gestiona las opciones del menu principal @throws
	 * @throws JugadorYaExisteException 
	 * @throws JugadorNoExisteException 
	 * 
	 */
	private static void gestionarOpciones(int opcion) throws NombreInvalidoException, JugadorYaExisteException, JugadorNoExisteException {
		switch (opcion) {
		case 1:
			// Añadir jugador
			if (jugadores.add(Teclado.leerCadena("Nombre del jugador:")))
				System.out.println("Jugador añadido");
		case 2:
			// Eliminar jugador
			if (jugadores.isEmpty())
				System.out.println("No hay jugadores que eliminar");
			else if (jugadores.remove(Teclado.leerCadena("Nombre del jugador:")))
				System.out.println("Jugador eliminado");

			break;
		case 3:
			// Buscar jugador
			System.out.println(jugadores.buscar(Teclado.leerCadena("Nombre del jugador:")));
			break;
		case 4:
			// Mostrar jugadores
			if (!jugadores.isEmpty()) {
				System.out.println("Lista de jugadores:" + jugadores.mostrarJugadores());
			} else
				System.out.println("Lista de jugadores vacia!");
			break;
		case 5:
			// Jugar
			do {
				opcion = menuJuego.gestionar();
				gestionarOpcionesJuego(opcion);
			} while (opcion != 4);
			break;
		case 6:
			// Ranking
			if (!jugadores.isEmpty()) {
				System.out.println("RANKING:" + jugadores.mostrarJugadores());
			} else
				System.out.println("Lista de jugadores vacia!");
			break;
		case 7:
			// Salir
			System.out.println("Adios");
			break;
		}
	}

	/**
	 * Gestiona las opciones del menu de modificacion de jugadores
	 * 
	 * @param opcion
	 *            escogida
	 * @throws JugadorNoExisteException 
	 * @throws JugadorYaExisteException 
	 */
	private static void gestionarOpcionesJuego(int opcion) throws NombreInvalidoException, JugadorNoExisteException, JugadorYaExisteException {
		switch (opcion) {
		case 1:
			// Escoger jugadores
			if (!jugadores.isEmpty()) {
				System.out.println("Lista de jugadores:" + jugadores.mostrarJugadores());
				escogerParticipantes();
			} else
				System.out.println("Debes crear antes algun jugador!");
			break;
		case 2:
			// Mostrar escogidos
			if (!participantes.isEmpty()) {
				System.out.println("Jugadores escogidos:\n" + participantes.mostrarJugadores());
			} else
				System.out.println("Debes escoger algun jugador! Minimo 2.");
			break;
		case 3:
			// Iniciar juego
			partida = new Partida(participantes);
			if (participantes.size() >= 2) {
				partida.jugar();
			} else
				System.out.println("Escoge 2 jugadores al menos.");
			break;
		case 4:
			// Salir
			System.out.println("Volviendo...");
			break;
		}
	}

	/**
	 * Escoge a los jugadores que van a jugar
	 * @throws JugadorYaExisteException 
	 */
	private static Jugadores escogerParticipantes() throws NombreInvalidoException, JugadorYaExisteException {
		String nombre;
		do {
			 nombre = Teclado.leerCadena("Nombre del jugador:");
			if (jugadores.contains(nombre))
				if (participantes.add(nombre)) 
					System.out.println("Participante añadido");
		} while (DeseaContinuar.continuar("¿Añadir otro? s/n"));
		return participantes;
	}

	/**
	 * Carga estatica de jugadores para facilitar pruebas
	 * 
	 * @throws NombreInvalidoException
	 * @throws JugadorYaExisteException 
	 */
	static void cargaJugadores() throws NombreInvalidoException, JugadorYaExisteException {
		jugadores.add("Guillermo");
		jugadores.add("Pepe");
		jugadores.add("Juan");
		jugadores.add("Jose");
		jugadores.add("Jaime");
		jugadores.add("Jesus");
		jugadores.add("Luis");
		jugadores.add("Victor");
	}
}