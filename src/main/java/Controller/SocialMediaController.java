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
        
        return app;
    }
    
    private void PostRegisterHandler(Context ctx) throws JsonProcessingException
    {
        ObjectMapper om = new ObjectMapper();
        Account account = om.readValue(ctx.body(), Account.class);
        Account addedAccount = accountService.addAccount(account);
        if(addedAccount != null)
        {
        ctx.json(om.writeValueAsString(addedAccount));
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
    if(newlogin != null){
        ctx.json(om.writeValueAsString(newlogin));
         ctx.status(200);
     }else{
        ctx.status(401);
    }
}

    private void PostNewMessageHandler(Context ctx) throws JsonProcessingException
    {
        ObjectMapper om = new ObjectMapper();
        Message message = om.readValue(ctx.body(), Message.class);
       // Message newmessage = messageService.InsertNewMessages(message.getMessage_id(), message.getMessage_text());
      if(message.getMessage_text().isBlank()){
      ctx.status(400);
      return;
      }
      Message newmessage =  messageService.InsertNewMessages(message);
      if(newmessage != null){
        ctx.json(om.writeValueAsString(newmessage));
        ctx.status(200);
        }else{
        ctx.status(400);
    }
    }
}