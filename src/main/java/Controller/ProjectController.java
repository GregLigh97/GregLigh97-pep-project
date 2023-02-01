package Controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import Model.Message;
import io.javalin.Javalin;

public class ProjectController {
Javalin app;
public ProjectController(){
Javalin app = Javalin.create();
}
public void startAPI(){
app.get("/Message", ctx-> {
String jsonString = ctx.body();
ObjectMapper om = new ObjectMapper();
Message message = om.readValue(jsonString, Message.class);
ctx.contentType("application/jsong");
ctx.result(Message.getAllMessages());
}
}
public void startAPI() {
app.post("/MessageNonExistent", ctx-> {
String jsonString = ctx.body();
ObjectMapper om = new ObjectMapper();
Message message = om.readValue(jsonString, Message.class);
ctx.contentType("application/jsong");
}

ctx.result(Message.getAllMessages());