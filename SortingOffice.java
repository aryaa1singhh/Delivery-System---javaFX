package studentprovidedfiles.coursework1152;

import java.util.ArrayList;

/**
 * Class to represent a Sorting Office object.
 * You will heavily edit this class and therefore no further comments have been added.
 * Ensure you add comments when submitting.
 */

public class SortingOffice {

    private int id;
    private static int nextId = 1;
    private int X;
    private int Y;
    private String location;
    private String country;
    private boolean international;
    protected ArrayList<String> postcodes;
    private ArrayList<SortingOffice> connections;

    public static ArrayList<SortingOffice> offices = new ArrayList<>();

    /**
     * constructor for the sorting office class
     * @param X
     * @param Y
     * @param country
     * @param international
     * @param postcodes
     */
    public SortingOffice(int X, int Y, String country, boolean international,ArrayList<String> postcodes){
        this.X = X;
        this.Y = Y;
        this.country =country;
        this.international = international;
        this.postcodes = postcodes;
        this.connections =new ArrayList<SortingOffice>();
        this.id = nextId++;
        this.location = "X"+X+"Y"+Y+"C"+country;
        addingOffice();
    }

    /**
     * setter for ID
     * @param id
     */
    public void setId(int id){
        this.id = id;
    }

    /**
     * setter of X
     * @param X
     */
    public void setX(int X){
        this.X = X;
    }

    /**
     * setter for Y
     * @param Y
     */
    public void setY(int Y){
        this.Y = Y;
    }

    /**
     * setter for country
     * @param country
     */
    public void setCountry(String country){
        this.country = country;
    }

    /**
     * getter for X
     * @return
     */
    public int getX() {
        return X;
    }

    /**
     * getter for Y
     * @return
     */
    public int getY() {
        return Y;
    }

    /**
     * getter for ID
     * @return
     */
    public int getId(){
        return id;
    }

    /**
     * tells us if the office is in international location or not
     * @return
     */
    public boolean isInternational() {
        return international;
    }

    /**
     * getter for connection
     * @return
     */
    public ArrayList<SortingOffice> getConnections() {
        return connections;
    }

    /**
     * getter for location
     * @return
     */
    public String getLocation(){
        return  location;
    }

    /**
     * getter for the arraylist of postcodes
     * @return
     */
    public ArrayList<String> getPostcodes(){
        return postcodes;
    }

    /**
     * adder method for offices
     */
    public void addingOffice(){
        offices.add(this);
    }

    /**
     * getter method for country
     * @return
     */
    public String getCountry(){
        return country;
    }


    /**
     * method to add connection to sorting offices
     * @param sortingOffice
     */
    public void addConnection(SortingOffice sortingOffice){
        connections.add(sortingOffice);
    }



    @Override
/**
 * to string method for the sorting office class
 */
    public String toString(){
        String postCode = "";
        for(String postcode : postcodes){
            postCode += postcode;
        }
        String output =  location + international + postCode;
        return output;
    }

}
