package juegoDeCartas;

import java.util.ArrayList;
import java.util.Collections;

import juegoDeCartas.excepciones.NoQuedanCartasException;
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
public class Baraja {
	/**
	 * Mano que es sacada al sacar carta
	 */
	private Carta mano;
	/**
	 * Array del tama�o del numero de la baraja
	 */
	private ArrayList<Carta> baraja = new ArrayList<Carta>();
	
	/**
	 * Constructor de la baraja formada por todas las cartas
	 */
	public Baraja() {
		for (Palos palos : Palos.values()) {
			for (Figuras figuras : Figuras.values()) {
				getBaraja().add(new Carta(figuras, palos));
			}
		}
		Collections.shuffle(baraja);
	}

	/**
	 * Obtiene el array de carta
	 * @return carta
	 */
	private ArrayList<Carta> getBaraja() {
		return baraja;
	}

	/**
	 * Comprueba el mazo y saca una carta valida
	 * @return una carta no null
	 * @throws NoQuedanCartasException 
	 */
	Carta darMano() throws NoQuedanCartasException {
		if (!baraja.isEmpty()) {
			mano = baraja.remove(0);
			return mano;
		} else
			throw new NoQuedanCartasException("No quedan cartas");
	}
	
	/**
	 * Indica el valor de la carta sacada
	 * @return
	 */
	double valorCartaSacada() {
		return mano.getValor();
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "" + baraja;
	}
}