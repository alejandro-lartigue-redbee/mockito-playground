package bankService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class CustomerTest {

    /**
     *  The system should be able to store information on a new customer using valid data.
     */
    @Test
    public void creatingCustomerWithValidData_StoresSpecifiedData() {
        // Arrange
        Customer customer;
        // Act
        customer =  Mockito.spy(new Customer("Mickey Mouse", "Disneyland", "Mickey@Disneyland.com"));
        // Then
        Assertions.assertNotNull(customer);
        Assertions.assertEquals(customer.getAddress(), "Disneyland");
        Assertions.assertEquals(customer.getEmail(), "Mickey@Disneyland.com");
        Assertions.assertEquals(customer.getName(), "Mickey Mouse");
    }

    /**
     *  The system should be update customer information using valid data.
     */
    @Test
    public void updateCustomerInfoWithValidData_CustomerDataUpdated() {
        // Arrange
        Customer customer;
        // Act
        customer =  Mockito.spy(new Customer("Mickey Mouse", "Disneyland", "Mickey@Disneyland.com"));
        // Then
        customer.updateAddress("MarvelLand");
        Assertions.assertEquals(customer.getAddress(), "MarvelLand","The method updateAddress() Failed");
        customer.updateName("Minie Mouse");
        Assertions.assertEquals(customer.getName(), "Minie Mouse","The method updateAdress() Failed");
        customer.updateEmail("minie@Disneyland.com");
        Assertions.assertEquals(customer.getEmail(), "minie@Disneyland.com","The method updateEmail() Failed");
    }


}