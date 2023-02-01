


public class AccountService {
 public AccountDAO accountDAO;


 public AccountService(){
 accountDAO = new AccountDAO();
}
// Constructor for Account Service when AccountDAO is provided.

public AccountService(AccountDAO accountDAO){
this.Account = accountDAO;
}
public List<Account>getAllaccounts() {
    return null;
}

public Account addAccount(Account accounts) {
return AccountDAO.getAllAccounts();
}
