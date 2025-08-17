package studentprovidedfiles.coursework1152;

/**
 * the class is for non-perishable item which implement  deliverable
 */
public class NonPerishable implements Deliverable{

    private SortingOffice sender;
    private SortingOffice recipient;
    private double weight;
    private boolean fragile;
    private boolean broken;

    /**
     * constructor for the NonPerishable class
     * @param sender
     * @param recipient
     * @param weight
     * @param fragile
     */
    public NonPerishable(SortingOffice sender, SortingOffice recipient, double weight, boolean fragile){
        this.sender = sender;
        this.recipient = recipient;
        this.weight= weight;
        this.fragile=fragile;
        this.broken = false;
    }

    @Override
/**
 * a method which tell us in what conditions will the item be broken
 */
    public void process(SortingOffice sortingOffice) {
        if(sortingOffice != null && sortingOffice.getLocation() != null &&sortingOffice.getLocation().equals("X560Y320CScotland")){
            this.broken = true;
        }
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
     * getter for recipient office
     * @return
     *  the recipient
     */
    @Override
    public SortingOffice getRecipient() {
        return recipient;
    }



    /**
     * method to tell us if the item is fragile or not
     * @return
     * shows us if the item is fragile or not
     */
    public boolean isFragile() {
        return fragile;
    }

    /**
     * method to tell us if the item is broken or not
     * @return
     * tells us if the item is broken
     */
    public boolean isBroken() {
        return broken;
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
     * setter for weight
     * @param weight
     */
    public void setWeight(double weight){
        this.weight = weight;
    }

    /**
     * setter for fragile
      * @param fragile
     * shows if the item is fragile
     */
    public void setFragile(boolean fragile){
        this.fragile = fragile;
    }

    /**
     * method which helps us in printing the receipt based on the fact if item is broken or not
     * @return
     * the receipts
     */
    @Override
    public String getReceipt() {
        String result;
       if(broken == true){
           result = "Fragile Non-Perishable delivered to " + getRecipient().getLocation() + "Item is broken. " +
                   "Non-Perishable delivered to " + getRecipient().getLocation();
       }else{
           result = "Fragile Non-Perishable delivered to " + getRecipient().getLocation();
       }
       return result;
    }
}
