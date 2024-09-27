import java.util.List;

public class CarRentalSystem {
    public static void main(String[] args) {
        RentalAgency agency = new RentalAgency();
        
        // Adding cars to the rental agency
        agency.addCar(new Car("ABC123", "Toyota Camry"));
        agency.addCar(new Car("XYZ789", "Honda Accord"));
        
        // Creating customers
        Customer customer1 = new Customer("Alice", "C001");
        Customer customer2 = new Customer("Bob", "C002");
        
        // Renting a car
        System.out.println("Renting a car for Alice: " + agency.rentCar(customer1, "ABC123"));
        
        // Attempting to rent an already rented car
        System.out.println("Renting a car for Bob: " + agency.rentCar(customer2, "ABC123"));
        
        // Displaying available cars
        List<Car> availableCars = agency.getAvailableCars();
        System.out.println("Available cars:");
        for (Car car : availableCars) {
            System.out.println(car.getModel() + " (" + car.getLicensePlate() + ")");
        }
        
        // Returning a car
        System.out.println("Returning car for Alice: " + agency.returnCar(customer1));
        
        // Displaying available cars again
        availableCars = agency.getAvailableCars();
        System.out.println("Available cars after return:");
        for (Car car : availableCars) {
            System.out.println(car.getModel() + " (" + car.getLicensePlate() + ")");
        }
    }
}
