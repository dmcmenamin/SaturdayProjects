package day7.dmcme.tablet;

import java.util.ArrayList;
public class TabletsAreUs {

    public static void main(String[] args) {
// simulating a few tablets
        Tablet t1 = new Tablet("Apple", "iPad", 338.94, false, 10.2,
                "10.2 inch Retina display A10 Fusion chip Up to 10 hours of battery life");
        Tablet t2 = new Tablet("Apple", "iPad Air", 449.00, false, 10.5,
                "10.5 inch 10.5-inch Retina display with ProMotion, True Tone and wide colour, " +
                        "Up to 20 hours of battery life ");
        Tablet t3 = new Tablet("Google", "Fire", 79.99, true, 8,
                        "8 inch display 10 hours of battery life");
        Tablet t4 = new Tablet("Samsung", "Galazy Tab", 180.00, true, 10.1,
                        "10.1 inch  Entertainment for All: Designed with the whole family in mind, " +
                                "the Galaxy Tab A has what it takes to keep everyone happy. 5 hours battery.  ");
        Tablet t5 = new Tablet("Vankyo", "MatrixPad", 69.99, true, 7,
                        "7-inch display Full-Featured Android Tablet with Eye Care " +
                                "for Kids Up to 4 hours of battery life");
// adding to an arraylist
        ArrayList <Tablet> tabletsInStock = new ArrayList<>();
        tabletsInStock.add(t1);
        tabletsInStock.add(t2);
        tabletsInStock.add(t3);
        tabletsInStock.add(t4);
        tabletsInStock.add(t5);

// show all in stock
        for (Tablet tablet : tabletsInStock) {
            tablet.allDetails();
        }

// exercising a few searches
// 1. all screen sizes > 10 inches in size
        System.out.println("Tablets Size Search");
        for (Tablet tablet: tabletsInStock) {
            if(searchTabletSizeGreaterThan(tablet, 10)) {
                tablet.allDetails();
            }
        }
// 2. all Apple products (over priced!)
        System.out.println("Apple Tablet Search");
        for (Tablet tablet: tabletsInStock) {
            if (checkIfAppleTablet(tablet)) {
                tablet.allDetails();
            }
        }
// 3. all Android tablets
        System.out.println("Android Tablet Search");
        for (Tablet tablet: tabletsInStock) {
            if (checkForAndroidTablet(tablet)) {
                tablet.allDetails();
            }
        }
// 4. note search .. e.g. by key word search (note this is case sensitive)
        System.out.println("Search Notes for Case Sensitive word");
        for (Tablet tablet: tabletsInStock) {
            if (performNoteSearch(tablet, "display")){
                tablet.allDetails();
            }
        }
    }
// create all the searches as methods here (make them all static)
    public static boolean searchTabletSizeGreaterThan(Tablet tablet, int size) {
        return tablet.getSize() >= size;
    }

    public static boolean checkIfAppleTablet(Tablet tablet) {
        return tablet.getManufacturer().equals("Apple");
    }

    public static boolean checkForAndroidTablet(Tablet tablet) {
        return tablet.isAndroid();
    }

    public static boolean performNoteSearch(Tablet tablet, String note) {
        return tablet.getNotes().contains(note);
    }
}

