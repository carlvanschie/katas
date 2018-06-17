package vanschie.gameoflife;

/**
 * Created by carl on 14/06/17.
 */
public class GameOfLife {
    public static final int MAX_SIZE = 5;

    private Grid grid = new Grid();

    public GameOfLife(int... aliveCoords) {
        for(int i = 0; i < aliveCoords.length; i+=2) {
            grid.setStatus(aliveCoords[i], aliveCoords[i + 1], true);
        }
    }

    public void generate() {
        Grid generatedGrid = new Grid();
        for(int xIndex = 0; xIndex < MAX_SIZE; xIndex++) {
            for (int yIndex = 0; yIndex < MAX_SIZE; yIndex++) {
                boolean cellStatus = grid.getStatus(xIndex, yIndex);

                int countAliveNeighbours = countNeighbours(xIndex, yIndex);
                if(countAliveNeighbours < 2) {
                    cellStatus = false;
                } else if(countAliveNeighbours > 3) {
                    cellStatus = false;
                } else if(countAliveNeighbours == 3) {
                    cellStatus = true;
                }
                generatedGrid.setStatus(xIndex, yIndex, cellStatus);
            }
        }
        grid = generatedGrid;
    }

    private int countNeighbours(int xIndex, int yIndex) {
        int count = 0;
        count += isCellAlive(xIndex - 1, yIndex - 1) ? 1 : 0;
        count += isCellAlive(xIndex - 1, yIndex) ? 1 : 0;
        count += isCellAlive(xIndex - 1, yIndex + 1) ? 1 : 0;
        count += isCellAlive(xIndex, yIndex - 1) ? 1 : 0;
        count += isCellAlive(xIndex, yIndex + 1) ? 1 : 0;
        count += isCellAlive(xIndex + 1, yIndex - 1) ? 1 : 0;
        count += isCellAlive(xIndex + 1, yIndex) ? 1 : 0;
        count += isCellAlive(xIndex + 1, yIndex + 1) ? 1 : 0;
        return count;
    }

    private boolean isCellAlive(int xIndex, int yIndex) {
        int tmpXIndex = xIndex;
        int tmpYIndex = yIndex;

        if(xIndex == -1) { tmpXIndex = MAX_SIZE - 1; }
        if(yIndex == -1) { tmpYIndex = MAX_SIZE - 1; }
        if(xIndex == MAX_SIZE) { tmpXIndex = 0; }
        if(yIndex == MAX_SIZE) { tmpYIndex = 0; }
        return grid.getStatus(tmpXIndex,tmpYIndex);
    }

    public Grid getGrid() {
        return grid;
    }

    public class Grid {
        private boolean [][] grid = new boolean[MAX_SIZE][MAX_SIZE];

        public Grid() {
            for(int xIndex = 0; xIndex < MAX_SIZE; xIndex++) {
                for(int yIndex = 0; yIndex < MAX_SIZE; yIndex++) {
                    grid[xIndex][yIndex] = false;
                }
            }
        }

        public void setStatus(int xCoord, int yCoord, boolean status) {
            grid[xCoord][yCoord] = status;
        }

        public boolean getStatus(int xCoord, int yCoord) {
            return grid[xCoord][yCoord];
        }
    }
}
