package juegoDeCartas;
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
public enum Figuras {
	/**
	 * Primer valor AS
	 */
	AS(1), 
	/**
	 * Segundo valor DOS
	 */
	DOS(2),
	/**
	 * Tercer valor TRES
	 */
	TRES(3),
	/**
	 * Cuarto valor CUATRO
	 */
	CUATRO(4),
	/**
	 * Quinto valor CINCO
	 */
	CINCO(5),
	/**
	 * Sexto valor SEIS
	 */
	SEIS(6),
	/**
	 * Septimo valor SIETE
	 */
	SIETE(7),
	/**
	 * Octavo valor SOTA
	 */
	SOTA(0.5),
	/**
	 * Noveno valor CABALLO
	 */
	CABALLO(0.5),
	/**
	 * Decimo valor REY
	 */
	REY(0.5);
	/**
	 * Valor en puntos de la carta
	 */
	private final double valor;
	/**
	 * Constructor de la figura
	 * @param valor de la figura
	 */
	private Figuras(double valor) {
		this.valor = valor;
	}
	/**
	 * Obtiene el valor de la figura
	 * @return valor de la figura
	 */
	public double getValor() {
		return valor;
	}
}
