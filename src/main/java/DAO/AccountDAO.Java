You will need to design and create your own DAO classes from scratch. 
You should refer to prior mini-project lab examples and course material for guidance.


public class Account {

/**
* TODO: Get all user regristrations and logins 
*
*/
public List<Account>getAllAccounts(){
Connection connection = ConnectionUtil.getConnection();
List<Account> accounts = new ArrayList<>();
try {
    //Write SQL logic here
    String sql = ;
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    ResultSet rs = preparedStatement.executeQuery();
    while(rs.next()){
    Account accounts = new Account(rs.getInt("Username")),  rs.getString("Password"));
    Account.add(accounts);
  }
}catch(SQLException e){
    System.out.println(e.getMessage());
}
 return accounts;
}
}
// insert into the usernames and password 



public Account insertAccount(Account accounts){
    Connection connection = ConnectionUtil.getConnection();
    try {
        String sql =;
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.executeUpdate();
        ResultSet pkeyResultSet = preparedStatement.getGeneratedKeys();
        if(pkeyResultSet.next()){
        int generated_accounts_id = (int) pkeyResultSet.getLong(1);
        return new Account (generated_accounts_id, accounts.getName());
    }
}catch(SQLException e){
    System.out.println(e.getMessage());
}
return null;
}
}

