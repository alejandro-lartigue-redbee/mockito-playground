package bankService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CustomerTest {

    /**
     *  The system should be able to store information on a new customer using valid data.
     *  Scenario:
     *  1. Given I create a new customer named Mickey Mouse
     *  2. When I initialize the customer object with valid details.
     *  3. Then Mickey's information should be stored in the system.
     */
    @Test
    public void creatingCustomerWithValidData_StoresSpecifiedData() {
        // Arrange
        Customer customer;
        // Act
        customer = new Customer("Mickey Mouse", "Disneyland", "Mickey@Disneyland.com");
        // Then
        Assertions.assertNotNull(customer);
        Assertions.assertEquals(customer.getAddress(), "Disneyland");
        Assertions.assertEquals(customer.getEmail(), "Mickey@Disneyland.com");
        Assertions.assertEquals(customer.getName(), "Mickey Mouse");
    }
}