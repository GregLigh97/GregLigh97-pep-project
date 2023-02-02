

public class Messages{


public List<Messages>getAllMessages(){
    Connection connection = ConnectionUtil.getConnection();
    List<Messages> messages = new ArrayList<>();
    try {
       
        String sql =;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        while(rs.next()){
        Messages messages = new Messagesrs(rs.getInt("Account_id")), (rs.getInt("Message_id"))  rs.getString("Message_text"));
        Messages.add(messages);
}
}catch(SQLException e){
    System.out.println(e.getMessage());
}


public Messages getAccountByaccount_id(int account_id){
    Connection connection = ConnectionUtil.getConnection();
    try {
        String sql =;
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.executeUpdate();
        ResultSet pkeyResultSet = preparedStatement.getGeneratedKeys();
        if(pkeyResultSet.next()){
        int generated_messages_id = (int) pkeyResultSet.getLong(1);
        return new Messages (generated_message_id, message.getName());
    }
}catch(SQLException e){
    System.out.println(e.getAllMessages());
}
return null;
}
}