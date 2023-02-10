package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Account;
import Model.Message;
import Util.ConnectionUtil;



public class AccountDAO {

    /**
    * TODO: Create new user regristrations and logins 
    *
    */
    public Account CreateNewUsers(Account account){
        Connection connection = ConnectionUtil.getConnection();
        try {
            //Write SQL logic here
            String sql = "Insert INTO account(username, password) values (?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()){
            int generate_account_id = (int) resultSet.getLong(1);
            return new Account(generate_account_id, account.getUsername(), account.getPassword());
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
       return null;
}  
    public Account ProcessUserLogins(Account accounts){
        Connection connection = ConnectionUtil.getConnection();
        try {
            //Write SQL logic here
            String sql = "Select * From Account Where username and password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
              //write preparedStatement's setInt method here.
              preparedStatement.setString(1, "username");
              preparedStatement.setString(2, "password");
              ResultSet rs = preparedStatement.executeQuery();
              while(rs.next()){
            Account account = new Account(rs.getString("username"), 
                                          rs.getString("password"));
            return account;                
        }
    }catch(SQLException e){
        System.out.println(e.getMessage());
    }
    return null;
}
}

