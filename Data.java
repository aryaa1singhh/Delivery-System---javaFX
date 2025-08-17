package studentprovidedfiles.coursework1152;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Scanner;

/**
 * Class to hold data that is added to the "database".
 * You may add methods to this class.
 */
public class Data {

    /**
     * Attributes to save our data to the "database"
     */
    private static ArrayList<SortingOffice> sortingOffices = new ArrayList<>();
    private static Stack<Deliverable> deliverables = new Stack<>();
    private static Stack<Deliverable> processedDeliverables = new Stack<>();

    /**
     * Method to return the Stack of deliverables
     *
     * @return stack of deliverables
     */
    public static Stack<Deliverable> getDeliverables() {
        return deliverables;
    }

    /**
     * Method to return the sorting offices
     *
     * @return array list of sorting offices
     */
    public static ArrayList<SortingOffice> getSortingOffices() {
        return sortingOffices;
    }

    /**
     * Method to return the completed deliverables.
     *
     * @return stack of completed deliverables.
     */
    public static Stack<Deliverable> getProcessedDeliverables() {
        return processedDeliverables;
    }

    /**
     * DO NOT EDIT ANY CODE ABOVE THIS COMMENT. You may need to write additional methods below.
     **/


    /**
     * method to find office using postcodes
     * @param postcode
     * @return
     */
    public static SortingOffice findSortingOffice(String postcode) {

        for (SortingOffice office : SortingOffice.offices) {
            if (office.getPostcodes().contains(postcode)) {
                return office;
            }
        }
        return null;
    }

    /**
     * method to find office using ID
     * @param id
     * @return
     */
    public static SortingOffice findSortingOffice(int id) {
        for (SortingOffice office : SortingOffice.offices) {
            if (office.getId() == id) {
                return office;
            }
        }
        return null;
    }

    /**
     * method to read the sorting office file and being able to extract data from
     * the file regarding each attribute and concert them to the actual type
     */
    public static void readingSortingOffices() {
        File sortingFile = new File("sortingOffices.txt");
        try {
            Scanner scanner = new Scanner(sortingFile);
            while (scanner.hasNext()) {
                String[] attributes = scanner.nextLine().split(" ");


                int X = Integer.parseInt(attributes[0]);
                int Y = Integer.parseInt(attributes[1]);
                String country = attributes[2];
                boolean internationals = Boolean.parseBoolean(attributes[3]);

                ArrayList<String> postcodes = new ArrayList<>();
                for (int i = 4; i < attributes.length; i++) {
                    postcodes.add(attributes[i]);
                }

                SortingOffice sortingOffice = new SortingOffice(X, Y, country, internationals, postcodes);
                sortingOffices.add(sortingOffice);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * method to read the deliverable file and being able to extract data
     * for each attribute and convert them to the type of the actual attribute
     */
    public static void readingDeliverables() {
        File sortingFile = new File("deliverables.csv");
        try {
            Scanner scanner = new Scanner(sortingFile);
            while (scanner.hasNext()) {
                String[] attributes = scanner.nextLine().split(",");

                String sender = attributes[0];
                String recipient = attributes[1];
                String itemType = attributes[2];

                SortingOffice senderOffice = findSortingOffice(sender);
                SortingOffice recipientOffice = findSortingOffice(recipient);


                switch (itemType) {
                    case "Produce":
                        Produce produce = new Produce(senderOffice, recipientOffice);

                        deliverables.push(produce);
                        break;

                    case "Plant":
                        Plant plant = new Plant(senderOffice, recipientOffice);

                        deliverables.push(plant);
                        break;
                    case "NonPerishable":
                        double weight = Double.parseDouble(attributes[3]);
                        boolean fragile = Boolean.parseBoolean(attributes[4]);

                        NonPerishable nonPerishable = new NonPerishable(senderOffice, recipientOffice, weight, fragile);
                        deliverables.push(nonPerishable);
                        break;

                    default:
                        System.out.println("Type not found");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * method to add connection between sorting offices based on certain condition to make delivery of good possible
     */
    public static void addConnections() {

        for (SortingOffice office1 : getSortingOffices()) {

            for (SortingOffice office2 : getSortingOffices()) {


                if (office1.isInternational() && office2.isInternational() && (office1 != office2)) {
                    if (!office1.getConnections().contains(office2)) {
                        office2.addConnection(office1);
                        office1.addConnection(office2);
                    }
                } else if (office1.isInternational() && !office2.isInternational()
                        && office1.getCountry().equals(office2.getCountry()) && (office1 != office2)) {
                    if (!office1.getConnections().contains(office2)) {
                        office2.addConnection(office1);
                        office1.addConnection(office2);
                    }

                }
            }
        }
    }


    public static void printReceipts() {

    }




}

