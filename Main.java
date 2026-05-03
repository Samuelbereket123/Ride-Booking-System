import java.util.ArrayList;

class User {
    protected String name;

    User(String name) {
        this.name = name;
    }

    void displayInfo() {
        System.out.println("User: " + name);
    }
}

class Rider extends User {
    private String pickupLocation;

    Rider(String name, String pickupLocation) {
        super(name);
        this.pickupLocation = pickupLocation;
    }

    String getPickupLocation() {
        return pickupLocation;
    }

    @Override
    void displayInfo() {
        System.out.println("Rider: " + name + " | Pickup: " + pickupLocation);
    }
}

class Driver extends User {
    private String carModel;
    private boolean isAvailable;

    Driver(String name, String carModel) {
        super(name);
        this.carModel = carModel;
        this.isAvailable = true;
    }

    boolean isAvailable() {
        return isAvailable;
    }

    void setAvailable(boolean status) {
        isAvailable = status;
    }

    String getName() {
        return name;
    }

    @Override
    void displayInfo() {
        System.out.println("Driver: " + name + " | Car: " + carModel + " | Available: " + isAvailable);
    }
}

class Ride {
    private Rider rider;
    private Driver driver;
    private String status;

    Ride(Rider rider, Driver driver) {
        this.rider = rider;
        this.driver = driver;
        this.status = "ONGOING";
    }

    void completeRide() {
        status = "COMPLETED";
        driver.setAvailable(true);
    }

    void displayRide() {
        System.out.println("Ride -> Rider: " + rider.name + " | Driver: " + driver.getName() + " | Status: " + status);
    }
}

class RideService {
    private ArrayList<Driver> drivers;
    private ArrayList<Ride> rides;

    RideService() {
        drivers = new ArrayList<>();
        rides = new ArrayList<>();
    }

    void addDriver(Driver driver) {
        drivers.add(driver);
    }

    void requestRide(Rider rider) {
        for (Driver driver : drivers) {
            if (driver.isAvailable()) {
                driver.setAvailable(false);
                Ride ride = new Ride(rider, driver);
                rides.add(ride);
                System.out.println("Ride booked with driver: " + driver.getName());
                return;
            }
        }
        System.out.println("No drivers available.");
    }

    void showAllDrivers() {
        for (Driver d : drivers) {
            d.displayInfo();
        }
    }

    void showAllRides() {
        for (Ride r : rides) {
            r.displayRide();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        RideService service = new RideService();

        Driver d1 = new Driver("Abel", "Toyota Vitz");
        Driver d2 = new Driver("Dawit", "Hyundai Elantra");

        service.addDriver(d1);
        service.addDriver(d2);

        Rider r1 = new Rider("Samuel", "Bole");
        Rider r2 = new Rider("Nahom", "Piassa");

        service.showAllDrivers();
        System.out.println("-----");

        service.requestRide(r1);
        service.requestRide(r2);

        System.out.println("-----");

        service.showAllRides();

        System.out.println("-----");

        service.showAllDrivers();
    }
}