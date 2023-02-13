package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Message;
import Util.ConnectionUtil;

public class MessageDAO{

public Message InsertNewMessages(Message message){
Connection connection = ConnectionUtil.getConnection();
try {
    String sql = "insert into message(posted_by, message_text, time_posted_epoch) values (?,?,?);";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    
    preparedStatement.setInt(1, message.getPosted_by());
        preparedStatement.setString(2, message.getMessage_text());
        preparedStatement.setLong(3, message.getTime_posted_epoch());
        preparedStatement.executeUpdate();
        ResultSet pkeyResultSet = preparedStatement.getGeneratedKeys();

        if(pkeyResultSet.next()){
            if(pkeyResultSet.next()){
        int generated_message_id = (int) pkeyResultSet.getLong(1);
        return new Message(generated_message_id, message.getPosted_by(), message.getMessage_text(), message.getTime_posted_epoch());
        }
    }}catch (Exception e) {
       System.out.println(e.getMessage());
    }
    return null;
}
   









}