package Controller;

import io.javalin.Javalin;
import io.javalin.http.Context;

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
    app.post("/Account",CreateNewUsersHandler);
    app.post("/Account", ProcessUserLogingsHandler);
    app.post("/Message", InsertNewMessageHnadler);
    app.get("/Message", GetAllNewMessageHandler);
    app.get("/Message", GetMessagebyIDHandler);
    app.delete("/Message", DeleteMessagebyIDHandler);
    app.put("/Message", UpdatebyIDHandler);
    app.get("/Message", GetMessagebyUserid);
    app.start(8080);
    return app;
    }
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
}