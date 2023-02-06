package Service;
import java.util.List;

import DAO.AccountDAO;
import DAO.MessageDAO;
import Model.Message;


public class MessageService{
public MessageDAO messageDAO;


public MessageService(){
messageDAO = new MessageDAO();
}
public MessageService(MessageDAO messageDAO){
   this.messageDAO = messageDAO;
}
public Message InsertNewMessages(Message message){
    return messageDAO.InsertNewMessages(message);
}
//public Message GetAllMessage(int message_id){
  //  return messageDAO.GetAllMessages(message_id);

//public List<Message>GetMessagebyId(){
  //  return messageDAO.GetMessagebyId();
}
