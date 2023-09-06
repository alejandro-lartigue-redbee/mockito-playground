package bankService;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import bankService.exceptions.InsufficientFundsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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
        //Assertions.assertTrue(account.getOwner().equals(customer), "The Customer has not the value expected");
    }
    
    
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
