package studentprovidedfiles.coursework1152;

/**
 * class sids for produce which are perishable and implements deliverable
 */
public class Produce extends Perishable implements Deliverable {

    private String currentLocation;
    private String trackingLocation;

    /**
     * constructor for the produce class
     * @param sender
     * @param recipient
     */

    public Produce(SortingOffice sender, SortingOffice recipient) {
        super(sender, recipient);
        this.currentLocation = "";
        this.trackingLocation = "";
    }

    /**
     * method to get the current and tracking location of the produce being delivered
     * @param sortingOffice
     */
    @Override
    public void process(SortingOffice sortingOffice) {
       locations.add(sortingOffice);
       currentLocation = sortingOffice.getLocation();
       if(trackingLocation.equals("")){
           trackingLocation = currentLocation;
       }else{
       trackingLocation += "," + currentLocation;
       }
    }

    /**
     * getter for sender
     * @return
     * sender
     */
    @Override
    public SortingOffice getSender() {
        return sender;
    }

    /**
     * getter for recipient
     * @return
     * recipient
     */
    @Override
    public SortingOffice getRecipient() {
        return recipient;
    }

    /**
     * setter for sender
     * @param office
     * the sorting office
     */
    public void setSender(SortingOffice office){
        this.sender = office;
    }

    /**
     * setter for recipient
     * @param office
     * the sorting office
     */
    public void setRecipient(SortingOffice office){
        this.recipient = office;
    }

    /**
     * method to get reciept
     * @return
     * receipts
     */
    @Override
    public String getReceipt() {
        String result;
       if(expired == true){
           result = "WARNING! Expired Produce delivered to" + getRecipient().getLocation() +"Produce route:" + trackingLocation;
       }else{
           result = "Produce delivered to" + getRecipient().getLocation() +"Produce route:" + trackingLocation;
       }
       return result;
    }

}
