package Service;
import java.util.List;

import org.eclipse.jetty.util.security.Password;

import com.fasterxml.jackson.databind.ObjectMapper;

import DAO.AccountDAO;
import Model.Account;
import io.javalin.http.Context;



public class AccountService extends Account{
private AccountDAO accountDAO;

public AccountService() 
{
    accountDAO = new AccountDAO();
}
// Constructor for Account Service when AccountDAO is provided.

public AccountService(AccountDAO accountDAO)
{
this.accountDAO = accountDAO;
}

public Account addAccount(Account account)
{
    if(account.username != "" && account.password.length() >= 4){
        return accountDAO.CreateNewUsers(account);
    }
    return null;

}
public Account PostLogins(String username, String password)
{
   
     return accountDAO.ProcessUserLogings(username, password);
    }  
    

}

