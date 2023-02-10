package Controller;

import io.javalin.Javalin;
import io.javalin.http.Context;

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

/**
 * TODO: You will need to write your own endpoints and handlers for your controller. The endpoints you will need can be
 * found in readme.md as well as the test cases. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
public class SocialMediaController {
AccountService accountService;
MessageService messageService;


    public Javalin startAPI(){
    Javalin app = Javalin.create();
    app.post("/register",this:: CreateNewUsersHandler);
    app.post("/login", this:: ProcessUserLogingsHandler);
    app.post("/messages",this:: PostNewMessageHandler);
    app.get("/messages",this:: GetAllNewMessageHandler);
    app.get("/messages/{message_id}",this:: GetMessagebyIDHandler);
    app.delete("/messages/{message_id}",this:: DeleteMessagebyIDHandler);
    app.post("/message/{message_id}",this:: UpdatebyIDHandler);
   app.get("/accounts/{account_id}",this:: GetMessagebyUseridHandler);
    return app;
    }
private void CreateNewUsersHandler(Context ctx) throws JsonProcessingException {
    ObjectMapper om = new ObjectMapper();
    Account account = om.readValue(ctx.body(), Account.class);
    if(account!=null ){
      ctx.json(om.writeValueAsString(account));
    }else{
        ctx.status(400);
    }
}

 private void ProcessUserLogingsHandler(Context ctx) throws JsonProcessingException {
     ObjectMapper om = new ObjectMapper();
     Account account = om.readValue(ctx.body(), Account.class);
     Account postlogins = accountService.ProcessUserLogins(account);
     if(postlogins == null || account== null & account.getPassword().equalsIgnoreCase(null)){
         ctx.status(401);
     }else{
         ctx.json(om.writeValueAsString(postlogins));
     }
 }
 private void PostNewMessageHandler(Context ctx) throws JsonProcessingException {
     ObjectMapper om = new ObjectMapper();
     Message message = om.readValue(ctx.body(), Message.class);
     if(message != null){
         ctx.status(400);
     }else{
         ctx.json(om.writeValueAsString(message));
     }
 }
  public void GetAllNewMessageHandler(Context ctx)throws JsonProcessingException {
     Message messages = messageService.GetAllMessage();
     ctx.json(messages);
  }
  public void GetMessagebyIDHandler(Context ctx) throws JsonProcessingException {
    ObjectMapper om = new ObjectMapper();
    Message message_id = om.readValue(ctx.body(), Message.class);
    if(message_id != null){
    ctx.status(200);
     }else{
         ctx.json(message_id);
     }
  }
 public void DeleteMessagebyIDHandler(Context ctx) throws JsonMappingException, JsonProcessingException{
    ObjectMapper om = new ObjectMapper();
    Message message = messageService.GetMessagebyId(Integer.parseInt(ctx.pathParam("message_id")));
    if(message != null) {
        message = om.readValue(ctx.body(), Message.class);
    }
    Message delete = messageService.DeleteMessagebyId(message.getMessage_id());
    if (delete != null) {
     ctx.json(delete);
    } else {
        ctx.status(200);
        ctx.json(delete);
    }
 }

 public void UpdatebyIDHandler(Context ctx) throws JsonProcessingException {
     ObjectMapper om = new ObjectMapper();
     Message message = om.readValue(ctx.body(), Message.class);
     int message_id = Integer.parseInt(ctx.pathParam("message_id"));
     Message UpdatedMessage = messageService.UpdatebyId(message_id, message);
     System.out.println(UpdatedMessage);
     if(UpdatedMessage == null){
         ctx.status(400);
     } else {
         ctx.json(om.writeValueAsString(UpdatedMessage));
     }
 }
 public void GetMessagebyUseridHandler(Context ctx) {
  Message messages = messageService.GetMessagebyId(Integer.parseInt(ctx.pathParam("message_id")));
  ctx.json(messages);
 }
 }