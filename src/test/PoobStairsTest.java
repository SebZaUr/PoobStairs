
package test;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import domain.PoobStairs;
import domain.Casillas;
import domain.PoobStairsExceptions;
import domain.Table;

/**
 * @author MILLO
 *
 */
class PoobStairsTest {

	private static PoobStairs juego;
	private static Casillas[][] tablero;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		juego = new PoobStairs("Sebastian", "Johann", "black", "yellow", 10, 12, 0, false, null);
		Table.getInstance(10);
		tablero = Table.getGameTable();
	}

	@Test
	void shouldCreateExactNumberOfSpecialBox() {
		int numEspaciales = 0;
		for (Casillas[] i : tablero) {
			for (Casillas j : i) {
				if (j.getType() != "NCasilla" && j.getType() != "Escalera" && j.getType() != "Serpiente") {
					numEspaciales++;
				}

			}

		}
		assertEquals(numEspaciales, (12 * 100) / 100);

	}

	@Test
	void shouldMoveThePlayerThatIsInTurn() {
		int[] posiciones = juego.getPositions();
		juego.mover(5);
		int[] posicionesDespues = juego.getPositions();
		assertEquals(posiciones[1], posicionesDespues[1]);
		juego.mover(3);
		posiciones = juego.getPositions();
		assertEquals(posiciones[0], posicionesDespues[0]);
	}

	@Test
	void shouldNotMoveOutTheTable() {
		int[] posiciones = juego.getPositions();
		juego.mover(110);
		int[] posicionesDespues = juego.getPositions();
		assertEquals(posiciones[0], posicionesDespues[0]);
		juego.mover(120);
		posiciones = juego.getPositions();
		assertEquals(posiciones[1], posicionesDespues[1]);
		posiciones = juego.getPositions();
		juego.mover(-5);
		posicionesDespues = juego.getPositions();
		assertEquals(posiciones[0], posicionesDespues[0]);
		juego.mover(-3);
		posiciones = juego.getPositions();
		assertEquals(posiciones[1], posicionesDespues[1]);
	}

	@Test
	void shouldMoveOnSnakesAndLadders() {
		ArrayList<int[][]> escaleras = Table.getFinalLadder();
		ArrayList<int[][]> serpientes = Table.getFinalSnake();
		int[][] escalera1 = escaleras.get(0);
		int inicio = 0;
		int finals = 0;
		if (escalera1[0][1] % 2 == 0) {
			inicio = escalera1[0][0] * 10 + 10 - escalera1[0][1];
		} else {
			inicio = escalera1[0][0] * 10 + escalera1[0][1];
		}
		if (escalera1[1][1] % 2 == 0) {
			finals = escalera1[1][0] * 10 + 10 - escalera1[1][1];
		} else {
			finals = escalera1[1][0] * 10 + escalera1[1][1];
		}
		juego.mover(inicio);
		int[] posiciones = juego.getPositions();
		System.out.println(finals);
		assertEquals(posiciones[0], finals);
	}
}
