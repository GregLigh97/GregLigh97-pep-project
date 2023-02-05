package Service;
import java.util.List;

import DAO.AccountDAO;
import DAO.MessageDAO;
import Model.Message;


public class MessageService{
public MessageDAO messagesDAO;


public MessageService(){
messagesDAO = new MessageDAO();
}
public MessageService(MessageDAO messageDAO){
   this.messageDAO = MessageDAO;
}
public List<Message>InsertNewMessages(){
    return AccountDAO.InsertNewMessages();
}
public List<Message> GetAllMessage(){
    return messagesDAO.GetAllMessages(message_id);
}
public List<Message>GetMessagebyId(){
    return messagesDAO.GetMessagebyId(message_id);
}
}