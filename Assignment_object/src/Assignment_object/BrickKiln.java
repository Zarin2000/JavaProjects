package Assignment_object;

public class BrickKiln {

    // Attributes
    private int kilnID;
    private String location;
    private double capacity;
    private boolean isActive;
    private static int totalKilns = 0;

    // Constructor overloading
    public BrickKiln(int kilnID, String location, double capacity, boolean isActive) {
        this.kilnID = kilnID;
        this.location = location;
        this.capacity = capacity;
        this.isActive = isActive;
        totalKilns++;
    }

    // Constructor chaining
    public BrickKiln(int kilnID, String location, double capacity) {
        this(kilnID, location, capacity, true);
    }

    // Getter and Setter methods
    public int getKilnID() {
        return kilnID;
    }

    public void setKilnID(int kilnID) {
        this.kilnID = kilnID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    // Static method to get total kilns
    public static int getTotalKilns() {
        return totalKilns;
    }

    // Non-static function for firing bricks
    public void fireBricks() {
        if (isActive) {
            System.out.println("Kiln " + kilnID + " at " + location + " is firing bricks.");
        } else {
            System.out.println("Kiln " + kilnID + " at " + location + " is not active.");
        }
    }

    // Main method
    public static void main(String[] args) {
        // Creating kiln objects
        BrickKiln kiln1 = new BrickKiln(1, "Hasan Brick Works", 50000.0, true);
        BrickKiln kiln2 = new BrickKiln(2, "Lota Brick Factory", 75000.0);
        BrickKiln kiln3 = new BrickKiln(3, "Ma Bricks Ltd.", 60000.0, false);
        BrickKiln kiln4 = new BrickKiln(4, "MNO Brick Co.", 80000.0);
        BrickKiln kiln5 = new BrickKiln(5, "Jamal Bricks", 55000.0, true);

        // Object manipulation
        kiln1.fireBricks(); // Active kiln
        kiln2.setActive(false);
        kiln2.fireBricks(); // Inactive kiln
        kiln3.fireBricks(); // Inactive kiln
        kiln4.setCapacity(70000.0);
        kiln4.fireBricks();
        System.out.println("Total Kilns: " + BrickKiln.getTotalKilns());
    }
}
