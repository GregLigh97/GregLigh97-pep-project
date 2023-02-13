package Service;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import DAO.MessageDAO;
import Model.Message;


public class MessageService{
public MessageDAO messageDAO;

public MessageService(){
    messageDAO = new MessageDAO();
    }
    public MessageService(MessageDAO messageDAO)
    {
       this.messageDAO = messageDAO;
    }

public Message InsertNewMessages(Message message){
return messageDAO.InsertNewMessages(message);

}










}