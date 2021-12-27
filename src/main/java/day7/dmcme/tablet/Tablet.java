package day7.dmcme.tablet;

public class Tablet {

    private String manufacturer;
    private String model;
    private double price;
    private boolean android;
    private double size;
    private String notes;

    public Tablet(String manufacturer, String model, double price, boolean android, double size, String notes) {
        this.setManufacturer(manufacturer);
        this.setModel(model);
        this.setPrice(price);
        this.setAndroid(android);
        this.setSize(size);
        this.setNotes(notes);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAndroid() {
        return android;
    }

    public void setAndroid(boolean android) {
        this.android = android;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
        double DEFAULT_MINIMUM_SCREEN_SIZE = 5.0;
        double DEFAULT_MAXIMUM_SCREEN_SIZE = 21.0;
        if (size < DEFAULT_MINIMUM_SCREEN_SIZE || size > DEFAULT_MAXIMUM_SCREEN_SIZE) {
            System.out.println("Invalid Screen size provided - seeting to default: " + DEFAULT_MAXIMUM_SCREEN_SIZE);
            this.size = DEFAULT_MAXIMUM_SCREEN_SIZE;
        }
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
        int MAXIMUM_NOTE_SIZE = 250;
        if (notes.length() > MAXIMUM_NOTE_SIZE) {
            System.out.println("Note size is truncated at " + MAXIMUM_NOTE_SIZE);
            this.notes = notes.substring(0,250);
        }
    }

    public void allDetails() {
        System.out.printf
                ("Tablet Details __________________ \n" +
                "Manufacturer: %s %n" +
                "Model : %s %n" +
                "Price : %4.2f %n" +
                "Android: %b %n" +
                "Size: %2.1f %n" +
                "Notes: %s %n%n",
                        this.getManufacturer(), this.getModel(),
                        this.getPrice(), this.isAndroid(), this.getSize(),
                        this.getNotes());
    }
}
