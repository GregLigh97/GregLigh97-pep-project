

public class MessagesService{
public MessagesDAO messageDAO;


public MessagesService(){
messageDAO = new MessagesDAO();
}

public MessagesService(MessagesDAO messageDAO){
this.Messages = messageDAO;
}
public List<Messages>getAllMessages() {
    return null;
}
public Messages addMessages(Messages message) {
return MessagesDAO.getAllMessages();
}