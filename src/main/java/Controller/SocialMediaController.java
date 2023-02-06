package Controller;

import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    app.post("/Account",this:: CreateNewUsersHandler);
    app.post("/Account", this:: ProcessUserLogingsHandler);
    app.post("/messages",this:: PostNewMessageHandler);
    app.get("/messages",this:: GetAllNewMessageHandler);
    app.get("/messages",this:: GetMessagebyIDHandler);
    app.delete("/Messages",this:: DeleteMessagebyIDHandler);
    app.put("/Message",this:: UpdatebyIDHandler);
    app.get("/Message",this:: GetMessagebyUseridHandler);
    app.start(8080);
    return app;
    }
private void CreateNewUsersHandler(Context ctx) throws JsonProcessingException {
    ObjectMapper om = new ObjectMapper();
    Account account = om.readValue(ctx.body(), Account.class);
    Account addedAccount = accountService.CreateNewUsers(account);
     if(addedAccount!=null){
       ctx.status(200);
   }else{
       ctx.json(om.writeValueAsString(addedAccount));
   }
}
private void ProcessUserLogingsHandler(Context ctx) throws JsonProcessingException {
    ObjectMapper om = new ObjectMapper();
    Account account = om.readValue(ctx.body(), Account.class);
    Account addedaccount = accountService.ProcessUserLogins(account);
    if(addedaccount != null){
        ctx.status(200);
    }else{
        ctx.json(om.writeValueAsString(addedaccount));
    }
}
private void PostNewMessageHandler(Context ctx) throws JsonProcessingException {
    ObjectMapper om = new ObjectMapper();
    Message message = om.readValue(ctx.body(), Message.class);
    Message addedmessage = messageService.InsertNewMessages(message);
    if(addedmessage != null){
        ctx.status(400);
    }else{
        ctx.json(om.writeValueAsString(addedmessage));
    }
}
 public void GetAllNewMessageHandler(Context ctx)throws JsonProcessingException {
    Message messages = messageService.GetAllMessage();
    ctx.json(messages);
 }
 public void GetMessagebyIDHandler(Context ctx){
    Message messages = messageService.GetMessagebyId(Integer.parseInt(ctx.pathParam("message_id")));
    ctx.json(messages);
 }
public void DeleteMessagebyIDHandler(Context ctx){
   Message messages = messageService.DeleteMessagebyId(Integer.parseInt(ctx.pathParam("message_id")));
   ctx.json(messages);
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