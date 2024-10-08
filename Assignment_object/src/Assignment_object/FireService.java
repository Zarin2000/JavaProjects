package Assignment_object;

public class FireService {

    private int vehicleID;
    private String vehicleType;
    private String location;
    private boolean isAvailable;
    private int numberOfCrew;

    private static int totalVehicles = 0;

    public FireService(int vehicleID, String vehicleType, String location, boolean isAvailable, int numberOfCrew) {
        this.vehicleID = vehicleID;
        this.vehicleType = vehicleType;
        this.location = location;
        this.isAvailable = isAvailable;
        this.numberOfCrew = numberOfCrew;
        totalVehicles++;
    }

    public FireService(int vehicleID, String vehicleType, String location) {
        this(vehicleID, vehicleType, location, true, 4); 
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getNumberOfCrew() {
        return numberOfCrew;
    }

    public void setNumberOfCrew(int numberOfCrew) {
        this.numberOfCrew = numberOfCrew;
    }

    public static int getTotalVehicles() {
        return totalVehicles;
    }

    public void dispatch() {
        if (isAvailable) {
            System.out.println("Vehicle " + vehicleID + " is dispatched to " + location + " with " + numberOfCrew + " crew members.");
            isAvailable = false;
        } else {
            System.out.println("Vehicle " + vehicleID + " is not available for dispatch.");
        }
    }

    public static void main(String[] args) {

        FireService vehicle1 = new FireService(101, "Fire Truck", "Downtown");
        FireService vehicle2 = new FireService(102, "Ambulance", "Suburb", false, 2);
        FireService vehicle3 = new FireService(103, "Rescue Vehicle", "Industrial Area");
        FireService vehicle4 = new FireService(104, "Water Tanker", "Rural Village", true, 3);
        FireService vehicle5 = new FireService(105, "Hazmat Unit", "Chemical Plant",true,6);

        vehicle1.dispatch();
        vehicle2.dispatch();
        vehicle3.setAvailable(true);
        vehicle4.setNumberOfCrew(5);
        vehicle5.dispatch();

        System.out.println("Total vehicles: " + FireService.getTotalVehicles());
    }
}
