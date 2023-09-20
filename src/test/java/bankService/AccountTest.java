package bankService;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import bankService.exceptions.InsufficientFundsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import org.mockito.BDDMockito.Then;

import bankService.exceptions.InvalidAmountException;

public class AccountTest {

    /**
     *  The system should be able to store information on a new Account using valid data.
     */
    @Test
    public void creatingAccountWithValidData_StoresSpecifiedData() {
        // Arrange
        Customer customer;
        Account account;
        // Act
        customer =  Mockito.spy(new Customer("Mickey Mouse", "Disneyland", "Mickey@Disneyland.com"));
        account = Mockito.spy(new Account(customer, 200.0, 2974802746820L) {
            @Override
            public void withdraw(double amount) throws InsufficientFundsException {

            }
        });
        // Then
        Assertions.assertNotNull(account);
        Assertions.assertEquals(account.getAccountNumber(), 2974802746820L,"The account number has not the value expected");
        Assertions.assertEquals(account.getBalance(), 200.0);
        Assertions.assertEquals(account.getOwner().getAddress(), "Disneyland","The Customer Address has not the value expected");
        Assertions.assertEquals(account.getOwner().getEmail(),"Mickey@Disneyland.com" ,"The Customer Name has not the value expected");
        Assertions.assertEquals(account.getOwner().getName(), "Mickey Mouse","The Customer Name has not the value expected");
        //Assertions.assertEquals(account.getOwner(), customer, "The Customer has not the value expected");
    }
    
    
    @Test
    public void depositAmount_IncreaseBalanceAmount() throws InvalidAmountException {
        // Arrange
        Customer customer;
        Account account;

        customer =  Mockito.spy(new Customer("Mickey Mouse", "Disneyland", "Mickey@Disneyland.com"));
        account = Mockito.spy(new Account(customer, 200.0, 2974802746820L) {
            @Override
            public void withdraw(double amount) throws InsufficientFundsException {

            }
        });

        //Act
        account.deposit(100.00);

        //Assert
        Assertions.assertEquals(300.00, account.getBalance(), "El balance no es el esperado");
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, -100.0})
    public void depositInvalidAmount_RaiseInvalidAmountException(double amount) throws InvalidAmountException {
        // Arrange
        Customer customer;
        Account account;

        customer =  Mockito.spy(new Customer("Mickey Mouse", "Disneyland", "Mickey@Disneyland.com"));
        account = Mockito.spy(new Account(customer, 200.0, 2974802746820L) {
            @Override
            public void withdraw(double amount) throws InsufficientFundsException {

            }
        });

        //Act y Assert
        Assertions.assertThrows(InvalidAmountException.class, () -> account.deposit(amount));
    }


}
