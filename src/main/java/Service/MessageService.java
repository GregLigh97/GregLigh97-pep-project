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
if(message.getMessage_text() == ""){
return null;
}return messageDAO.InsertNewMessages(message);
}
public List<Message>getAllMessage(){
    return messageDAO.GetAllMessages();
}
public Message getMessageById(int message_id){
   // Message messages =messageDAO.getMessageById(message_id);
    if(messageDAO.getMessageById(message_id)!= null){
    return messageDAO.getMessageById(message_id);
}
    return null;
}
public Message deletebyid(int message_id){
    Message message=messageDAO.getMessageById(message_id);
    messageDAO.DeleteMessagebyId(message_id);
    if(message==null){
     return null;
    }return message;
}
public Message updateMessages(int message_id, Message message){
    if(messageDAO.getMessageById(message_id) != null)
    {
   return messageDAO.UpdatebyId(message_id, message);
    }
   return null;
}       
public List<Message>GetMeesagesbyAcccountid(int posted_by){
 return messageDAO.GetMessagesbyAccountId(posted_by);
}
}

