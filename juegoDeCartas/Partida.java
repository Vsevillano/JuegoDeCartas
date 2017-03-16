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
	private static final double PUNTUACION_MAXIMA = 7.5;
	private Baraja baraja;
	private Jugadores participantes = new Jugadores();

	/**
	 * Constructor de la partida
	 * 
	 * @param jugadores
	 * 
	 * @param jugadores
	 *            Array con el numero de jugadores
	 */
	public Partida(Jugadores participantes) {
		baraja = new Baraja();
		this.participantes = participantes;
	}

	/**
	 * Saca una carta de la baraja
	 * 
	 * @return
	 * @throws NoQuedanCartasException
	 */
	Carta sacarCarta() {
		return baraja.darMano();
	}

	/**
	 * Indica el valor de la carta sacada
	 * 
	 * @return
	 */
	double valorCarta() {
		return baraja.valorCartaSacada();
	}

	/**
	 * Muestra la lista de participantes
	 * 
	 * @return
	 */
	StringBuilder mostrarParticipantes() {
		return participantes.mostrarJugadores();
	}

	/**
	 * Devuelve el numero de participantes
	 * 
	 * @return
	 */
	int sizeParticipantes() {
		return participantes.size();
	}

	/**
	 * Puntuacion maxima
	 * 
	 * @return
	 */
	double puntuacionMax() {
		return PUNTUACION_MAXIMA;
	}

	/**
	 * Comprueba el ganador de la partida
	 * 
	 * @return
	 * @throws JugadorNoExisteException
	 * @throws NombreInvalidoException 
	 */
	String comprobarGanador() throws JugadorNoExisteException, NombreInvalidoException {
		String ganador = participantes.get(0).toString();

		for (int i = 1; i < participantes.size(); i++) {
			if (participantes.get(i - 1).getPuntuacion() <= puntuacionMax()) {
				if (participantes.get(i).getPuntuacion() >= participantes.get(i - 1).getPuntuacion()
						&& participantes.get(i).getPuntuacion() < puntuacionMax())
					ganador = participantes.get(i).toString();
			} else
				ganador = "Nadie gana.";
		}
		actualizarRanking(ganador);
		return ganador;
	}

	/**
	 * 
	 * @param ganador
	 * @throws JugadorNoExisteException
	 * @throws NombreInvalidoException
	 */
	private void actualizarRanking(String ganador) throws JugadorNoExisteException, NombreInvalidoException {
		for (int i = 0; i < participantes.size(); i++) {
				participantes.get(i).incPartidasJugadas();
				participantes.get(i).incPartidasGanadas();
				participantes.get(i).incPartidasPerdidas();
			}
		
	}

	/**
	 * Juega la partida
	 * 
	 * @throws NoQuedanCartasException
	 * @throws JugadorNoExisteException
	 * @throws NombreInvalidoException 
	 */
	void jugar() throws JugadorNoExisteException, NombreInvalidoException {
		do {
			for (int i = 0; i < participantes.size(); i++) {
				do {
					System.out.println("Turno del jugador " + participantes.get(i).getNombre());
					System.out.println(sacarCarta());
					participantes.get(i).setPuntuacion(participantes.get(i).getPuntuacion() + valorCarta());
					System.out.println("Puntuacion: " + participantes.get(i).getPuntuacion());
				} while (participantes.get(i).getPuntuacion() <= puntuacionMax()
						&& DeseaContinuar.continuar("¿Quiere carta? s/n"));
			}
			System.out.println("Ganador: " + comprobarGanador());
		} while (DeseaContinuar.continuar("¿Jugamos otra los mismos? s/n"));
		// Vaciamos la lista de participantes 
		participantes.clear();
	}
}
