import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class RentalAgencyTest {
    private RentalAgency agency;
    private Customer customer1;
    private Customer customer2;
    private Car car1;
    private Car car2;

    @BeforeEach
    public void setUp() {
        agency = new RentalAgency();
        car1 = new Car("ABC123", "Toyota Camry");
        car2 = new Car("XYZ789", "Honda Accord");
        agency.addCar(car1);
        agency.addCar(car2);
        customer1 = new Customer("Alice", "C001");
        customer2 = new Customer("Bob", "C002");
    }

    @Test
    public void testRentCarSuccessfully() {
        assertTrue(agency.rentCar(customer1, "ABC123"));
        assertTrue(car1.isRented());
    }

    @Test
    public void testRentCarAlreadyRented() {
        agency.rentCar(customer1, "ABC123");
        assertFalse(agency.rentCar(customer2, "ABC123"));
    }

    @Test
    public void testReturnCarSuccessfully() {
        agency.rentCar(customer1, "ABC123");
        assertTrue(agency.returnCar(customer1));
        assertFalse(car1.isRented());
    }

    @Test
    public void testReturnCarNoRental() {
        assertFalse(agency.returnCar(customer2));
    }

    @Test
    public void testGetAvailableCars() {
        agency.rentCar(customer1, "ABC123");
        List<Car> availableCars = agency.getAvailableCars();
        assertEquals(1, availableCars.size());
        assertEquals("XYZ789", availableCars.get(0).getLicensePlate());
    }
}

