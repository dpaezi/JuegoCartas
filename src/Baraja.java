import java.util.*;

/**
 * Clase Baraja --- crea una lista con 52 cartas iniciales de las cuales va sacando cartas
 * aleatoriamente para ser ocupadas en la aplicación.
 */
public class Baraja {

	List<Carta> baraja = new ArrayList<>();
	Random rand = new Random();
	int size = 52;
	
	/**
	 * Constructor
	 */
	public Baraja() {
		generarBaraja();
	}
	
	/**
	 *  Genera una baraja con 52 cartas(4 colores, 13 valores)
	 */
	void generarBaraja() {	
		for (Color color : Color.values()) {
			for (int valor = 1; valor < 14; valor++) {
				Carta carta = new Carta(color, valor);
				baraja.add(carta);
			}
		}
	}
	
	/**
	 * Saca una carta de la baraja, tamaño de baraja disminuye en 1
	 * 
	 * @return Carta Retorna la carta seleccionada de la baraja.
	 */
	public Carta sacarUnaCarta() {
		// numero entero aleatorio entre 0 y size(no incluido). 
		int r = rand.nextInt(size);	
		
		// remueve la carta seleccionada y disminuye el tamaño de la baraja en uno
		Carta carta = baraja.remove(r);
		size--;
		
		return carta;
	}
	
	/**
	 *  Saca 5 cartas de la baraja, una a la vez a travez del metodo {@link sacarUnaCarta}
	 *  
	 *  @return List Retorna una lista con 5 cartas selecionadas al azar.
	 */
	public List<Carta> sacarCincoCartas() {
		List<Carta> cartas = new ArrayList<>(); 
		
		for (int i = 0; i < 5; i++) {
			cartas.add(sacarUnaCarta());
		}
		
		return cartas;
	}
	
}
