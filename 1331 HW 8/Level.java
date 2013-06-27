import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// give them documentation and .class file

/**
 * The class Level contains a representation of a level for a game of pacman.
 * 
 * A method for parsing a level from a text file is provided. The file must contain the 
 * appropriate characters for the level.
 * 
 * 'x' represents walls, '.' represents pellets, 'p' represents pacman, 'c' represents cherries,
 * and 'g' represents the ghost spawn point - a sample level file is show in level.txt
 * 
 * The Level shows what the game level looks like when created, but it will not be updated
 * during play.It contains information on the locations of the walls, the origin point of pacman,
 * the ghost spawn, and the locations of all the pellets and cherries when the level begins.
 * 
 * @author Elizabeth
 *
 */

public class Level {
    private final char PACMAN_ORIGIN = 'p';
    private final char GHOST_ORIGIN = 'g';
    private final char WALL = 'x';
    private final char CHERRY = 'c';
    private final char PELLET = '.';
    
    private char[][] tiles;
    private Location pacmanOrigin;
    private Location ghostOrigin;
 
    /**
     * Constructs a level based off of the specified 2D char array
     * 
     * @param tiles the char array that defines the level
     */
    public Level(char[][] tiles){
        this.tiles = tiles;
       
        for(int row=0; row<tiles.length; row++){
            for(int col=0; col<tiles[row].length; col++){
                if(tiles[row][col] == PACMAN_ORIGIN){
                    pacmanOrigin = new Location(row,col);
                }
                else if(tiles[row][col] == GHOST_ORIGIN){
                    ghostOrigin = new Location(row,col);
                }
            }
        }
    }
    
  
    /**
     * Determines whether the given location is a valid location in the level.
     * 
     * A location is valid if it falls within the bounds of the level and 
     * is not a wall.
     * 
     * @param location the location to be checked
     * @return whether or not the location is valid
     */
    public boolean isValidLocation(Location location){
        if(location.getRow()<tiles.length-1 && location.getCol()<tiles[0].length-1)
            return tiles[location.getRow()][location.getCol()]!= WALL;
        else
            return false;
    }
    
    /**
     * Returns the number of rows in the level
     * 
     * @return number of rows
     */
    public int getNumRows(){
        return tiles.length;
    }
    
    /**
     * Returns the number of columns in the level
     * 
     * @return number of columns
     */
    public int getNumCols(){
        return tiles[0].length;
    }
    
    /**
     * Returns pacman's original location on the level
     * 
     * @return pacman's original location
     */
    public Location getPacmanOrigin(){
        return pacmanOrigin;
    }
    
    /**
     * Returns the ghost's original location on the level
     * 
     * @return the ghost's original location
     */
    public Location getGhostOrigin(){
        return ghostOrigin;
    }
    
    /**
     * Returns an array of the initial locations of each pellet on the level 
     * 
     * @return the initial locations of all pellets on the level
     */
    public Location[] getPelletLocations(){
        ArrayList<Location> pelletLocations = new ArrayList<Location>();
        for(int row=0; row<tiles.length; row++){
            for (int col=0; col<tiles[row].length; col++){
                if(tiles[row][col] == PELLET){
                    pelletLocations.add(new Location(row,col));
                }
            }
        }
        
        return pelletLocations.toArray(new Location[pelletLocations.size()]);
    }
    
    /**
     * Returns an array of the initial locations of each cherry on the level
     * 
     * @return the initial locations of all the cherries on the level
     */
    public Location[] getCherryLocations(){
        ArrayList<Location> cherryLocations = new ArrayList<Location>();
        for(int row=0; row<tiles.length; row++){
            for (int col=0; col<tiles[row].length; col++){
                if(tiles[row][col] == CHERRY){
                    cherryLocations.add(new Location(row,col));
                }
            }
        }
        
        return cherryLocations.toArray(new Location[cherryLocations.size()]);
    }
    
    /**
     * Returns the 2D char array that represents the level contained in the
     * specified file. Each row of the file corresponds to a row of the level.
     * All levels are assumed to be rectangular (your file does not contain a
     * rectangluar level, ArrayIndexOutOfBounds exceptions will occur in the level
     * created from this 2D array)
     * 
     * @param filename the name of the file containing the level
     * @return the 2D char array representing the level
     */
    public static char[][] parseLevel(String filename){
        ArrayList<char[]> level = new ArrayList<char[]>();
        Scanner scan = null;
        try {
            scan = new Scanner(new FileInputStream(filename));
        } catch (FileNotFoundException e) {
           
            e.printStackTrace();
        }
        
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            System.out.println(line);
            level.add(line.toCharArray());
        }
        
        char[][] l = new char[level.size()][];
        for(int i=0; i<level.size(); i++){
            l[i] = level.get(i);
        }
        return l;
    }
}
