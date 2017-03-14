package juegoDeCartas;


import juegoDeCartas.excepciones.NoQuedanCartasException;
import juegoDeCartas.excepciones.NombreInvalidoException;
import utiles.DeseaContinuar;
import utiles.Menu;
import utiles.Teclado;
/**
 * Dise�a e implementa un juego de cartas. Para ello, comienza implementando el juego de las siete y media. 
 * Es opcional implementar otro juego. Recuerda que:
 * A las siete y media se juega con una baraja espa�ola
 * Pueden jugar tantos jugadores como se quiera.
 * Al principio del juego se indicar� el alias de los jugadores implicados. 
 * Se podr� averiguar el n�mero de partidas ganadas y perdidas por cada jugador.
 * Se podr� mostrar el ranking de las partidas jugadas 
 * Al iniciar cada partida se preguntar� qu� jugador juega y cu�l no.
 * Para que te plantees el dise�o te dejo estas preguntas:
 * 
 * El hecho de pedir una carta, �a qu� m�todo se refiere? �De qu� objeto/clase?
 * El hecho de plantarse un jugador, �a qu� m�todo se refiere? �De qu� objeto/clase?
 * El hecho de plantarse, �a qu� m�todo se refiere? �De qu� objeto/clase?
 * El hecho de preguntar el nombre al jugador, �a qu� m�todo se refiere? �De qu� objeto/clase?
 * El hecho de preguntarle a un usuario si va a jugar o no, �a qu� m�todo se refiere? �De qu� objeto/clase?
 * �En qu� se diferencia una partida de otra? �Coincide la baraja?
 * �Qu� tienen en com�n todas las partidas de siete y media?
 * �Utilizas alg�n valor constante?�Utilizas enumeraciones?
 * 
 * @author Victoriano Sevillano Vega
 * @version 1.0
 */
public class TestSieteYMedia {
	/**
	 * Creamos la partida
	 */
	private static Partida partida = new Partida();
	/**
	 * Menu para opciones generales
	 */
	private static Menu menuGeneral;
	/**
	 * Menu para jugar
	 */
	private static Menu menuJuego;
	/**
	 * Estructura de jugadores
	 */	
	
	public static void main(String[] args) {
		menuGeneral = new Menu("*** Menu Siete y Media ***", new String[] {"A�adir jugador","Eliminar jugador", "Buscar jugador","Mostrar jugadores", "Jugar", "Ranking", "Salir"});
		menuJuego = new Menu("*** Menu del jugador ***", new String[] {"Escoger jugadores", "Mostrar escogidos","Iniciar juego", "Volver"});
		int opcion;
		do {
			opcion = menuGeneral.gestionar();
			try {
				gestionarOpciones(opcion);
			} catch (NombreInvalidoException | NoQuedanCartasException e) {
				System.err.println(e.getMessage());
			}
		} while (opcion != 7);
	}

	/**
	 * Gestiona las opciones del menu principal
	 * @param opcion
	 * @throws NoQuedanCartasException 
	 * @throws NombreInvalidoException 
	 */
	private static void gestionarOpciones(int opcion) throws NoQuedanCartasException, NombreInvalidoException {
		switch (opcion) {
		case 1:
			// A�adir jugador
			if(partida.addJugador(Teclado.leerCadena("Nombre del jugador:")))
				System.out.println("Jugador a�adido");
			else
				System.out.println("No se pudo a�adir");
			break;
		case 2:
			// Eliminar jugador
			if (partida.removeJugador(Teclado.leerCadena("Nombre del jugador:")))
				System.out.println("Jugador eliminado");
			else
				System.out.println("No se pudo eliminar");
			break;
		case 3:
			// Buscar jugador
			System.out.println(partida.buscarJugador(Teclado.leerCadena("Nombre del jugador:")));
			break;
		case 4:
			// Mostrar jugadores
			if (!partida.isEmptyJugador()) {
				System.out.println("Lista de jugadores:" + partida.mostrarJugadores());
			}
			else
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
			
			break;
		case 7:
			//Salir
			System.out.println("Adios");
			break;
		}
	}
	
	/**
	 * Gestiona las opciones del menu de modificacion de jugadores
	 * @param opcion escogida
	 * @throws NoQuedanCartasException 
	 * @throws NombreInvalidoException 
	 */
	private static void gestionarOpcionesJuego(int opcion) throws NoQuedanCartasException, NombreInvalidoException {
		switch (opcion) {
		case 1:
			// Escoger jugadores
			if (!partida.isEmptyJugador()) {
				System.out.println("Lista de jugadores:" + partida.mostrarJugadores());
				escogerJugadores();
			}
			else
				System.out.println("Debes crear antes algun jugador!");
			
			break;
		case 2:
			// Mostrar escogidos
			System.out.println("Jugadores escogidos:\n" + partida.mostrarParticipantes());
			break;
		case 3:
			jugar();
			break;
		case 4:
			// Salir
			break;
		}
	}
	
	/**
	 * 
	 * @throws NoQuedanCartasException
	 */
	private static void jugar() throws NoQuedanCartasException {
		double puntuacion = 0;
		for (int i = 0; i < partida.sizeParticipantes(); i++) {
			do {
				System.out.println("Turno del jugador " + (i+1));
				System.out.println(partida.sacarCarta());
				puntuacion += partida.valorCarta();
				System.out.println(puntuacion);
			} while (DeseaContinuar.continuar("�Quiere carta? s/n"));
		}
	}

	/**
	 * Escoge los jugadores
	 * @throws NombreInvalidoException 
	 */
	public static void escogerJugadores() throws NombreInvalidoException {
		do {
			if(!partida.addParticipante(Teclado.leerCadena("Nombre del jugador:")))
				System.out.println("No se pudo a�adir");
		} while (DeseaContinuar.continuar("�A�adir otro? s/n"));
	}
}
