package juegocartas;

/**
 * Clase Carta
 */
public class Carta {
	
	private Color color;
	private int valor;
	
	/**
	 * Constructor
	 * 
	 * @param color color de la carta
	 * @param valor valor de la carta
	 */
	public Carta(Color color, int valor) {
		this.setColor(color);
		this.setValor(valor);
	}
	
	// Setters y getters
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
}
