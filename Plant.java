package studentprovidedfiles.coursework1152;

/**
 * class for plants which are perishable items and implement the deliverables
 */
public class Plant extends Perishable implements Deliverable{
    public Plant(SortingOffice sender, SortingOffice recipient) {
        super(sender, recipient);
    }

    /**
     * method to tell us under which condition do the plants expire
     * @param sortingOffice
     */
    @Override
    public void process(SortingOffice sortingOffice) {
        locations.add(sortingOffice);

        if(locations.size() > 3){
            this.expired = true;
        }

    }

    /**
     * to tell us if the plants have expired or not
     * @return
     * if the item is expired
     */
    public boolean isExpired() {
        return expired;
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
     * getter for the recipient
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
     * method to get the receipts
     * @return
     * receipts
     */
    @Override
    public String getReceipt() {
       String result;
       if(expired == true){
           result = "WARNING! Expired Plant delivered to " + getRecipient().getLocation();
       }else{
           result = "Plant delivered to " + getRecipient().getLocation();
       }
       return result;
    }
}
