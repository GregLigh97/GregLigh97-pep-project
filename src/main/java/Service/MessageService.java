package Service;
import java.util.List;

import DAO.MessagesDAO;


public class MessageService{
public MessagesDAO messagesDAO;


public MessageService(){
messagesDAO = new MessagesDAO();
}

public MessagesService(MessagesDAO messageDAO){
this.messagesDAO = MessageDAO(;
}
public List<Messages>getAllMessages() {
    return MessagesDAO.getAllMessages();
}
public Messages addMessages(Messages messages) {
return MessagesDAO.addMessages();
}