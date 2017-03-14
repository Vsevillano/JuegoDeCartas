package juegoDeCartas;

import java.util.ArrayList;
import java.util.Collections;

import juegoDeCartas.excepciones.NoQuedanCartasException;
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
public class Baraja {
	/**
	 * Mano que es sacada al sacar carta
	 */
	private Carta mano;
	/**
	 * Array del tamaño del numero de la baraja
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