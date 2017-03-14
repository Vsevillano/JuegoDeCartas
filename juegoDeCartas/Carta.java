package juegoDeCartas;
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
public class Carta {
	/**
	 * Palo de la enumeracion Palos
	 */
	private Palos palos;
	/**
	 * Figura de la enumeracion Figuras
	 */
	private Figuras figuras;

	/**
	 * Constructor de la carta con figura y palo
	 * 
	 * @param figuras
	 * @param palos
	 */
	public Carta(Figuras figuras, Palos palos) {
		setFiguras(figuras);
		setPalos(palos);
	}
	
	/**
	 * 
	 * @param palos
	 */
	private void setPalos(Palos palos) {
		this.palos = palos;
	}

	/**
	 * 
	 * @param figuras
	 */
	private void setFiguras(Figuras figuras) {
		this.figuras = figuras;
	}

	/**
	 * Obtiene el palo
	 * 
	 * @return el palo de la carta
	 */
	private Palos getPalos() {
		return palos;
	}

	/**
	 * Obtiene la figura
	 * 
	 * @return figura de la carta
	 */
	private Figuras getFiguras() {
		return figuras;
	}

	/**
	 * Obtiene el valor de la carta
	 * 
	 * @return
	 */
	double getValor() {
		return figuras.getValor();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getFiguras() + " de " + getPalos();
	}
}
