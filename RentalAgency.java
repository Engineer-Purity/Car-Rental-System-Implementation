import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RentalAgency {
    private List<Car> carList;
    private HashMap<Customer, Car> rentals;

    public RentalAgency() {
        carList = new ArrayList<>();
        rentals = new HashMap<>();
    }

    public void addCar(Car car) {
        carList.add(car);
    }

    public boolean rentCar(Customer customer, String licensePlate) {
        for (Car car : carList) {
            if (car.getLicensePlate().equals(licensePlate) && !car.isRented()) {
                car.rent();
                rentals.put(customer, car);
                return true;
            }
        }
        return false; // Car not available
    }

    public boolean returnCar(Customer customer) {
        Car rentedCar = rentals.get(customer);
        if (rentedCar != null) {
            rentedCar.returnCar();
            rentals.remove(customer);
            return true;
        }
        return false; // No car rented
    }

    public List<Car> getAvailableCars() {
        List<Car> available = new ArrayList<>();
        for (Car car : carList) {
            if (!car.isRented()) {
                available.add(car);
            }
        }
        return available;
    }
}
