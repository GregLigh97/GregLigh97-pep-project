


public class AccountService {
    public AccountDAO accountDAO;


    public AccountService(){
        accountDAO = new AccountDAO();
    }
    // Constructor for Account Service when AccountDAO is provided.

    public AccountService(AccountDAO accountDAO){
        this.Account = accountDAO;
    }
    public List<Account>CreateNewUsers() {
        return AccountDAO.CreateNewUsers();
    }

    public Account ProcessUserLogins(Account accounts) {
        int account_id = message.getAccountByaccount_id
        if(username = !null && password == 4 && Account == null){
            String jsonStringToBeReturned = om.writeValueAsString;
            ctx.result(jsonStringToBeReturned);
            ctx.status(200);
        }else{
            return ctx.status(400);
        }
    }
}
