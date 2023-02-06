package Service;
import java.util.List;

import DAO.AccountDAO;
import Model.Account;




public class AccountService {
    AccountDAO accountDAO;


    public AccountService(){
        accountDAO = new AccountDAO();
    }
    // Constructor for Account Service when AccountDAO is provided.

    
   public Account CreateNewUsers(Account account) {
    return accountDAO.CreateNewUsers(account);
    }
    public Account ProcessUserLogins(Account accounts) {
    return accountDAO.ProcessUserLogins(accounts);
}
}
    
           


