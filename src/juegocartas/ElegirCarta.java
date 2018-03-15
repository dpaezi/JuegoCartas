package juegocartas;

import java.util.*;

/**
 * ElegirCarta --- aplicación que a traves de un menu con dos opciones selecciona
 * 1) Una carta al azar
 * 2) Mano de 5 cartas
 * Contando la aparición de pares y tríos.
 * @author Danny Páez Ibaceta
 */
public class ElegirCarta {

	public static void main(String[] args) {
		
		// Crear Menu en consola.
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int opcion = 0;
		
		while(true) {
			System.out.println("Menú principal");
			System.out.println("1) Una carta al azar");
			System.out.println("2) Mano de 5 cartas");
			System.out.println("3) Salir");
			System.out.print("Ingrese el numero de su elección: ");
			
			// Si el valor no es un número entero, no asigna el valor a opcion por lo que
			// opcion es igual a 0 y cae a default en switch.
			try {
				opcion = Integer.parseInt(input.nextLine());
			} catch (NumberFormatException nfe) { }

			switch(opcion) {
				
				case 1:
					unaCarta();
					break;
				
				case 2:
					cincoCartas();
					break;
					
				case 3:
					System.exit(0);
			        break;
			        
				default:
					System.out.println("Opción inválida! Ingrese un número(1-3)");
					System.out.println();
					break;
			}
		}
	}
	
	/**
	 * Selecciona una carta de la baraja y la imprime en pantalla
	 */
	public static void unaCarta() {
		// Genera nueva baraja
		Baraja baraja = new Baraja();
		Carta carta = baraja.sacarUnaCarta();
		System.out.println("Usted obtuvo: " + carta.getValor() + " " + carta.getColor());
		System.out.println();
	}
	
	/**
	 * Selecciona cinco cartas de la baraja e imprime las cinco cartas y si 
	 * ocurrieron pares o trios.
	 */
	public static void cincoCartas() {
		Map<Integer, Integer> cuenta = new HashMap<Integer, Integer>();
		// Genera nueva baraja
		Baraja baraja = new Baraja();
		List<Carta> cartas = baraja.sacarCincoCartas();
		
		System.out.println("Usted obtuvo: ");
		
		for (Carta carta : cartas) {
			// Imprime en pantalla cada una de las cinco cartas.
			System.out.println(carta.getValor() + " " + carta.getColor());	
		}
		
		cuenta = buscaParesTrios(cartas);
		
		// Imprime en pantalla las apariciones(cuenta) de 2 o 3 veces, de algún valor de carta.
				for (Map.Entry<Integer, Integer> entry : cuenta.entrySet()) {
					switch(entry.getValue()) {
					
						case 2:
							System.out.println("Par de " + entry.getKey());				
							break;
							
						case 3:
							System.out.println("Trío de " + entry.getKey());				
							break;
							
						default:
							break;
					}
				}
				
				System.out.println();
	}
	
	public static Map<Integer, Integer> buscaParesTrios(List<Carta> cartas) {
		Map<Integer, Integer> cuenta = new HashMap<Integer, Integer>();
		
		for (Carta carta : cartas) {
			// Imprime en pantalla cada una de las cinco cartas.
			//System.out.println(carta.getValor() + " " + carta.getColor());	
			
			// Organiza en un diccionario en un par(valor, cuenta), con la key valor de la carta y cuenta el número de apariciones.
			int key = carta.getValor();
			
			if (cuenta.containsKey(key)) {
				cuenta.put(key, cuenta.get(key) + 1);
			} else {
				cuenta.put(key, 1);
			}
			
		}
		
		return cuenta;
	}

}
