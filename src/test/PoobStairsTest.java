package test;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import domain.PoobStairs;
import domain.Casillas;
import domain.Escalera;
import domain.PoobStairsExceptions;
import domain.Table;

/**
 * @author MILLO
 *
 */
class PoobStairsTest {

	private static PoobStairs juego, guardado;
	private static Casillas[][] tablero, tableGuardado;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		juego = new PoobStairs("Sebastian", "Johann", "black", "yellow", 10, 12, 0, false, null, 5);
		tablero = (Table.getInstance(10)).getGameTable();
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
	void shouldMoveOnSnakesAndLadders() {
		ArrayList<int[][]> escaleras = (Table.getInstance(10)).getFinalLadder();
		ArrayList<int[][]> serpientes = (Table.getInstance(10)).getFinalSnake();
		int[][] pos = escaleras.get(3);
		Casillas ca = tablero[pos[0][0]][pos[0][1]];
		Casillas fin = tablero[pos[1][0]][pos[1][1]];
		int inicio = ca.getPosition();
		int finals = fin.getPosition();
		try {
			juego.mover(inicio, false, "");
		} catch (PoobStairsExceptions e) {
			e.printStackTrace();
		}
		int[] posiciones = juego.getPositions();
		assertEquals(posiciones[0], finals);
	}

	@Test
	void shouldWin() {
		try {
			juego.mover(100, false, null);
		} catch (PoobStairsExceptions e) {
			assertEquals(PoobStairsExceptions.WIN, e.getMessage());
		}
	}
}
