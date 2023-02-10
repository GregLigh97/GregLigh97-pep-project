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
        String sql = "Insert INTO Message(posted_by, message_text, time_posted_epoch, ) Values (?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, message.getPosted_by());
        preparedStatement.setString(2, message.getMessage_text());
        preparedStatement.setLong(3, message.getTime_posted_epoch());
        preparedStatement.executeUpdate();
        return message;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;

}
  public Message GetAllMessages(){
    Connection connection = ConnectionUtil.getConnection();
    try {
        String sql = "Select * From Message";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.executeUpdate();
        ResultSet pkeyResultSet = preparedStatement.getGeneratedKeys();
        while(pkeyResultSet.next()){
        Message message = new Message(pkeyResultSet.getInt("message_id"),
                    sql, pkeyResultSet.getInt("message_text"));
        Message.addMessage(message);

    }
}catch(SQLException e){
    System.out.println(e.getMessage());
}
return null;
}
{
}


public Message GetMessagebyId(int message_id){
    Connection connection = ConnectionUtil.getConnection();
    try {
        String sql = "Select * From Messages Where message_id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //write preparedStatement's setString and setInt methods here.

        ResultSet pkeyResultSet = preparedStatement.getGeneratedKeys();
        while(pkeyResultSet.next()){
        Message message = new Message(pkeyResultSet.getInt("message_id"),
        sql, pkeyResultSet.getInt("message_id"));
        return message;
    }
}catch(SQLException e){
    System.out.println(e.getMessage());
}
return null;
}
{
}
public Message DeleteMessagebyId(int message_id){
    Connection connection = ConnectionUtil.getConnection();
    try {
        String sql = "Delete From Message Where message_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //write preparedStatement's setString and setInt methods here.
         preparedStatement.setString(1, "message_id");
         preparedStatement.executeUpdate();

    }catch(SQLException e){
    System.out.println(e.getMessage());
    }
    return null;
}

public Message UpdatebyId(int message_id, Message message){
    Connection connection = ConnectionUtil.getConnection();
    try {
        //Write SQL logic here
        String sql = "UPDATE Message SET message_id = ?, account_id = ?, message_text = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //write PreparedStatement setString and setInt methods here.
        
        preparedStatement.setString(3, "message_text" );
        preparedStatement.setString(2, "account_id");
        preparedStatement.setInt(1, message_id);

        preparedStatement.executeUpdate();

   }catch(SQLException e){
    System.out.println(e.getMessage());
   }
   return message;
}

public Message GetMessagebyUserid(int account_id){
    Connection connection = ConnectionUtil.getConnection();
    try {
        //Write SQL logic here
        String sql = "Select * FROM Message Where account_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, account_id);

         ResultSet rs = preparedStatement.executeQuery();
         while(rs.next()){
        Message message = new Message(rs.getInt("account_id"),
                          rs.getString("message_text"),
                          rs.getInt("message_id"));
        return message;
     }
    }catch(SQLException e){
        System.out.println(e.getMessage());
    }
    return null;
}
}

