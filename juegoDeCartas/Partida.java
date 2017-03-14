package juegoDeCartas;
import juegoDeCartas.excepciones.NoQuedanCartasException;
import juegoDeCartas.excepciones.NombreInvalidoException;
import utiles.DeseaContinuar;

/**
 * Diseña e implementa un juego de cartas. Para ello, comienza implementando el
 * juego de las siete y media. Es opcional implementar otro juego. Recuerda que:
 * 
 * 1. A las siete y media se juega con una baraja española 
 * 2. Pueden jugar tantos jugadores como se quiera. 
 * 3. Al principio del juego se indicará el alias de los jugadores implicados. 
 * 4. Se podrá averiguar el número de partidas ganadas y perdidas por cada jugador. 
 * 5. Se podrá mostrar el ranking de las partidas jugadas 
 * 6. Al iniciar cada partida se preguntará qué jugador juega y cuál no.
 * 7. Utiliza el método shuffle para barajar las cartas
 
 * Para que te plantees el diseño te dejo estas preguntas:
 * 
 * a) El hecho de pedir una carta, ¿a qué método se refiere? ¿De qué objeto/clase?
 * b) El hecho de plantarse un jugador, ¿a qué método se refiere? ¿De qué objeto/clase?
 * c) El hecho de plantarse, ¿a qué método se refiere? ¿De qué objeto/clase? 
 * d) El hecho de preguntar el nombre al jugador, ¿a qué método se refiere? ¿De qué objeto/clase? 
 * e) El hecho de preguntarle a un usuario si va a jugar o no, ¿a qué método se refiere? ¿De qué objeto/clase? 
 * f) ¿En qué se diferencia una partida de otra? ¿Coincide la baraja? 
 * g) ¿Qué tienen en común todas las partidas de siete y media? 
 * h)¿Utilizas algún valor constante?¿Utilizas enumeraciones?
 * 
 * @author Victoriano Sevillano Vega
 * @version 1.0
 */
public class Partida {
	private Baraja baraja;
	private Jugadores jugadores;
	private Jugadores participantes = new Jugadores();
	/**
	 * Constructor de la partida
	 * 
	 * @param jugadores
	 *            Array con el numero de jugadores
	 */
	public Partida() {
		baraja = new Baraja();
		jugadores = new Jugadores();
	}

	/**
	 * Añadir a un jugador al juego
	 * @param nombre
	 * @return
	 * @throws NombreInvalidoException 
	 */
	boolean addJugador(String nombre) throws NombreInvalidoException {
		if (jugadores.add(nombre))
			return true;
		return false;
	}
	
	/**
	 * Busca a un jugador en el juego
	 * @param nombre
	 * @throws NombreInvalidoException
	 */
	String buscarJugador(String nombre) throws NombreInvalidoException {
		if (jugadores.buscar(nombre) == null)
			return "No se pudo encontrar";
		return "" + jugadores.buscar(nombre);
	}
	/**
	 * Elimina a un jugador al juego
	 * @param nombre
	 * @return
	 * @throws NombreInvalidoException 
	 */
	boolean removeJugador(String nombre) throws NombreInvalidoException {
		if (jugadores.remove(nombre))
			return true;
		return false;
	}
	
	/**
	 * Mustra el arraylist de jugadores
	 * @return
	 */
	StringBuilder mostrarJugadores() {
		return jugadores.mostrarJugadores();
	}
	
	/**
	 * Comprueba si el ArrayList de jugadores esta vacio 
	 * @return
	 */
	boolean isEmptyJugador() {
		return jugadores.isEmpty();
	}
	
	/**
	 * Saca una carta de la baraja
	 * 
	 * @return
	 * @throws NoQuedanCartasException
	 */
	Carta sacarCarta() throws NoQuedanCartasException {
		return baraja.darMano();
	}
	
	/**
	 * Indica el valor de la carta sacada
	 * @return
	 */
	double valorCarta() {
		return baraja.valorCartaSacada();
	}

	/**
	 * Añade un participante
	 * @param nombre
	 * @return
	 * @throws NombreInvalidoException
	 */
	boolean addParticipante(String nombre) throws NombreInvalidoException {
		if (participantes.add(nombre))
			return true;
		else
			return false;
	}
	
	/**
	 * Mustra un participante
	 * @return
	 */
	StringBuilder mostrarParticipantes() {
		return participantes.mostrarJugadores();
	}
	
	/**
	 * Indica el numero de participantes
	 * @return
	 */
	int sizeParticipantes() {
		return participantes.size();
	}
	
}
