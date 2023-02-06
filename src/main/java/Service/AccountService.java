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

    public AccountService(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }
  //  public Account CreateNewUsers(Account account) {
  //  return AccountDAO.CreateNewUsers();
    }

   // public Account ProcessUserLogins(Account accounts) {
  //       return AccountDAO.ProcessUserLogins();
        
    


