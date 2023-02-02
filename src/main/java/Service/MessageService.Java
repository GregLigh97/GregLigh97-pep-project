

public class MessagesService{
public MessagesDAO messagesDAO;


public MessagesService(){
messagesDAO = new MessagesDAO();
}

public MessagesService(MessagesDAO messageDAO){
this.Messages = messageDAO;
}
public List<Messages>getAllMessages() {
    return MessagesDAO.getAllMessages();
}
public Messages addMessages(Messages messages) {
return MessagesDAO.addMessages()
}