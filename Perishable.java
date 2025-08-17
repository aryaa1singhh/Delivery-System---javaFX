package studentprovidedfiles.coursework1152;

import java.util.ArrayList;

/**
 * the class is for perishable items which implements deliverables
 */
public class Perishable implements Deliverable{

    protected SortingOffice sender;
    protected SortingOffice recipient;
    protected boolean expired;
    protected ArrayList<SortingOffice> locations;

    /**
     * constructor for the perishable class
     * @param sender
     * @param recipient
     */
    public Perishable(SortingOffice sender, SortingOffice recipient){
        this.sender = sender;
        this.recipient = recipient;
        this.expired = false;
        this.locations = new ArrayList<>();
    }


    /**
     * process
      * @param sortingOffice
     */
    @Override
    public void process(SortingOffice sortingOffice) {

    }

    /**
     * getter for sender
     * @return
     * the sender
     */
    @Override
    public SortingOffice getSender() {
        return sender;
    }

    /**
     * getter for recipients
     * @return
     * the recipients
     */
    @Override
    public SortingOffice getRecipient() {
        return recipient;
    }

    /**
     * getter for expired
     * @return
     * tells us if it expired or not
     */
    public boolean isExpired() {
        return expired;
    }

    /**
     * setter for sender
     * @param office
     */
    public void setSender(SortingOffice office){
        this.sender = office;
    }

    /**
     * setter for recipient
     * @param office
     */
    public void setRecipient(SortingOffice office){
        this.recipient = office;
    }

    /**
     * setter for expired
     * @param expired
     */
    public void setExpired(boolean expired){
        this.expired = expired;
    }


    public ArrayList<SortingOffice> getLocations() {
        return locations;
    }

    public void addLocations(SortingOffice office){
        locations.add(office);
    }


    /**
     * method to get receipts
     * @return
     * the receipt
     */
    @Override
    public String getReceipt() {
        return "";
    }
}
