//most likely give them this class as well - maybe just documentation and .class file

/**
 * A wrapper for row and column location
 * 
 * @author Elizabeth
 * 
 */
public class Location {
    private int row;
    private int col;

    /**
     * Creates a new location from the specified row and column
     * 
     * @param row  the row of the location
     * @param col  the column of the location
     */
    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Returns the row position of the location
     * 
     * @return row position
     */
    public int getRow() {
        return row;
    }

    /**
     * Returns the column position of the location
     * 
     * @return column position
     */
    public int getCol() {
        return col;
    }

    /**
     * Moves the location by 1 unit in the specified direction
     * 
     * @param direction   the direction in which to move
     */
    public void moveByDirection(int direction) {
        switch (direction) {
        case Movable.NORTH:
            row--;
            break;
        case Movable.SOUTH:
            row++;
            break;
        case Movable.EAST:
            col++;
            break;
        case Movable.WEST:
            col--;
            break;
        }
    }

    /**
     * Returns a Location object that is an exact copy of the current location.
     * 
     * @return the duplicate Location
     */
    public Location clone() {
        return new Location(this.row, this.col);
    }

    @Override
    public boolean equals(Object object) {
        boolean isEqual = false;

        if (object instanceof Location) {
            isEqual = ((Location) object).row == row
                    && ((Location) object).col == col;
        }
        return isEqual;
    }

    @Override
    public String toString() {
        return "Row: " + row + " Col: " + col;
    }
}
