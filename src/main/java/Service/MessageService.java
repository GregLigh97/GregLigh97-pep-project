package Service;
import DAO.MessageDAO;


public class MessageService{
public MessageDAO messagesDAO;


public MessageService(){
messagesDAO = new MessageDAO();
}
}