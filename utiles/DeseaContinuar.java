package utiles;

public class DeseaContinuar {
	/**
	 * Devuelve true en funcion de S y false en funcion de N
	 * 
	 * @return true si es una tecla diferente de n o N
	 */
	public static boolean continuar(String msj) {
		switch (Teclado.leerCaracter(msj)) {
		case 'N':
		case 'n':
			return false;
		default:
			return true;
		}
	}
	// char c;
	// do {
	// c = Character.toUpperCase(Teclado
	// .leerCaracter("¿Desea continuar? (S/N)"));
	// } while (c != 'S' && c != 'N');
	// return c == 'S' ? true : false;

}
