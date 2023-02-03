package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Account;
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
            String sql = "Insert INTO account (username, password) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while(resultSet.next()){
            int generate_accounts_id = (int) resultSet.getLong(1);
            return new Account(generate_accounts_id, account.getUsername(), account.getPassword());
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
        
    }
    
    // insert into the usernames and password 

    public Account ProcessUserLogins(Account accounts){
        Connection connection = ConnectionUtil.getConnection();
        try {
            //Write SQL logic here
            String sql = 
        
            return new Account (generate_accounts_id, accounts.getName());
        }
    }catch(SQLException e){
        System.out.println(e.getMessage());
    }
    return null;
    }
}

