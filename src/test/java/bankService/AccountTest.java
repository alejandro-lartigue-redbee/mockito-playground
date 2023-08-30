package bankService;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.BDDMockito.Then;

import bankService.exceptions.InvalidAmountException;

public class AccountTest {
    
    
    @Test
    public void depositAmount_IncreaseBalanceAmount() throws InvalidAmountException {
        // Arrange
        Customer customer;
        customer = new Customer("Mickey Mouse", "Disneyland", "Mickey@Disneyland.com");
       // Account account = new Account(customer, 100.0, 1234567);
        Account accountMock = Mockito.mock(Account.class);
        //when(accountMock.getBalance()).thenReturn(600.0);
        doThrow(InvalidAmountException.class).when(accountMock).deposit(124);
        //doNothing().when(accountMock).balance;
        // Act
        accountMock.deposit(123);
   
        // Then
        Assertions.assertNotNull(customer);
        Assertions.assertEquals(0, accountMock.getBalance());
        //Assertions.assertEquals(223.0, account.getBalance());
        //asdsadasdasdas
    }



}
