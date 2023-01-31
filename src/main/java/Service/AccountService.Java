


public class AccountService {
 public AccountDAO accountDAO;


 public AccountService(){
 accountDAO = new AccountDAO();
}
// Constructor for Account Service when AccountDAO is provided.

public AccountService(AccountDAO accountDAO){

}

