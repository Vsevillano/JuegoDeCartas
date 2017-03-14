package juegoDeCartas;

import java.util.ArrayList;
import java.util.Iterator;

import juegoDeCartas.excepciones.NombreInvalidoException;
/**
 * Dise�a e implementa un juego de cartas. Para ello, comienza implementando el
 * juego de las siete y media. Es opcional implementar otro juego. Recuerda que:
 * 
 * 1. A las siete y media se juega con una baraja espa�ola 
 * 2. Pueden jugar tantos jugadores como se quiera. 
 * 3. Al principio del juego se indicar� el alias de los jugadores implicados. 
 * 4. Se podr� averiguar el n�mero de partidas ganadas y perdidas por cada jugador. 
 * 5. Se podr� mostrar el ranking de las partidas jugadas 
 * 6. Al iniciar cada partida se preguntar� qu� jugador juega y cu�l no.
 * 7. Utiliza el m�todo shuffle para barajar las cartas
 
 * Para que te plantees el dise�o te dejo estas preguntas:
 * 
 * a) El hecho de pedir una carta, �a qu� m�todo se refiere? �De qu� objeto/clase?
 * b) El hecho de plantarse un jugador, �a qu� m�todo se refiere? �De qu� objeto/clase?
 * c) El hecho de plantarse, �a qu� m�todo se refiere? �De qu� objeto/clase? 
 * d) El hecho de preguntar el nombre al jugador, �a qu� m�todo se refiere? �De qu� objeto/clase? 
 * e) El hecho de preguntarle a un usuario si va a jugar o no, �a qu� m�todo se refiere? �De qu� objeto/clase? 
 * f) �En qu� se diferencia una partida de otra? �Coincide la baraja? 
 * g) �Qu� tienen en com�n todas las partidas de siete y media? 
 * h)�Utilizas alg�n valor constante?�Utilizas enumeraciones?
 * 
 * @author Victoriano Sevillano Vega
 * @version 1.0
 */
public class Jugadores {
	/**
	 * ArrayList para jugadores
	 */
	private ArrayList<Jugador> jugadores;

	/**
	 * Constructor para jugadores
	 */
	public Jugadores() {
		jugadores = new ArrayList<Jugador>();
	}

	/**
	 * A�ade un jugador al juego
	 * 
	 * @param nombre
	 * @return true si es a�adiro
	 * @throws NombreInvalidoException
	 */
	boolean add(String nombre) throws NombreInvalidoException {
		if (jugadores.add(new Jugador(nombre)))
			return true;
		return false;
	}

	/**
	 * Elimina un jugador del juego
	 * 
	 * @param nombre
	 * @return true o false si es borrado o no
	 * @throws NombreInvalidoException
	 */
	boolean remove(String nombre) throws NombreInvalidoException {
		Jugador jugador = new Jugador(nombre);
		if (jugadores.contains(jugador))
			return jugadores.remove(jugador);
		return false;
		
	}

	/**
	 * Busca un jugador por nombre
	 * @param nombre
	 * @return el elemento con el nombre indicado
	 * @throws NombreInvalidoException
	 */
	Jugador buscar(String nombre) throws NombreInvalidoException {
		Jugador jugador = new Jugador(nombre);
			if (jugadores.contains(jugador)) {
				return jugadores.get(jugadores.indexOf(jugador));
			}
			return null;
			
	}


	/**
	 * Obtiene el jugador dado un nombre
	 * 
	 * @param nombre
	 * @return el elemento en la posicion indicada
	 */
	Jugador get(int indice) {
		if (jugadores.contains(jugadores.get(indice)))
			return jugadores.get(indice);
		return null;
	}

	/**
	 * Devuelve el indice de un jugador
	 * 
	 * @param indice
	 * @return el indice del jugador
	 */
	int indexOf(int indice) {
		return jugadores.indexOf(indice);
	}

	/**
	 * Indica si el arrayList de jugadores esta vacio
	 * @return true o false en funcion de si esta vacio o no
	 */
	boolean isEmpty() {
		return jugadores.isEmpty();
	}
	
	/**
	 * Devuelve el numero de elementos en el arraylist de jugadores
	 * @return entero que indica el nuero de jugadores
	 */
	int size() {
		return jugadores.size();
	}

	/**
	 * Muestra el arrayList de jugadores
	 */
	StringBuilder mostrarJugadores() {
		StringBuilder cadena = new StringBuilder("");
		for (Iterator<Jugador> iterator = jugadores.iterator(); iterator.hasNext();)
			cadena.append("\n" + "" + iterator.next());
		return cadena;
	}
}