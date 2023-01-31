

public class Messages{


public List<Messages>getAllMessages(){
    Connection connection = ConnectionUtil.getConnection();
    List<Messages> message = new ArrayList<>();
    try {
        //Write SQL logic here
        String sql =;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        while(rs.next()){
        Messages message = new Messagesrs(rs.getInt("Message_id")),  rs.getString("Message_text"));
        Messages.add(message);
}
}catch(SQLException e){
    System.out.println(e.getMessage());
}


public Messages insertMessages(Messages message){
    Connection connection = ConnectionUtil.getConnection();
    try {
        String sql =;
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.executeUpdate();
        ResultSet pkeyResultSet = preparedStatement.getGeneratedKeys();
        if(pkeyResultSet.next()){
        int generated_message_id = (int) pkeyResultSet.getLong(1);
        return new Messages (generated_message_id, message.getName());
    }
}catch(SQLException e){
    System.out.println(e.getMessage());
}
return null;
}
}