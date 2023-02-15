package Controller;

import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jetty.util.security.Password;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;

import Model.Account;
import Model.Message;
import Service.AccountService;
import Service.MessageService;


public class SocialMediaController{
    AccountService accountService;
    MessageService messageService;

   public SocialMediaController()
   {
         this.accountService = new AccountService();
        this.messageService = new MessageService();
 
   }
    public Javalin startAPI(){
        Javalin app = Javalin.create();
        app.post("/register",this::PostRegisterHandler);
        app.post("/login", this::PostLoginHandler);
        app.post("/messages",this::PostNewMessageHandler);
        app.get("/messages",this::GetAllNewMessageHandler);
        app.get("/messages/{message_id}",this::GetMessagebyIDHandler);
        app.delete("/messages/{message_id}",this::DeleteMessagebyIDHandler);
        app.patch("/messages/{message_id}",this::UpdatebyIDHandler);
        app.get("/account/{account_id}/messages",this::GetMessagesbyAccountIdHandler);
        return app;
    }
    
    private void PostRegisterHandler(Context ctx) throws JsonProcessingException
    {
        ObjectMapper mapper = new ObjectMapper();
        Account Account = mapper.readValue(ctx.body(), Account.class);
        Account newAccount = accountService.addAccount(Account);
        if(newAccount !=null){
            ctx.json(mapper.writeValueAsString(newAccount));
            ctx.status(200); 
        }else{
            ctx.status(400);
        }

    }
    private void PostLoginHandler(Context ctx) throws JsonProcessingException
    {
    ObjectMapper om = new ObjectMapper();
    Account account = om.readValue(ctx.body(), Account.class);
    Account newlogin = accountService.PostLogins(account.getUsername(), account.getPassword());
    System.out.println(newlogin);
    if(newlogin != null ){
        ctx.json(om.writeValueAsString(newlogin));
         ctx.status(200);
     }else{
        ctx.status(401);
    }
}

    private void PostNewMessageHandler(Context ctx) throws JsonProcessingException
    {
        ObjectMapper mapper = new ObjectMapper();
        Message message = mapper.readValue(ctx.body(), Message.class);
        Message newMessage = messageService.InsertNewMessages(message);
        if(newMessage !=null){
            ctx.json(mapper.writeValueAsString(newMessage));
            ctx.status(200); 
        }else{
            ctx.status(400);
        }
     }
    public void GetAllNewMessageHandler(Context ctx) throws JsonProcessingException 
    {
        List <Message> messages = messageService.getAllMessage();
        ctx.json(messages);
    }

public void GetMessagebyIDHandler(Context ctx) throws JsonProcessingException {
    ObjectMapper om = new ObjectMapper();
    int message_id = Integer.parseInt(ctx.pathParam("message_id"));
    Message listmessage = messageService.getMessageById(message_id);
     if(listmessage!=null){
     ctx.json(listmessage);
     }}
public void DeleteMessagebyIDHandler(Context ctx) throws JsonProcessingException{
    
    int message_id = Integer.parseInt(ctx.pathParam("message_id"));
    Message message=messageService.deletebyid(message_id);
    if(message!= null){
     ctx.json(message);
    }else{
      ctx.status(200);
    }  
    }
public void UpdatebyIDHandler(Context ctx) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
        Message message = mapper.readValue(ctx.body(), Message.class);
        int updatedMessage = Integer.parseInt(ctx.pathParam("message_id")); 
        Message existingMessage = messageService.updateMessages(updatedMessage, message);
        if(existingMessage == null || existingMessage.message_text.isBlank())
        {
            ctx.status(400); 
        } 
        else
        {
            ctx.json(existingMessage); 
        }
            
}
private void GetMessagesbyAccountIdHandler(Context ctx) throws JsonProcessingException {
    int posted_by = Integer.parseInt(ctx.pathParam("account_id"));
    List<Message>messages=messageService.GetMeesagesbyAcccountid(posted_by);
    ctx.json(messages);
}
}
