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
public Message GetAllMessage(){
   return messageDAO.GetAllMessages();
}
public Message GetMessagebyId(int message_id){
    return messageDAO.GetMessagebyId(message_id);
}
public Message DeleteMessagebyId(int message_id){
    return messageDAO.DeleteMessagebyId(message_id);
}
public Message UpdatebyId(int message_id){
    return messageDAO.UpdatebyId(message_id);
}
public Message GetMessagebyUserid(int message_id){
    return messageDAO.GetMessagebyId(message_id);
}
}