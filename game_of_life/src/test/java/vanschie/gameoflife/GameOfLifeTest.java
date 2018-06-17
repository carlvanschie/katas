package vanschie.gameoflife;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static vanschie.gameoflife.GameOfLife.MAX_SIZE;

/**
 * Created by carl on 14/06/17.
 */
public class GameOfLifeTest {

    @Test
    public void givenAGameOfLife_whenALiveCellHasLessThanTwoNeighbours_thenItDies() {
        GameOfLife gameOfLife = new GameOfLife(new int[] {2,2, 2,3});
        gameOfLife.generate();
        assertMultipleCoordinates(false, gameOfLife.getGrid(), 2,3, 2,2);
    }

    @Test
    public void givenAGameOfLife_whenALiveCellHasMoreThanThreeNeighbours_thenItDies() {
        GameOfLife gameOfLife = new GameOfLife(new int[] {2,2, 2,3, 2,1, 1,2, 3,2});
        gameOfLife.generate();
        assertEquals(false, gameOfLife.getGrid().getStatus(2,2));
    }

    @Test
    public void givenAGameOfLife_whenALiveCellHasTwoNeighbours_thenItStaysAlive() {
        GameOfLife gameOfLife = new GameOfLife(new int[] {2,2, 2,3, 2,1});
        gameOfLife.generate();
        assertEquals(true, gameOfLife.getGrid().getStatus(2,2));
    }

    @Test
    public void givenAGameOfLife_whenALiveCellHasThreeNeighbours_thenItStaysAlive() {
        GameOfLife gameOfLife = new GameOfLife(new int[] {2,2, 2,3, 2,1, 1,2});
        gameOfLife.generate();
        assertEquals(true, gameOfLife.getGrid().getStatus(2,2));
    }

    @Test
    public void givenAGameOfLife_whenADeadCellHasThreeNeighbours_thenItComesAlive() {
        GameOfLife gameOfLife = new GameOfLife(new int[] {2,3, 2,1, 1,2});
        gameOfLife.generate();
        assertEquals(true, gameOfLife.getGrid().getStatus(2,2));
    }

    @Test
    public void givenAGameOfLifeSpike_whenTwoGenerationsHappen_thenTheGirdIsCorrect() {
        GameOfLife gameOfLife = new GameOfLife(new int[] {2,1, 2,2, 2,3});

        gameOfLife.generate();
        assertMultipleCoordinates(true, gameOfLife.getGrid(), 1,2, 2,2, 3,2);
        assertEquals(3, getCountOfAliveCells(gameOfLife.getGrid()));

        gameOfLife.generate();
        assertMultipleCoordinates(true, gameOfLife.getGrid(), 2,1, 2,2, 2,3);
        assertEquals(3, getCountOfAliveCells(gameOfLife.getGrid()));
    }

    @Test
    public void givenAGameOfLifeSpikeExistingOnTheEdge_whenTwoGenerationsHappen_thenTheGirdIsCorrect() {
        GameOfLife gameOfLife = new GameOfLife(new int[] {2,4, 2,0, 2,1});

        gameOfLife.generate();
        assertMultipleCoordinates(true, gameOfLife.getGrid(), 1,0, 2,0, 3,0);
        assertEquals(3, getCountOfAliveCells(gameOfLife.getGrid()));

        gameOfLife.generate();
        assertMultipleCoordinates(true, gameOfLife.getGrid(), 2,4, 2,0, 2,1);
        assertEquals(3, getCountOfAliveCells(gameOfLife.getGrid()));
    }

    private int getCountOfAliveCells(GameOfLife.Grid grid) {
        int count = 0;
        for(int xIndex = 0; xIndex < MAX_SIZE; xIndex++) {
            for (int yIndex = 0; yIndex < MAX_SIZE; yIndex++) {
                count += grid.getStatus(xIndex, yIndex) ? 1 : 0;
            }
        }
        return count;
    }

    public void assertMultipleCoordinates(boolean value, GameOfLife.Grid grid, int... coordinates) {
        for(int i = 0; i < coordinates.length; i+=2) {
            assertEquals(value, grid.getStatus(coordinates[i],coordinates[i + 1]));
        }
    }
}
