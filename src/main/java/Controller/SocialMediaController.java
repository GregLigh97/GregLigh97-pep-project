package Controller;

import org.eclipse.jetty.util.security.Password;

import com.fasterxml.jackson.databind.ObjectMapper;

import Model.Account;
import Model.Message;
import io.javalin.Javalin;
import io.javalin.http.Context;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller. The endpoints you will need can be
 * found in readme.md as well as the test cases. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
public class SocialMediaController {
    /**
     * In order for the test cases to work, you will need to write the endpoints in the startAPI() method, as the test
     * suite must receive a Javalin object from this method.
     * @return a Javalin app object which defines the behavior of the Javalin controller.
     */
    public Javalin startAPI() {
        Javalin app = Javalin.create();
        app.post("/Message/", ctx -> {
            String jsonString = ctx.body();
            ObjectMapper om = new ObjectMapper();
            Message messages  = om.readValue(jsonString, Message.class);
            ctx.status(200);
        });
        app.post("/Message/", ctx -> {
        String jsonString = ctx.body();
        ObjectMapper om = new ObjectMapper();
        Message messages = om.readValue(jsonString, Message.class);
        ctx.contentType("application/json");
        ctx.status(400);
        });
        app.post("/Message/", ctx -> {
        String jsonString = ctx.body();
        ObjectMapper om = new ObjectMapper();
        Message messages = om.readValue(jsonString, Message.class);
        ctx.contentType("application/json");
        ctx.status(200);    
       });
       app.post(null, null)
   }
   private void Message(Context ctx) throws JsonProcessingException {
    String jsonString = ctx.body();
    ObjectMapper om = new ObjectMapper();
    Message messages = om.readValue(jsonString, Message.class);
    if(username = !null && Password == 4 && Account == null){
        ctx.status(200);
    }else{
    ctx.status(400);
 {
}
}
}
}