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
    public List<Account>CreateNewUsers() {
        return AccountDAO.CreateNewUsers(Account);
    }

    public Account ProcessUserLogins(Account accounts) {
        int account_id = message.getAccountByaccount_id
        if(Username = !null && password == 4 && accountDAO == null){
            String jsonStringToBeReturned = om.writeValueAsString;
            ctx.result(jsonStringToBeReturned);
            ctx.status(200);
        }else{
            return ctx.status(400);
        }
    }
}
