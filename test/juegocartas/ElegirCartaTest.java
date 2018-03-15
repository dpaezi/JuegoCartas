package juegocartas;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ElegirCartaTest {

	@Test
	void encuentraPares() {
		// Arrange
		ElegirCarta elegiCarta = new ElegirCarta();
		Baraja baraja = new Baraja();
		
		// Act
		List<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new Carta(Color.Diamante, 1));
		cartas.add(new Carta(Color.Pica, 10));
		cartas.add(new Carta(Color.Pica, 7));
		cartas.add(new Carta(Color.Corazon, 5));
		cartas.add(new Carta(Color.Trebol, 7));
		
		// Assert
		assertThat(ElegirCarta.buscaParesTrios(cartas).get(7).intValue(), equalTo(2));
	}
	
	@Test
	void encuentraTrios() {
		// Arrange
		ElegirCarta elegiCarta = new ElegirCarta();
		Baraja baraja = new Baraja();
		
		// Act
		List<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new Carta(Color.Diamante, 1));
		cartas.add(new Carta(Color.Pica, 10));
		cartas.add(new Carta(Color.Pica, 7));
		cartas.add(new Carta(Color.Corazon, 7));
		cartas.add(new Carta(Color.Trebol, 7));
		
		// Assert
		assertThat(ElegirCarta.buscaParesTrios(cartas).get(7).intValue(), equalTo(3));
	}


}
