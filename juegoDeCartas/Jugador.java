package juegoDeCartas;

import java.util.regex.Pattern;

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
public class Jugador {
	/**
	 * Cadena para el nombre
	 */
	private String nombre;
	/**
	 * Numero de partidas ganadas
	 */
	private int partidasGanadas;
	/**
	 * Partidas perdidas
	 */
	private int partidasPerdidas;
	/**
	 * Numero de partidas jugadas
	 */
	private int partidasJugadas;
	/**
	 * Puntuacion del jugador
	 */
	private double puntuacion;
	/**
	 * Patron para el nombre
	 */
	private static final Pattern patronNombre = Pattern.compile("([�,'\\-a-zA-Z�������0-9]+\\s?){2,}");

	/**
	 * Determina si el nombre es valido
	 * 
	 * @param nombre
	 * @return
	 */
	private static boolean nombreValido(String nombre) {
		return patronNombre.matcher(nombre).matches();
	}

	/**
	 * Constructor del Jugador
	 * 
	 * @param nombre
	 *            del jugador
	 * @throws NombreInvalidoException
	 */
	public Jugador(String nombre) throws NombreInvalidoException {
		setNombre(nombre);
	}

	/**
	 * Numero de partidas perdidas
	 * 
	 * @return entero con el numero de partidas
	 */
	private int getPartidasPerdidas() {
		return partidasPerdidas;
	}

	/**
	 * Devuelve el numero de partidas perdidas
	 * 
	 * @param partidasPerdidas
	 *            entero
	 */
	private void setPartidasPerdidas(int partidasPerdidas) {
		this.partidasPerdidas = partidasPerdidas;
	}

	/**
	 * Obtiene el nombre del jugador
	 * 
	 * @return
	 */
	String getNombre() {
		return nombre;
	}

	/**
	 * Nombre del jugador
	 * 
	 * @param nombre
	 *            del jugador
	 * @throws NombreInvalidoException
	 */
	private void setNombre(String nombre) throws NombreInvalidoException {
		if (nombreValido(nombre))
			this.nombre = nombre;
		else
			throw new NombreInvalidoException("Nombre no valido");
	}

	/**
	 * Obtiene el numero de partidas ganadas
	 * 
	 * @return numero de partidas perdidas
	 */
	private int getPartidasGanadas() {
		return partidasGanadas;
	}

	/**
	 * Indica el valor de partidas ganadas
	 * 
	 * @param partidasGanadas
	 *            numero de partidas ganadas
	 */
	private void setPartidasGanadas(int partidasGanadas) {
		this.partidasGanadas = partidasGanadas;
	}

	/**
	 * Partidas jugadas
	 * 
	 * @return numero de partidas jugadas
	 */
	private int getPartidasJugadas() {
		return partidasJugadas;
	}

	/**
	 * Partidas jugadas
	 * 
	 * @param partidasJugadas
	 *            entero
	 */
	private void setPartidasJugadas(int partidasJugadas) {
		this.partidasJugadas = partidasJugadas;
	}

	/**
	 * Obtiene la puntuacion del jugador
	 * 
	 * @return puntuacion del jugador
	 */
	double getPuntuacion() {
		return puntuacion;
	}

	/**
	 * Obtiene la puntuacion del jugador
	 * 
	 * @param puntuacion
	 */
	void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}

	/**
	 * Incrementa el numero de partidas ganadas en 1
	 */
	void incPartidasGanadas() {
		setPartidasGanadas(getPartidasGanadas() + 1);
	}

	/**
	 * Incrementa el numero de partidas perdidas
	 */
	void incPartidasPerdidas() {
		setPartidasPerdidas(getPartidasPerdidas() + 1);
	}

	/**
	 * Incrementa el numero de partidas jugadas
	 */
	void incPartidasJugadas() {
		setPartidasJugadas(getPartidasJugadas() + 1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getNombre() + " | PG: " + getPartidasGanadas() + " | PP: " + getPartidasPerdidas() + " | PJ:"
				+ getPartidasJugadas();
	}
}
