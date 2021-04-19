//package lk.sliit.PAF.user.model;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//public class BuyerModel {
//    public static Connection connect(){
//        Connection connection = null;
//        try{
//            Class.forName("com.mysql.jdbc.Driver");
//            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "1234");
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return connection;
//    }
//
//    public int getLastBuyerId() throws Exception {
//        ResultSet resultSet = CrudUtil.execute("SELECT id FROM buyers ORDER BY id DESC LIMIT 1");
//        if(resultSet.next()){
//            return resultSet.getInt(1);
//        }
//        else {
//            return 0;
//        }
//    }
//
//    public String insertBuyerDetail(String fName, String lName, String email, String contactNo, String address, String zipCode, String pass){
//        String output = "";
//        try{
//            Connection connection = connect();
//            int id = getLastBuyerId();
//            if(connection == null){
//                return "Error connecting to the database";
//            }
//            String query = "insert into buyers (`id`, `fName`, `lName`, `email`, `contactNo`, `address` , `zipCode` , `pass`) values(?,?,?,?,?,?,?,?)";
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//
//            preparedStatement.setInt(1, id+1);
//            preparedStatement.setString(2, fName);
//            preparedStatement.setString(3, lName);
//            preparedStatement.setString(4, email);
//            preparedStatement.setString(5, contactNo);
//            preparedStatement.setString(6, address);
//            preparedStatement.setString(7, zipCode);
//            preparedStatement.setString(8, pass);
//
//            preparedStatement.execute();
//            connection.close();
//            output = "Buyer registered Successfully";
//        }catch(Exception e){
//            output = "Error while registering buyer";
//            e.printStackTrace();
//        }
//        return  output;
//    }
//}
