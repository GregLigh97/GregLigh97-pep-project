package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Message;
import Util.ConnectionUtil;

public class MessagesDAO{


public List<Message>getAllMessages(){
    Connection connection = ConnectionUtil.getConnection();
    List<Message> messages = new ArrayList<>();
    try {
       
        String sql =;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, Message.getAllMessages());
        preparedStatement.setString(2, Message.getAllMessages());
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        while(resultSet.next()){
        int generate_message_id = (int) resultSet.getLong(1);
        return new Message(generate_messages_id, account.getUsername(), account.getPassword());
    }
}catch(SQLException e){
    System.out.println(e.getMessage());
}


public Message getAccountByaccount_id(int account_id){
    Connection connection = ConnectionUtil.getConnection();
    try {
        String sql =;
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.executeUpdate();
        ResultSet pkeyResultSet = preparedStatement.getGeneratedKeys();
        if(pkeyResultSet.next()){
        int generated_messages_id = (int) pkeyResultSet.getLong(1);
        return new Messages (generated_message_id, message.getName());
    }
}catch(SQLException e){
    System.out.println(e.getAllMessages());
}
return null;
}
}