You will need to design and create your own DAO classes from scratch. 
You should refer to prior mini-project lab examples and course material for guidance.


public class Account {

    /**
    * TODO: Create new user regristrations and logins 
    *
    */
    public List<Account>CreateNewUsers(){
        Connection connection = ConnectionUtil.getConnection();
        List<Account> accounts = new ArrayList<>();
        try {
            //Write SQL logic here
            String sql = "Select * From Account";
            Account accounts = new Account(rs.getInt("username"),  rs.getString("password"));
            Account.add(accounts);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
           ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Account accounts = new Account(rs.getInt("account_id"), rs.getString("username"),
                rs.getString("password"));
                accounts.add(accounts);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return accounts;
        
    }
    
    // insert into the usernames and password 

    public Account ProcessUserLogins(Account accounts){
        Connection connection = ConnectionUtil.getConnection();
        try {
            //Write SQL logic here
            String sql = 
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // Write Prepared Statements here
            preparedStatement.setString(1, account.ProcessUserLogins())
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

