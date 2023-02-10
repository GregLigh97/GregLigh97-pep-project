package Service;
import java.util.List;

import org.eclipse.jetty.util.security.Password;

import com.fasterxml.jackson.databind.ObjectMapper;

import DAO.AccountDAO;
import Model.Account;
import io.javalin.http.Context;




public class AccountService {
    AccountDAO accountDAO;


    public AccountService(){
        accountDAO = new AccountDAO();
    }
    // Constructor for Account Service when AccountDAO is provided.

    public AccountService(AccountDAO accountDAO){
    this.accountDAO = accountDAO;

    }


    public Account CreateNewUsers(Account account) {
        return accountDAO.CreateNewUsers(account);
    }


    public Account ProcessUserLogins(Account account) {
        return null;
    }
    }


           


